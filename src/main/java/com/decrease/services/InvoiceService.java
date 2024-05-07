package com.decrease.services;

import com.decrease.controller.SessionController;
import com.decrease.entities.Order;
import com.decrease.entities.OrderItem;
import com.decrease.entities.User;
import com.decrease.repositories.OrderItemRepository;
import com.decrease.repositories.OrderRepository;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.Leading;
import com.itextpdf.layout.properties.Property;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    private String rootPath = ".\notas-fiscais-testes";
    private float width = 0;
    private float height = 0;

    public InvoiceService() {
        this.width = 98.0f;
        this.height = 88.0f;
    }

    public void generateInvoice() {
        //Pegar o id do último pedido adicionado
        Long lastOrderId = orderRepository.findMaxOrderId();
        //Achar o pedido usando esse id
        Optional<Order> orderObj = orderRepository.findById(lastOrderId);
        //Buscar a lista de itens desse pedido usando esse id
        if (!orderObj.isEmpty()) {
            Order order = orderObj.get();
            List<OrderItem> orderItems = orderItemRepository.findByOrderId(lastOrderId);
            User userLogged = SessionController.getInstance().getUserLogged();
            PdfWriter writer = (PdfWriter) configPDFGenerator();

            PdfDocument pdf = new PdfDocument(writer);
            //Definindo o tamanho do pdf
            try {
                Rectangle rectangle = new Rectangle(this.width, this.height);
                PageSize pageSize = new PageSize(rectangle);
                Document document = new Document(pdf);
                document.setMargins(01, 04, 01, 04);
                PdfFont textoPadrao = PdfFontFactory.createFont(StandardFonts.TIMES_ROMAN);
                PdfFont titulo = PdfFontFactory.createFont(StandardFonts.TIMES_BOLD);

                document.setFont(textoPadrao);
                document.setFontSize(5);
                document.setProperty(Property.LEADING, new Leading(Leading.MULTIPLIED, 0.2f));
                
                //Criando cabeçalho
                Paragraph linhaCabecalho = new Paragraph("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨")
                        .setFont(titulo)
                        .setFontSize(6);
                Paragraph linhaRodape = new Paragraph("------------------------------------------------------------")
                        .setFont(titulo)
                        .setFontSize(4);
                Paragraph linhaSeparador = new Paragraph("****************************************************")
                        .setFont(titulo)
                        .setFontSize(3);
                
                Paragraph companyDate = new Paragraph("Decrease Supplements"); 
                Paragraph clientDate = new Paragraph("Client: " + userLogged.getName());
                Paragraph paymentDate = new Paragraph("Payment type: " + order.getPayment().getType());
            } catch (IOException ex) {
                Logger.getLogger(InvoiceService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        //gerar a nota fiscal
    }

    public Object configPDFGenerator() {
        PdfWriter writer = null;
        try {
            writer = new PdfWriter(rootPath);
            return writer;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InvoiceService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
