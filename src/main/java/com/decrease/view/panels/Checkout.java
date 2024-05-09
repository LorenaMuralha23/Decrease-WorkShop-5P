package com.decrease.view.panels;

import com.decrease.EcommerceT1LpApplication;
import com.decrease.controller.SessionController;
import com.decrease.entities.Order;
import com.decrease.entities.Payment;
import com.decrease.entities.User;
import com.decrease.model.Alerts;
import com.decrease.view.MainFrame;
import java.time.Instant;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Classe que representa o painel de checkout em uma aplicação de comércio
 * eletrônico. Este painel permite que o usuário confirme seu pedido, forneça
 * informações de pagamento e finalize a compra.
 */
public class Checkout extends javax.swing.JPanel {

    /**
     * Modelo do ComboBox para os meses de vencimento.
     */
    private DefaultComboBoxModel<String> monthModel;
    /**
     * Modelo do ComboBox para os anos de vencimento.
     */
    private DefaultComboBoxModel<String> yearModel;
    /**
     * Documento para restringir o número máximo de caracteres em campos de
     * texto.
     */
    private PlainDocument doc;
    /**
     * Usuário logado atualmente.
     */
    private User userLogged;

    /**
     * Construtor da classe Checkout. Inicializa o painel de checkout e
     * configura os campos e modelos.
     */
    public Checkout() {
        initComponents();
        userLogged = EcommerceT1LpApplication.mainFrame.userController.getUserLogged(SessionController.getInstance());
        initFieldConstraints();
        initComboBoxes();

        lbOrderOwner.setText(EcommerceT1LpApplication.mainFrame.userController.getUserLogged(SessionController.getInstance()).getName());
        lbAmountItems.setText(String.valueOf(userLogged.getCart().getItems().size()) + " ITEMS");
        lbSubtotalItems.setText("R$ " + String.valueOf(userLogged.getCart().getSubtotal()));
        setTotalCost();
    }

    /**
     * Método para restringir o número máximo de caracteres em campos de texto.
     *
     * @param maxCharacters O número máximo de caracteres permitidos.
     * @param txtField O campo de texto a ser restrito.
     */
    public void restrictFields(int maxCharacters, JTextField txtField) {
        doc = new PlainDocument() {
            @Override
            public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
                if (str != null && str.matches("\\d+") && getLength() + str.length() <= maxCharacters) {
                    super.insertString(offs, str, a);

                } else {

                    if (!str.matches("\\d+")) {
                        String msg = """
                            Values other than numbers are not allowed in the fields.
                            You can re-enter your details if they are incorrect.
                            """;

                        Alerts.showAlertMessage(msg, "Alert", null);
                    }

                    if (getLength() + str.length() > maxCharacters) {
                        String msg = """
                            The character limit allowed in the field has been exceeded.
                            You can re-enter your details if they are incorrect.
                            """;

                        Alerts.showAlertMessage(msg, "Alert", null);

                    }
                }
            }
        };

