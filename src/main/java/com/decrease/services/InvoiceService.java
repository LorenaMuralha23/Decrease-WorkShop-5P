package com.decrease.services;

import com.decrease.controller.CartController;
import com.decrease.controller.ProductController;
import com.decrease.controller.SessionController;
import com.decrease.entities.CartItem;
import com.decrease.entities.Order;
import com.decrease.entities.OrderItem;
import com.decrease.entities.Product;
import com.decrease.entities.User;
import com.decrease.interfaces.invoicePrinter;
import com.decrease.repositories.OrderItemRepository;
import com.decrease.repositories.OrderRepository;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.Leading;
import com.itextpdf.layout.properties.ListNumberingType;
import com.itextpdf.layout.properties.Property;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.itextpdf.layout.properties.VerticalAlignment;
import jakarta.transaction.Transactional;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService implements invoicePrinter {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductController productController;
    
    @Autowired
    private CartController cartController;
    
    private String rootPath;
    private float width = 0;
    private float height = 0;

    public InvoiceService() {
        this.width = 98.0f;
        this.height = 88.0f;

    }

    @Transactional
    public void generateInvoice(String rootPathToSave) {
        this.rootPath = rootPathToSave;
        Long lastOrderId = orderRepository.findMaxOrderId();
        Optional<Order> orderObj = orderRepository.findById(lastOrderId);
        if (!orderObj.isEmpty()) {
            Order order = orderObj.get();
            List<OrderItem> orderItems = orderItemRepository.findByOrderId(lastOrderId);
            User userLogged = SessionController.getInstance().getUserLogged();
            PdfWriter writer = (PdfWriter) configPDFGenerator(userLogged, order);

            PdfDocument pdf = new PdfDocument(writer);
            try {
                Document doc = new Document(pdf);

                // Fonte padrão
                PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
                PdfFont boldFont = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

                // Estilos
                Style normal = new Style().setFont(font).setFontSize(12);
                Style bold = new Style().setFont(boldFont).setFontSize(12);
                Style header = new Style().setFont(boldFont).setFontSize(20);
                Style tableHeader = new Style().setFont(boldFont).setFontSize(12).setBackgroundColor(new DeviceRgb(230, 230, 230)).setTextAlignment(TextAlignment.CENTER);
                Style cellStyle = new Style().setFont(font).setFontSize(12).setTextAlignment(TextAlignment.CENTER);

                // Logo
                Image logo = new Image(ImageDataFactory.create("src/main/resources/com/decrease/view/images/icons/logoPNG.png"));
                logo.setWidth(100);
                logo.setHeight(100);

                // Cabeçalho com logomarca e informações da empresa
                Table headerTable = new Table(UnitValue.createPercentArray(new float[]{1, 4, 1}));
                headerTable.setWidth(UnitValue.createPercentValue(100));
                headerTable.addCell(new Cell().add(logo).setBorder(Border.NO_BORDER).setVerticalAlignment(VerticalAlignment.MIDDLE));
                headerTable.addCell(new Cell().add(new Paragraph("Nota Fiscal").addStyle(header)).setTextAlignment(TextAlignment.CENTER).setVerticalAlignment(VerticalAlignment.MIDDLE).setBorder(Border.NO_BORDER));
                headerTable.addCell(new Cell().setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
                doc.add(headerTable);

                // Linha separadora
                doc.add(new Paragraph("\n"));

                // Informações da Empresa
                Table companyTable = new Table(1);
                companyTable.setWidth(UnitValue.createPercentValue(100));
                companyTable.addCell(new Cell().add(new Paragraph("Decrease Supplements\nCNPJ: 12.345.678/0001-99\nEndereço: Rua Exemplo, 123, Cidade, Estado\nTelefone: (11) 1234-5678").addStyle(normal)).setBorder(Border.NO_BORDER));
                doc.add(companyTable);

                // Linha separadora
                doc.add(new Paragraph("\n"));

                // Informações do Cliente
                Table clientTable = new Table(1);
                clientTable.setWidth(UnitValue.createPercentValue(100));
                clientTable.addCell(new Cell().add(new Paragraph("Cliente: " + userLogged.getName() + "\nTelefone: " + userLogged.getPhone() + "\nEndereço: " + userLogged.getAddress().getStreet() + ", " + userLogged.getAddress().getNumber() + ", " + userLogged.getAddress().getState()).addStyle(normal)).setBorder(Border.NO_BORDER));
                doc.add(clientTable);

                // Linha separadora
                doc.add(new Paragraph("\n"));

                // Tabela de Produtos
                float[] columnWidths = {1, 4, 1, 2, 2};
                Table productsTable = new Table(UnitValue.createPercentArray(columnWidths));
                productsTable.setWidth(UnitValue.createPercentValue(100));

                productsTable.addHeaderCell(new Cell().add(new Paragraph("Código").addStyle(tableHeader)).setBorder(Border.NO_BORDER));
                productsTable.addHeaderCell(new Cell().add(new Paragraph("Descrição").addStyle(tableHeader)).setBorder(Border.NO_BORDER));
                productsTable.addHeaderCell(new Cell().add(new Paragraph("Qtd").addStyle(tableHeader)).setBorder(Border.NO_BORDER));
                productsTable.addHeaderCell(new Cell().add(new Paragraph("Preço Unit.").addStyle(tableHeader)).setBorder(Border.NO_BORDER));
                productsTable.addHeaderCell(new Cell().add(new Paragraph("Total").addStyle(tableHeader)).setBorder(Border.NO_BORDER));

                int i = 0;
                
                for (OrderItem item : order.getOrderItems()) {
                    productsTable.addCell(new Cell().add(new Paragraph("00" + String.valueOf(i)).addStyle(cellStyle)).setBorder(Border.NO_BORDER));
                    productsTable.addCell(new Cell().add(new Paragraph(item.getProduct().getName()).addStyle(cellStyle)).setBorder(Border.NO_BORDER));
                    productsTable.addCell(new Cell().add(new Paragraph(String.valueOf(item.getQuantity())).addStyle(cellStyle)).setBorder(Border.NO_BORDER));
                    productsTable.addCell(new Cell().add(new Paragraph(String.valueOf("R$ " + item.getPrice())).addStyle(cellStyle)).setBorder(Border.NO_BORDER));
                    productsTable.addCell(new Cell().add(new Paragraph("R$ " + String.valueOf(item.getSubTotal())).addStyle(cellStyle)).setBorder(Border.NO_BORDER));
                    i++;
                }
                
                // Adiciona a tabela ao documento
                doc.add(productsTable);

                // Linha separadora
                doc.add(new Paragraph("\n"));

                // Total
                Paragraph total = new Paragraph("Total: R$ " + order.getTotal())
                        .addStyle(bold)
                        .setTextAlignment(TextAlignment.RIGHT);
                doc.add(total);

                // Fechar documento
                doc.close();

            } catch (IOException ex) {
                Logger.getLogger(InvoiceService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public Object configPDFGenerator(User user, Order orderToRegister) {
        PdfWriter writer = null;
        //padrão de nome do arquivo: idDoUser-IdDoPedido
        try {
            String filePath = this.rootPath.concat("\\" + user.getId().toString() + "-" + orderToRegister.getId().toString() + ".pdf");
            writer = new PdfWriter(filePath);
            return writer;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InvoiceService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