        txtField.setDocument(doc);

    }

    /**
     * Método para inicializar as restrições de campos.
     */
    public void initFieldConstraints() {
        restrictFields(16, tfCardNum);
        restrictFields(3, tfCVC);
    }

    /**
     * Método para inicializar os ComboBoxes.
     */
    public void initComboBoxes() {
        String[] months = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

        monthModel = new DefaultComboBoxModel(months);
        cbMonthDueDate.setModel(monthModel);

        String[] years = new String[10];
        for (int i = 0; i < years.length; i++) {
            years[i] = String.valueOf(2024 + i);
        }

        yearModel = new DefaultComboBoxModel(years);
        cbYearDueDate.setModel(yearModel);

        startInstallmentNum();
    }

    /**
     * Método para iniciar o número de parcelas disponíveis com base no subtotal
     * do carrinho.
     */
    public void startInstallmentNum() {
        double subtotal = EcommerceT1LpApplication.mainFrame.cartController.getSubtotal(SessionController.getInstance());
        int numInstallments = EcommerceT1LpApplication.mainFrame.cartController.calculateInstallments(subtotal);

        cbInstallments.removeAllItems();

        for (int i = 1; i <= numInstallments; i++) {
            double installmentValue = subtotal / i;
            String installmentText = i + "x de R$" + String.format("%.2f", installmentValue);
            cbInstallments.addItem(installmentText);
        }
    }

    /**
     * Método para extrair apenas os números de um JLabel.
     *
     * @param label O JLabel do qual extrair os números.
     * @return A parte numérica do texto do JLabel.
     */
    public String extractNumFromLabel(JLabel label) {
        String text = label.getText();
        String numericPart = text.replaceAll("[^\\d.]", "");
        return numericPart;
    }

    /**
     * Método para calcular o custo total da compra.
     */
    public void setTotalCost() {
        Double total, subtotal, shipping;
        subtotal = Double.parseDouble(extractNumFromLabel(lbSubtotalItems));
        shipping = Double.parseDouble(extractNumFromLabel(lbTotalShipping));
        total = subtotal + shipping;
        lbTotalCost.setText("R$ " + String.valueOf(total));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        paymentMethods = new javax.swing.ButtonGroup();
        lbIconQrCode = new javax.swing.JLabel();
        lbBackToCart = new javax.swing.JLabel();
        lbIconLogo = new javax.swing.JLabel();
        lbTitle = new javax.swing.JLabel();
        lbTitlePayment = new javax.swing.JLabel();
        lbTitleOrderSum = new javax.swing.JLabel();
        lbAmountItems = new javax.swing.JLabel();
        lbSubtotalItems = new javax.swing.JLabel();
        lbCardNum = new javax.swing.JLabel();
        lbTotalShipping = new javax.swing.JLabel();
        tp1stTxt = new javax.swing.JTextPane();
        lbTitleTotalCost = new javax.swing.JLabel();
        lbTotalCost = new javax.swing.JLabel();
        lbOrderOwner = new javax.swing.JLabel();
        rbMastercard = new javax.swing.JRadioButton();
        lbIconMastercard = new javax.swing.JLabel();
        rbVisa = new javax.swing.JRadioButton();
        lbIconVisa = new javax.swing.JLabel();
        lbTitleShipping = new javax.swing.JLabel();
        tfCardNum = new javax.swing.JTextField();
        lbCardHolder = new javax.swing.JLabel();
        tfCardholder = new javax.swing.JTextField();
        lbDueDate = new javax.swing.JLabel();
        cbYearDueDate = new javax.swing.JComboBox<>();
        cbMonthDueDate = new javax.swing.JComboBox<>();
        lbCVC = new javax.swing.JLabel();
        tfCVC = new javax.swing.JTextField();
        lbInstallments = new javax.swing.JLabel();
        cbInstallments = new javax.swing.JComboBox<>();
        lbTitleOrderOwner = new javax.swing.JLabel();
        lbConfirmPayment = new javax.swing.JLabel();
        lbAddress = new javax.swing.JLabel();
        tfAddress = new javax.swing.JTextField();
        lbNum = new javax.swing.JLabel();
        tfNum = new javax.swing.JTextField();
        tfState = new javax.swing.JTextField();
        lbState = new javax.swing.JLabel();
        rdPix = new javax.swing.JRadioButton();
        lbIconPix = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 600));
        setMinimumSize(new java.awt.Dimension(1280, 600));
        setPreferredSize(new java.awt.Dimension(1280, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIconQrCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconQrCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/qrCode.png"))); // NOI18N
        add(lbIconQrCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 140, 140));

        lbBackToCart.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbBackToCart.setForeground(new java.awt.Color(172, 74, 213));
        lbBackToCart.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbBackToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/leftArrow.png"))); // NOI18N
        lbBackToCart.setText("BACK TO CART");
        lbBackToCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBackToCart.setIconTextGap(7);
        lbBackToCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBackToCartMouseClicked(evt);
            }
        });
        add(lbBackToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 130, -1));

        lbIconLogo.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        lbIconLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/logoPNG.png"))); // NOI18N
        add(lbIconLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 200));

        lbTitle.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitle.setText("Finishing your order");
        lbTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitle.setIconTextGap(7);
        add(lbTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 180, -1));

        lbTitlePayment.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbTitlePayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitlePayment.setText("PAYMENT METHOD");
        lbTitlePayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitlePayment.setIconTextGap(7);
        add(lbTitlePayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 110, -1));

        lbTitleOrderSum.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lbTitleOrderSum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleOrderSum.setText("Order Summary");
        lbTitleOrderSum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleOrderSum.setIconTextGap(7);
        add(lbTitleOrderSum, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, 250, -1));

        lbAmountItems.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbAmountItems.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbAmountItems.setText("- ITEMS");
        lbAmountItems.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAmountItems.setIconTextGap(7);
        add(lbAmountItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 190, 80, -1));

        lbSubtotalItems.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbSubtotalItems.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSubtotalItems.setText("R$ -");
        lbSubtotalItems.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSubtotalItems.setIconTextGap(7);
        add(lbSubtotalItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 190, 80, -1));

        lbCardNum.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbCardNum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCardNum.setText("Card Number");
        lbCardNum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCardNum.setIconTextGap(7);
        add(lbCardNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 90, 30));

        lbTotalShipping.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbTotalShipping.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTotalShipping.setText("R$ 15.00");
        lbTotalShipping.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTotalShipping.setIconTextGap(7);
        add(lbTotalShipping, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 230, 80, -1));

        tp1stTxt.setEditable(false);
        tp1stTxt.setBackground(new java.awt.Color(250, 250, 250));
        tp1stTxt.setBorder(null);
        tp1stTxt.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        tp1stTxt.setText("You can also pay for your order using the QR code, simply select the pix payment option and scan the QR code with your phone. Once payment is complete, the order will be ready to be shipped to you.");
        tp1stTxt.setFocusable(false);
        tp1stTxt.setOpaque(false);
        add(tp1stTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 400, 140));

        lbTitleTotalCost.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbTitleTotalCost.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitleTotalCost.setText("TOTAL COST");
        lbTitleTotalCost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleTotalCost.setIconTextGap(7);
        add(lbTitleTotalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 370, 80, -1));

        lbTotalCost.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbTotalCost.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTotalCost.setText("R$ -");
        lbTotalCost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTotalCost.setIconTextGap(7);
        add(lbTotalCost, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 370, 60, -1));

        lbOrderOwner.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbOrderOwner.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(lbOrderOwner, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 140, 250, 30));

        paymentMethods.add(rbMastercard);
        rbMastercard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(rbMastercard, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, 40));

        lbIconMastercard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/mastercard.png"))); // NOI18N
        add(lbIconMastercard, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, -1, 40));

        paymentMethods.add(rbVisa);
        rbVisa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbVisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbVisaActionPerformed(evt);
            }
        });
        add(rbVisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, 40));

        lbIconVisa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/visa.png"))); // NOI18N
        add(lbIconVisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, -1, 40));

        lbTitleShipping.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbTitleShipping.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitleShipping.setText("SHIPPING");
        lbTitleShipping.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleShipping.setIconTextGap(7);
        add(lbTitleShipping, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 230, 60, -1));

        tfCardNum.setBackground(new java.awt.Color(250, 250, 250));
        tfCardNum.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfCardNum.setForeground(new java.awt.Color(51, 51, 51));
        tfCardNum.setBorder(null);
        tfCardNum.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfCardNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 230, 30));

        lbCardHolder.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbCardHolder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCardHolder.setText("Cardholder");
        lbCardHolder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCardHolder.setIconTextGap(7);
        add(lbCardHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 70, 30));

        tfCardholder.setBackground(new java.awt.Color(250, 250, 250));
        tfCardholder.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfCardholder.setForeground(new java.awt.Color(51, 51, 51));
        tfCardholder.setBorder(null);
        tfCardholder.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfCardholder, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 190, 230, 30));

        lbDueDate.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbDueDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDueDate.setText("Due Date");
        lbDueDate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDueDate.setIconTextGap(7);
        add(lbDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 252, 70, 30));

        cbYearDueDate.setBackground(new java.awt.Color(250, 250, 250));
        cbYearDueDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbYearDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 252, 120, 30));

        cbMonthDueDate.setBackground(new java.awt.Color(250, 250, 250));
        cbMonthDueDate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbMonthDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 252, 120, 30));

        lbCVC.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbCVC.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbCVC.setText("CVC");
        lbCVC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCVC.setIconTextGap(7);
        add(lbCVC, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 30, 30));

        tfCVC.setBackground(new java.awt.Color(250, 250, 250));
        tfCVC.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfCVC.setForeground(new java.awt.Color(51, 51, 51));
        tfCVC.setBorder(null);
        tfCVC.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfCVC, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 250, 70, 30));

        lbInstallments.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbInstallments.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbInstallments.setText("Installments");
        lbInstallments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbInstallments.setIconTextGap(7);
        add(lbInstallments, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 314, 80, 30));

        cbInstallments.setBackground(new java.awt.Color(250, 250, 250));
        cbInstallments.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cbInstallments, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 314, 120, 30));

        lbTitleOrderOwner.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbTitleOrderOwner.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitleOrderOwner.setText("ORDER OWNER");
        lbTitleOrderOwner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleOrderOwner.setIconTextGap(7);
        add(lbTitleOrderOwner, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 110, 90, -1));

        lbConfirmPayment.setBackground(new java.awt.Color(0, 0, 0));
        lbConfirmPayment.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbConfirmPayment.setForeground(new java.awt.Color(255, 255, 255));
        lbConfirmPayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbConfirmPayment.setText("CONFIRM PAYMENT");
        lbConfirmPayment.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbConfirmPayment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbConfirmPayment.setOpaque(true);
        lbConfirmPayment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbConfirmPaymentMouseClicked(evt);
            }
        });
        add(lbConfirmPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 400, 250, 40));

        lbAddress.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbAddress.setText("Address");
        lbAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAddress.setIconTextGap(7);
        add(lbAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 260, 60, 30));

        tfAddress.setBackground(new java.awt.Color(250, 250, 250));
        tfAddress.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfAddress.setForeground(new java.awt.Color(51, 51, 51));
        tfAddress.setBorder(null);
        tfAddress.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 260, 250, 30));

        lbNum.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbNum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbNum.setText("Number");
        lbNum.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbNum.setIconTextGap(7);
        add(lbNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 310, 60, 30));

        tfNum.setBackground(new java.awt.Color(250, 250, 250));
        tfNum.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfNum.setForeground(new java.awt.Color(51, 51, 51));
        tfNum.setBorder(null);
        tfNum.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 310, 90, 30));

        tfState.setBackground(new java.awt.Color(250, 250, 250));
        tfState.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfState.setForeground(new java.awt.Color(51, 51, 51));
        tfState.setBorder(null);
        tfState.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfState, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 310, 90, 30));

        lbState.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbState.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbState.setText("State");
        lbState.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbState.setIconTextGap(7);
        add(lbState, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 310, 40, 30));

        paymentMethods.add(rdPix);
        rdPix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(rdPix, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, 40));

        lbIconPix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/pix.png"))); // NOI18N
        add(lbIconPix, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, -1, 40));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/backgrounds/checkout.png"))); // NOI18N
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, -1, 600));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento de clique no rótulo de confirmação de pagamento.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbConfirmPaymentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbConfirmPaymentMouseClicked
        String msg = "";

        if (paymentMethods.getSelection() != null
                && !tfCardNum.getText().isEmpty()
                && !tfCardholder.getText().isEmpty()
                && !tfCVC.getText().isEmpty()
                && !tfAddress.getText().isEmpty()
                && !tfNum.getText().isEmpty()
                && !tfState.getText().isEmpty()) {

            msg
                    = """
                Confirm your order before closing!
                Are you sure you want to confirm the order?
                """;

            int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

            if (option == 0) {
//                msg = 
//                    """
//                    We at Decrease thank you for your preference!
//                    Your order is now being prepared to be shipped to you.
//                    To the next!
//                    """;
//
//                Alerts.showSuccessMessage(msg, "Thank You!", null);
                
                
                //Transformar o carrinho em um pedido
                Order orderToSave = EcommerceT1LpApplication.mainFrame.cartController.covertCartToOrder(SessionController.getInstance());
                
                Payment payment = new Payment();
                payment.setOrder(orderToSave);
                if (rbMastercard.isSelected() || rbVisa.isSelected()){
                    payment.setType(1);
                }else{
                    payment.setType(2);
                }
                orderToSave.setPayment(payment);
                
                //Registrar pedido no banco de dados
                EcommerceT1LpApplication.mainFrame.orderController.saveOrder(orderToSave);
                
                EcommerceT1LpApplication.mainFrame.cartController.cleanCart(SessionController.getInstance().getUserLogged());

                // Loxon Modificações :) : troquei para ir para a tela de teste
                // MainFrame.home = new Home();
                // EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
                MainFrame.finishedOrder = new FinishedOrderTest();
                EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.finishedOrder);

            }

        } else {
            msg
                    = """
                You forgot to fill in a field!
                Please review your information so we can finalize your payment.
                """;

            Alerts.showAlertMessage(msg, "Alert!", null);
        }

    }//GEN-LAST:event_lbConfirmPaymentMouseClicked

    /**
     * Evento de clique no rótulo de voltar ao carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbBackToCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackToCartMouseClicked
        String msg
                = """
                Are you sure you want to go back?
                Your completed data will be lost.
                """;

        int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

        if (option == 0) {
            MainFrame.cart = new Cart();
            EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.cart);
        }
    }//GEN-LAST:event_lbBackToCartMouseClicked

    private void rbVisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbVisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbVisaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbInstallments;
    private javax.swing.JComboBox<String> cbMonthDueDate;
    private javax.swing.JComboBox<String> cbYearDueDate;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbAmountItems;
    private javax.swing.JLabel lbBackToCart;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbCVC;
    private javax.swing.JLabel lbCardHolder;
    private javax.swing.JLabel lbCardNum;
    private javax.swing.JLabel lbConfirmPayment;
    private javax.swing.JLabel lbDueDate;
    private javax.swing.JLabel lbIconLogo;
    private javax.swing.JLabel lbIconMastercard;
    private javax.swing.JLabel lbIconPix;
    private javax.swing.JLabel lbIconQrCode;
    private javax.swing.JLabel lbIconVisa;
    private javax.swing.JLabel lbInstallments;
    private javax.swing.JLabel lbNum;
    private javax.swing.JLabel lbOrderOwner;
    private javax.swing.JLabel lbState;
    private javax.swing.JLabel lbSubtotalItems;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lbTitleOrderOwner;
    private javax.swing.JLabel lbTitleOrderSum;
    private javax.swing.JLabel lbTitlePayment;
    private javax.swing.JLabel lbTitleShipping;
    private javax.swing.JLabel lbTitleTotalCost;
    private javax.swing.JLabel lbTotalCost;
    private javax.swing.JLabel lbTotalShipping;
    private javax.swing.ButtonGroup paymentMethods;
    private javax.swing.JRadioButton rbMastercard;
    private javax.swing.JRadioButton rbVisa;
    private javax.swing.JRadioButton rdPix;
    private javax.swing.JTextField tfAddress;
    private javax.swing.JTextField tfCVC;
    private javax.swing.JTextField tfCardNum;
    private javax.swing.JTextField tfCardholder;
    private javax.swing.JTextField tfNum;
    private javax.swing.JTextField tfState;
    private javax.swing.JTextPane tp1stTxt;
    // End of variables declaration//GEN-END:variables
}
