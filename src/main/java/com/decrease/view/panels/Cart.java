package com.decrease.view.panels;

import com.decrease.EcommerceT1LpApplication;
import com.decrease.controller.SessionController;
import com.decrease.entities.CartItem;
import com.decrease.entities.Product;
import com.decrease.entities.User;
import com.decrease.model.Alerts;
import com.decrease.model.CustomException;
import com.decrease.view.MainFrame;
import java.awt.Image;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Classe que representa o painel de carrinho de compras em uma aplicação de
 * comércio eletrônico. Este painel exibe os itens no carrinho do usuário e
 * permite interações, como ajustar quantidades, remover itens, limpar o
 * carrinho e prosseguir para o checkout.
 */
public class Cart extends javax.swing.JPanel {

    /**
     * Usuário logado atualmente.
     */
    private User userLogged;

    /**
     * Itens do carrinho.
     */
    private CartItem cI1, cI2, cI3, cI4;

    /**
     * Lista de itens do carrinho.
     */
    private List<CartItem> itemList;

    /**
     * Construtor da classe Cart. Inicializa o painel e recupera os itens do
     * carrinho do usuário logado.
     */
    public Cart() {
        initComponents();
        userLogged = EcommerceT1LpApplication.mainFrame.userController.getUserLogged(SessionController.getInstance());
        initCartComponents();
        setText();
    }

    /**
     * Método para inicializar os componentes do carrinho.
     */
    public void initCartComponents() {
        int quantityOfItems;

        if (userLogged.getCart() == null || userLogged.getCart().getItems().isEmpty()) {

            String msg
                    = EcommerceT1LpApplication.msgManager.getMessage("empty-cart-alert");
            Alerts.showInformationMessage(msg, "Your Cart is Empty", null);

            lb1stItem.setVisible(false);
            lb1stName.setVisible(false);
            lb1stBrand.setVisible(false);
            lb1stMinus.setVisible(false);
            lb1stQnt.setVisible(false);
            lb1stPlus.setVisible(false);
            lb1stPrice.setVisible(false);
            lb1stTotal.setVisible(false);
            lbIcon1stRemove.setVisible(false);

            lb2ndItem.setVisible(false);
            lb2ndName.setVisible(false);
            lb2ndBrand.setVisible(false);
            lb2ndMinus.setVisible(false);
            lb2ndQnt.setVisible(false);
            lb2ndPlus.setVisible(false);
            lb2ndPrice.setVisible(false);
            lb2ndTotal.setVisible(false);
            lbIcon2ndRemove.setVisible(false);

            lb3rdItem.setVisible(false);
            lb3rdName.setVisible(false);
            lb3rdBrand.setVisible(false);
            lb3rdMinus.setVisible(false);
            lb3rdQnt.setVisible(false);
            lb3rdPlus.setVisible(false);
            lb3rdPrice.setVisible(false);
            lb3rdTotal.setVisible(false);
            lbIcon3rdRemove.setVisible(false);

            lb4thItem.setVisible(false);
            lb4thName.setVisible(false);
            lb4thBrand.setVisible(false);
            lb4thMinus.setVisible(false);
            lb4thQnt.setVisible(false);
            lb4thPlus.setVisible(false);
            lb4thPrice.setVisible(false);
            lb4thTotal.setVisible(false);
            lbIcon4thRemove.setVisible(false);

        } else {

            quantityOfItems = userLogged.getCart().getItems().size();

            switch (quantityOfItems) {
                case 1:
                    lb1stItem.setVisible(true);
                    lb1stName.setVisible(true);
                    lb1stBrand.setVisible(true);
                    lb1stMinus.setVisible(true);
                    lb1stQnt.setVisible(true);
                    lb1stPlus.setVisible(true);
                    lb1stPrice.setVisible(true);
                    lb1stTotal.setVisible(true);
                    lbIcon1stRemove.setVisible(true);

                    lb2ndItem.setVisible(false);
                    lb2ndName.setVisible(false);
                    lb2ndBrand.setVisible(false);
                    lb2ndMinus.setVisible(false);
                    lb2ndQnt.setVisible(false);
                    lb2ndPlus.setVisible(false);
                    lb2ndPrice.setVisible(false);
                    lb2ndTotal.setVisible(false);
                    lbIcon2ndRemove.setVisible(false);

                    lb3rdItem.setVisible(false);
                    lb3rdName.setVisible(false);
                    lb3rdBrand.setVisible(false);
                    lb3rdMinus.setVisible(false);
                    lb3rdQnt.setVisible(false);
                    lb3rdPlus.setVisible(false);
                    lb3rdPrice.setVisible(false);
                    lb3rdTotal.setVisible(false);
                    lbIcon3rdRemove.setVisible(false);

                    lb4thItem.setVisible(false);
                    lb4thName.setVisible(false);
                    lb4thBrand.setVisible(false);
                    lb4thMinus.setVisible(false);
                    lb4thQnt.setVisible(false);
                    lb4thPlus.setVisible(false);
                    lb4thPrice.setVisible(false);
                    lb4thTotal.setVisible(false);
                    lbIcon4thRemove.setVisible(false);

                    fillComponents();
                    break;

                case 2:
                    lb1stItem.setVisible(true);
                    lb1stName.setVisible(true);
                    lb1stBrand.setVisible(true);
                    lb1stMinus.setVisible(true);
                    lb1stQnt.setVisible(true);
                    lb1stPlus.setVisible(true);
                    lb1stPrice.setVisible(true);
                    lb1stTotal.setVisible(true);
                    lbIcon1stRemove.setVisible(true);

                    lb2ndItem.setVisible(true);
                    lb2ndName.setVisible(true);
                    lb2ndBrand.setVisible(true);
                    lb2ndMinus.setVisible(true);
                    lb2ndQnt.setVisible(true);
                    lb2ndPlus.setVisible(true);
                    lb2ndPrice.setVisible(true);
                    lb2ndTotal.setVisible(true);
                    lbIcon2ndRemove.setVisible(true);

                    lb3rdItem.setVisible(false);
                    lb3rdName.setVisible(false);
                    lb3rdBrand.setVisible(false);
                    lb3rdMinus.setVisible(false);
                    lb3rdQnt.setVisible(false);
                    lb3rdPlus.setVisible(false);
                    lb3rdPrice.setVisible(false);
                    lb3rdTotal.setVisible(false);
                    lbIcon3rdRemove.setVisible(false);

                    lb4thItem.setVisible(false);
                    lb4thName.setVisible(false);
                    lb4thBrand.setVisible(false);
                    lb4thMinus.setVisible(false);
                    lb4thQnt.setVisible(false);
                    lb4thPlus.setVisible(false);
                    lb4thPrice.setVisible(false);
                    lb4thTotal.setVisible(false);
                    lbIcon4thRemove.setVisible(false);

                    fillComponents();
                    break;

                case 3:
                    lb1stItem.setVisible(true);
                    lb1stName.setVisible(true);
                    lb1stBrand.setVisible(true);
                    lb1stMinus.setVisible(true);
                    lb1stQnt.setVisible(true);
                    lb1stPlus.setVisible(true);
                    lb1stPrice.setVisible(true);
                    lb1stTotal.setVisible(true);
                    lbIcon1stRemove.setVisible(true);

                    lb2ndItem.setVisible(true);
                    lb2ndName.setVisible(true);
                    lb2ndBrand.setVisible(true);
                    lb2ndMinus.setVisible(true);
                    lb2ndQnt.setVisible(true);
                    lb2ndPlus.setVisible(true);
                    lb2ndPrice.setVisible(true);
                    lb2ndTotal.setVisible(true);
                    lbIcon2ndRemove.setVisible(true);

                    lb3rdItem.setVisible(true);
                    lb3rdName.setVisible(true);
                    lb3rdBrand.setVisible(true);
                    lb3rdMinus.setVisible(true);
                    lb3rdQnt.setVisible(true);
                    lb3rdPlus.setVisible(true);
                    lb3rdPrice.setVisible(true);
                    lb3rdTotal.setVisible(true);
                    lbIcon3rdRemove.setVisible(true);

                    lb4thItem.setVisible(false);
                    lb4thName.setVisible(false);
                    lb4thBrand.setVisible(false);
                    lb4thMinus.setVisible(false);
                    lb4thQnt.setVisible(false);
                    lb4thPlus.setVisible(false);
                    lb4thPrice.setVisible(false);
                    lb4thTotal.setVisible(false);
                    lbIcon4thRemove.setVisible(false);

                    fillComponents();
                    break;

                default:
                    lb1stItem.setVisible(true);
                    lb1stName.setVisible(true);
                    lb1stBrand.setVisible(true);
                    lb1stMinus.setVisible(true);
                    lb1stQnt.setVisible(true);
                    lb1stPlus.setVisible(true);
                    lb1stPrice.setVisible(true);
                    lb1stTotal.setVisible(true);
                    lbIcon1stRemove.setVisible(true);

                    lb2ndItem.setVisible(true);
                    lb2ndName.setVisible(true);
                    lb2ndBrand.setVisible(true);
                    lb2ndMinus.setVisible(true);
                    lb2ndQnt.setVisible(true);
                    lb2ndPlus.setVisible(true);
                    lb2ndPrice.setVisible(true);
                    lb2ndTotal.setVisible(true);
                    lbIcon2ndRemove.setVisible(true);

                    lb3rdItem.setVisible(true);
                    lb3rdName.setVisible(true);
                    lb3rdBrand.setVisible(true);
                    lb3rdMinus.setVisible(true);
                    lb3rdQnt.setVisible(true);
                    lb3rdPlus.setVisible(true);
                    lb3rdPrice.setVisible(true);
                    lb3rdTotal.setVisible(true);
                    lbIcon3rdRemove.setVisible(true);

                    lb4thItem.setVisible(true);
                    lb4thName.setVisible(true);
                    lb4thBrand.setVisible(true);
                    lb4thMinus.setVisible(true);
                    lb4thQnt.setVisible(true);
                    lb4thPlus.setVisible(true);
                    lb4thPrice.setVisible(true);
                    lb4thTotal.setVisible(true);
                    lbIcon4thRemove.setVisible(true);

                    fillComponents();
                    break;
            }
        }

    }

    /**
     * Método para preencher os componentes do carrinho com informações dos
     * itens.
     */
    public void fillComponents() {
        int quantityOfItems = userLogged.getCart().getItems().size();
        String iconURL = "/com/decrease/view/images/icons/removeFromCart.png";

        switch (quantityOfItems) {
            case 1 -> {
                cI1 = findProduct(1);

                lb1stName.setText(EcommerceT1LpApplication.msgManager.getMessage("name-product1"));
                lb1stBrand.setText("Decrease");
                lb1stQnt.setText(String.valueOf(cI1.getQuantity()));
                lb1stPrice.setText(String.valueOf(cI1.getProduct().getPrice()));
                calculateTotal(lb1stTotal, lb1stQnt.getText(), cI1.getProduct().getPrice());
                lbIcon1stRemove.setIcon(new ImageIcon(getClass().getResource(iconURL)));

                ImageIcon originalIcon = createImageIcon(cI1.getProduct().getImgUrl());
                ImageIcon resizedIcon = resizeIcon(originalIcon, 70, 70);
                lb1stItem.setIcon(resizedIcon);
            }

            case 2 -> {
                cI1 = findProduct(1);
                cI2 = findProduct(2);

                lb1stName.setText(EcommerceT1LpApplication.msgManager.getMessage("name-product1"));
                lb1stBrand.setText("Decrease");
                lb1stQnt.setText(String.valueOf(cI1.getQuantity()));
                lb1stPrice.setText(String.valueOf(cI1.getProduct().getPrice()));
                calculateTotal(lb1stTotal, lb1stQnt.getText(), cI1.getProduct().getPrice());
                lbIcon1stRemove.setIcon(new ImageIcon(getClass().getResource(iconURL)));

                ImageIcon originalIcon = createImageIcon(cI1.getProduct().getImgUrl());
                ImageIcon resizedIcon = resizeIcon(originalIcon, 70, 70);
                lb1stItem.setIcon(resizedIcon);

                lb2ndName.setText(EcommerceT1LpApplication.msgManager.getMessage("name-product2"));
                lb2ndBrand.setText("Decrease");
                lb2ndQnt.setText(String.valueOf(cI2.getQuantity()));
                lb2ndPrice.setText(String.valueOf(cI2.getProduct().getPrice()));
                calculateTotal(lb2ndTotal, lb2ndQnt.getText(), cI2.getProduct().getPrice());
                lbIcon2ndRemove.setIcon(new ImageIcon(getClass().getResource(iconURL)));

                originalIcon = createImageIcon(cI2.getProduct().getImgUrl());
                resizedIcon = resizeIcon(originalIcon, 70, 70);
                lb2ndItem.setIcon(resizedIcon);
            }

            case 3 -> {
                cI1 = findProduct(1);
                cI2 = findProduct(2);
                cI3 = findProduct(3);

                lb1stName.setText(EcommerceT1LpApplication.msgManager.getMessage("name-product1"));
                lb1stBrand.setText("Decrease");
                lb1stQnt.setText(String.valueOf(cI1.getQuantity()));
                lb1stPrice.setText(String.valueOf(cI1.getProduct().getPrice()));
                calculateTotal(lb1stTotal, lb1stQnt.getText(), cI1.getProduct().getPrice());
                lbIcon1stRemove.setIcon(new ImageIcon(getClass().getResource(iconURL)));

                ImageIcon originalIcon = createImageIcon(cI1.getProduct().getImgUrl());
                ImageIcon resizedIcon = resizeIcon(originalIcon, 70, 70);
                lb1stItem.setIcon(resizedIcon);

                lb2ndName.setText(EcommerceT1LpApplication.msgManager.getMessage("name-product2"));
                lb2ndBrand.setText("Decrease");
                lb2ndQnt.setText(String.valueOf(cI2.getQuantity()));
                lb2ndPrice.setText(String.valueOf(cI2.getProduct().getPrice()));
                calculateTotal(lb2ndTotal, lb2ndQnt.getText(), cI2.getProduct().getPrice());
                lbIcon2ndRemove.setIcon(new ImageIcon(getClass().getResource(iconURL)));

                originalIcon = createImageIcon(cI2.getProduct().getImgUrl());
                resizedIcon = resizeIcon(originalIcon, 70, 70);
                lb2ndItem.setIcon(resizedIcon);

                lb3rdName.setText(EcommerceT1LpApplication.msgManager.getMessage("name-product3"));
                lb3rdBrand.setText("Decrease");
                lb3rdQnt.setText(String.valueOf(cI3.getQuantity()));
                lb3rdPrice.setText(String.valueOf(cI3.getProduct().getPrice()));
                calculateTotal(lb3rdTotal, lb3rdQnt.getText(), cI3.getProduct().getPrice());
                lbIcon3rdRemove.setIcon(new ImageIcon(getClass().getResource(iconURL)));

                originalIcon = createImageIcon(cI3.getProduct().getImgUrl());
                resizedIcon = resizeIcon(originalIcon, 70, 70);
                lb3rdItem.setIcon(resizedIcon);
            }

            default -> {
                cI1 = findProduct(1);
                cI2 = findProduct(2);
                cI3 = findProduct(3);
                cI4 = findProduct(4);

                lb1stName.setText(EcommerceT1LpApplication.msgManager.getMessage("name-product1"));
                lb1stBrand.setText("Decrease");
                lb1stQnt.setText(String.valueOf(cI1.getQuantity()));
                lb1stPrice.setText(String.valueOf(cI1.getProduct().getPrice()));
                calculateTotal(lb1stTotal, lb1stQnt.getText(), cI1.getProduct().getPrice());
                lbIcon1stRemove.setIcon(new ImageIcon(getClass().getResource(iconURL)));

                ImageIcon originalIcon = createImageIcon(cI1.getProduct().getImgUrl());
                ImageIcon resizedIcon = resizeIcon(originalIcon, 70, 70);
                lb1stItem.setIcon(resizedIcon);

                lb2ndName.setText(EcommerceT1LpApplication.msgManager.getMessage("name-product2"));
                lb2ndBrand.setText("Decrease");
                lb2ndQnt.setText(String.valueOf(cI2.getQuantity()));
                lb2ndPrice.setText(String.valueOf(cI2.getProduct().getPrice()));
                calculateTotal(lb2ndTotal, lb2ndQnt.getText(), cI2.getProduct().getPrice());
                lbIcon2ndRemove.setIcon(new ImageIcon(getClass().getResource(iconURL)));

                originalIcon = createImageIcon(cI2.getProduct().getImgUrl());
                resizedIcon = resizeIcon(originalIcon, 70, 70);
                lb2ndItem.setIcon(resizedIcon);

                lb3rdName.setText(EcommerceT1LpApplication.msgManager.getMessage("name-product3"));
                lb3rdBrand.setText("Decrease");
                lb3rdQnt.setText(String.valueOf(cI3.getQuantity()));
                lb3rdPrice.setText(String.valueOf(cI3.getProduct().getPrice()));
                calculateTotal(lb3rdTotal, lb3rdQnt.getText(), cI3.getProduct().getPrice());
                lbIcon3rdRemove.setIcon(new ImageIcon(getClass().getResource(iconURL)));

                originalIcon = createImageIcon(cI3.getProduct().getImgUrl());
                resizedIcon = resizeIcon(originalIcon, 70, 70);
                lb3rdItem.setIcon(resizedIcon);

                lb4thName.setText(EcommerceT1LpApplication.msgManager.getMessage("name-product4"));
                lb4thBrand.setText("Decrease");
                lb4thQnt.setText(String.valueOf(cI4.getQuantity()));
                lb4thPrice.setText(String.valueOf(cI4.getProduct().getPrice()));
                calculateTotal(lb4thTotal, lb4thQnt.getText(), cI4.getProduct().getPrice());
                lbIcon4thRemove.setIcon(new ImageIcon(getClass().getResource(iconURL)));

                originalIcon = createImageIcon(cI4.getProduct().getImgUrl());
                resizedIcon = resizeIcon(originalIcon, 70, 70);
                lb4thItem.setIcon(resizedIcon);
            }
        }

        lbAmountItems.setText(String.valueOf(quantityOfItems) + " ITEMS");
        lbSubtotalItems.setText("R$ " + String.valueOf(userLogged.getCart().getSubtotal()));
    }

    /**
     * Método para redimensionar ícones.
     *
     * @param icon O ícone a ser redimensionado.
     * @param width A largura desejada do ícone redimensionado.
     * @param height A altura desejada do ícone redimensionado.
     * @return Um novo ImageIcon redimensionado.
     */
    public ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image img = icon.getImage();
        Image resizedImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImg);
    }

    /**
     * Método para criar um ImageIcon a partir de um caminho de arquivo.
     *
     * @param path O caminho do arquivo de imagem.
     * @return Um ImageIcon criado a partir do caminho especificado.
     */
    protected ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Método para encontrar um produto pelo índice na lista de itens do
     * carrinho.
     *
     * @param position A posição do item na lista (começando em 1).
     * @return O CartItem correspondente à posição especificada.
     */
    public CartItem findProduct(int position) {
        itemList = List.copyOf(userLogged.getCart().getItems());
        return itemList.get(position - 1);
    }

    /**
     * Método para calcular o total de um item no carrinho.
     *
     * @param label O rótulo onde o total será exibido.
     * @param qnt A quantidade do item.
     * @param price O preço do item.
     */
    public void calculateTotal(JLabel label, String qnt, Double price)  {
        Double total;
        total = Integer.parseInt(qnt) * price;
        total = truncate(total);
        label.setText("R$ " + String.valueOf(total));
    }

    public double truncate(double num) {
        BigDecimal bd = new BigDecimal(Double.toString(num));
        bd = bd.setScale(2, RoundingMode.DOWN);
        return bd.doubleValue();
    }

    /**
     * Método para remover um produto do carrinho.
     *
     * @param p O produto a ser removido.
     */
    public void removeFromCart(Product p) {
        Product productFinded = EcommerceT1LpApplication.mainFrame.productController.getProductByName(p.getName());
        EcommerceT1LpApplication.mainFrame.cartController.deleteItem(productFinded, SessionController.getInstance());
        initCartComponents();
    }

    /**
     * Método para lidar com a quantidade de um item sendo menor que zero.
     *
     * @param p O produto relacionado à quantidade negativa.
     */
    public void qntLessThanZero(Product p) {
        String msg
                = EcommerceT1LpApplication.msgManager.getMessage("want-to-remove-alert");

        int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

        if (option == 0) {
            removeFromCart(p);
            msg
                    = EcommerceT1LpApplication.msgManager.getMessage("success-remove-cart-alert");

            Alerts.showSuccessMessage(msg, "Operation Completed Successfully", null);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1stBrand = new javax.swing.JLabel();
        lb1stName = new javax.swing.JLabel();
        lbContShopping = new javax.swing.JLabel();
        lbTitleTotal = new javax.swing.JLabel();
        lbTitleTotalItems = new javax.swing.JLabel();
        lbTitleOrderSummary = new javax.swing.JLabel();
        lbAmountItems = new javax.swing.JLabel();
        lbTitleProdDetails = new javax.swing.JLabel();
        lb1stMinus = new javax.swing.JLabel();
        lbTitlePrice = new javax.swing.JLabel();
        lb2ndItem = new javax.swing.JLabel();
        lb1stItem = new javax.swing.JLabel();
        lb4thItem = new javax.swing.JLabel();
        lb3rdItem = new javax.swing.JLabel();
        lb2ndName = new javax.swing.JLabel();
        lb2ndBrand = new javax.swing.JLabel();
        lb4thBrand = new javax.swing.JLabel();
        lb4thName = new javax.swing.JLabel();
        lb3rdBrand = new javax.swing.JLabel();
        lb3rdName = new javax.swing.JLabel();
        lbIcon2ndRemove = new javax.swing.JLabel();
        lb2ndQnt = new javax.swing.JLabel();
        lb3rdQnt = new javax.swing.JLabel();
        lb4thQnt = new javax.swing.JLabel();
        lbTitleQuantity = new javax.swing.JLabel();
        lb1stPlus = new javax.swing.JLabel();
        lb2ndPlus = new javax.swing.JLabel();
        lb2ndMinus = new javax.swing.JLabel();
        lb4thMinus = new javax.swing.JLabel();
        lb4thPlus = new javax.swing.JLabel();
        lb3rdMinus = new javax.swing.JLabel();
        lb3rdPlus = new javax.swing.JLabel();
        lb1stPrice = new javax.swing.JLabel();
        lb2ndPrice = new javax.swing.JLabel();
        lb3rdPrice = new javax.swing.JLabel();
        lb4thPrice = new javax.swing.JLabel();
        lb1stTotal = new javax.swing.JLabel();
        lb2ndTotal = new javax.swing.JLabel();
        lb3rdTotal = new javax.swing.JLabel();
        lb4thTotal = new javax.swing.JLabel();
        lbTitleShoppingCart = new javax.swing.JLabel();
        lb1stQnt = new javax.swing.JLabel();
        lbIcon1stRemove = new javax.swing.JLabel();
        lbIcon3rdRemove = new javax.swing.JLabel();
        lbClearCart = new javax.swing.JLabel();
        lbIcon4thRemove = new javax.swing.JLabel();
        lbSubtotalItems = new javax.swing.JLabel();
        lbCheckout = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 600));
        setMinimumSize(new java.awt.Dimension(1280, 600));
        setPreferredSize(new java.awt.Dimension(1280, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb1stBrand.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lb1stBrand.setForeground(new java.awt.Color(0, 0, 0));
        lb1stBrand.setText("Brand");
        add(lb1stBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        lb1stName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb1stName.setForeground(new java.awt.Color(0, 0, 0));
        lb1stName.setText("Item Name");
        add(lb1stName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, -1, -1));

        lbContShopping.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbContShopping.setForeground(new java.awt.Color(172, 74, 213));
        lbContShopping.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbContShopping.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/leftArrow.png"))); // NOI18N
        lbContShopping.setText("CONTINUE SHOPPING");
        lbContShopping.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbContShopping.setIconTextGap(7);
        lbContShopping.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbContShoppingMouseClicked(evt);
            }
        });
        add(lbContShopping, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, 200, -1));

        lbTitleTotal.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbTitleTotal.setForeground(new java.awt.Color(0, 0, 0));
        lbTitleTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleTotal.setText("TOTAL");
        lbTitleTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleTotal.setIconTextGap(7);
        add(lbTitleTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 90, 140, -1));

        lbTitleTotalItems.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lbTitleTotalItems.setForeground(new java.awt.Color(0, 0, 0));
        lbTitleTotalItems.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitleTotalItems.setText("Total Items");
        lbTitleTotalItems.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleTotalItems.setIconTextGap(7);
        add(lbTitleTotalItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 100, -1));

        lbTitleOrderSummary.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lbTitleOrderSummary.setForeground(new java.awt.Color(0, 0, 0));
        lbTitleOrderSummary.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleOrderSummary.setText("Order Summary");
        lbTitleOrderSummary.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleOrderSummary.setIconTextGap(7);
        add(lbTitleOrderSummary, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 50, 250, -1));

        lbAmountItems.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbAmountItems.setForeground(new java.awt.Color(0, 0, 0));
        lbAmountItems.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbAmountItems.setText("- ITEMS");
        lbAmountItems.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAmountItems.setIconTextGap(7);
        add(lbAmountItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 100, -1));

        lbTitleProdDetails.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbTitleProdDetails.setForeground(new java.awt.Color(0, 0, 0));
        lbTitleProdDetails.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleProdDetails.setText("PRODUCTS DETAILS");
        lbTitleProdDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleProdDetails.setIconTextGap(7);
        add(lbTitleProdDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 110, -1));

        lb1stMinus.setFont(new java.awt.Font("Malgun Gothic", 0, 20)); // NOI18N
        lb1stMinus.setForeground(new java.awt.Color(0, 0, 0));
        lb1stMinus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1stMinus.setText("-");
        lb1stMinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb1stMinus.setIconTextGap(7);
        lb1stMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb1stMinusMouseClicked(evt);
            }
        });
        add(lb1stMinus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 25, 35));

        lbTitlePrice.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbTitlePrice.setForeground(new java.awt.Color(0, 0, 0));
        lbTitlePrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitlePrice.setText("PRICE");
        lbTitlePrice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitlePrice.setIconTextGap(7);
        add(lbTitlePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 140, -1));
        add(lb2ndItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 70, 70));
        add(lb1stItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 70, 70));
        add(lb4thItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 70, 70));
        add(lb3rdItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 70, 70));

        lb2ndName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb2ndName.setForeground(new java.awt.Color(0, 0, 0));
        lb2ndName.setText("Item Name");
        add(lb2ndName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, -1, -1));

        lb2ndBrand.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lb2ndBrand.setForeground(new java.awt.Color(0, 0, 0));
        lb2ndBrand.setText("Brand");
        add(lb2ndBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, -1, -1));

        lb4thBrand.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lb4thBrand.setForeground(new java.awt.Color(0, 0, 0));
        lb4thBrand.setText("Brand");
        add(lb4thBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, -1, -1));

        lb4thName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb4thName.setForeground(new java.awt.Color(0, 0, 0));
        lb4thName.setText("Item Name");
        add(lb4thName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, -1, -1));

        lb3rdBrand.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lb3rdBrand.setForeground(new java.awt.Color(0, 0, 0));
        lb3rdBrand.setText("Brand");
        add(lb3rdBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, -1, -1));

        lb3rdName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb3rdName.setForeground(new java.awt.Color(0, 0, 0));
        lb3rdName.setText("Item Name");
        add(lb3rdName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, -1, -1));

        lbIcon2ndRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/removeFromCart.png"))); // NOI18N
        lbIcon2ndRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIcon2ndRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIcon2ndRemoveMouseClicked(evt);
            }
        });
        add(lbIcon2ndRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 220, 35, 35));

        lb2ndQnt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2ndQnt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lb2ndQnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 220, 35, 35));

        lb3rdQnt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3rdQnt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lb3rdQnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 300, 35, 35));

        lb4thQnt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4thQnt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lb4thQnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 380, 35, 35));

        lbTitleQuantity.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbTitleQuantity.setForeground(new java.awt.Color(0, 0, 0));
        lbTitleQuantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitleQuantity.setText("QUANTITY");
        lbTitleQuantity.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleQuantity.setIconTextGap(7);
        add(lbTitleQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 100, -1));

        lb1stPlus.setFont(new java.awt.Font("Malgun Gothic", 0, 20)); // NOI18N
        lb1stPlus.setForeground(new java.awt.Color(0, 0, 0));
        lb1stPlus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1stPlus.setText("+");
        lb1stPlus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb1stPlus.setIconTextGap(7);
        lb1stPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb1stPlusMouseClicked(evt);
            }
        });
        add(lb1stPlus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 25, 35));

        lb2ndPlus.setFont(new java.awt.Font("Malgun Gothic", 0, 20)); // NOI18N
        lb2ndPlus.setForeground(new java.awt.Color(0, 0, 0));
        lb2ndPlus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2ndPlus.setText("+");
        lb2ndPlus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb2ndPlus.setIconTextGap(7);
        lb2ndPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb2ndPlusMouseClicked(evt);
            }
        });
        add(lb2ndPlus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 25, 35));

        lb2ndMinus.setFont(new java.awt.Font("Malgun Gothic", 0, 20)); // NOI18N
        lb2ndMinus.setForeground(new java.awt.Color(0, 0, 0));
        lb2ndMinus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2ndMinus.setText("-");
        lb2ndMinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb2ndMinus.setIconTextGap(7);
        lb2ndMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb2ndMinusMouseClicked(evt);
            }
        });
        add(lb2ndMinus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 25, 35));

        lb4thMinus.setFont(new java.awt.Font("Malgun Gothic", 0, 20)); // NOI18N
        lb4thMinus.setForeground(new java.awt.Color(0, 0, 0));
        lb4thMinus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4thMinus.setText("-");
        lb4thMinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb4thMinus.setIconTextGap(7);
        lb4thMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb4thMinusMouseClicked(evt);
            }
        });
        add(lb4thMinus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, 25, 35));

        lb4thPlus.setFont(new java.awt.Font("Malgun Gothic", 0, 20)); // NOI18N
        lb4thPlus.setForeground(new java.awt.Color(0, 0, 0));
        lb4thPlus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4thPlus.setText("+");
        lb4thPlus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb4thPlus.setIconTextGap(7);
        lb4thPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb4thPlusMouseClicked(evt);
            }
        });
        add(lb4thPlus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 25, 35));

        lb3rdMinus.setFont(new java.awt.Font("Malgun Gothic", 0, 20)); // NOI18N
        lb3rdMinus.setForeground(new java.awt.Color(0, 0, 0));
        lb3rdMinus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3rdMinus.setText("-");
        lb3rdMinus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb3rdMinus.setIconTextGap(7);
        lb3rdMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb3rdMinusMouseClicked(evt);
            }
        });
        add(lb3rdMinus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 25, 35));

        lb3rdPlus.setFont(new java.awt.Font("Malgun Gothic", 0, 20)); // NOI18N
        lb3rdPlus.setForeground(new java.awt.Color(0, 0, 0));
        lb3rdPlus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3rdPlus.setText("+");
        lb3rdPlus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb3rdPlus.setIconTextGap(7);
        lb3rdPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb3rdPlusMouseClicked(evt);
            }
        });
        add(lb3rdPlus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 25, 35));

        lb1stPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb1stPrice.setForeground(new java.awt.Color(0, 0, 0));
        lb1stPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1stPrice.setText("R$ ");
        add(lb1stPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 140, -1));

        lb2ndPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb2ndPrice.setForeground(new java.awt.Color(0, 0, 0));
        lb2ndPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2ndPrice.setText("R$ ");
        add(lb2ndPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 140, -1));

        lb3rdPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb3rdPrice.setForeground(new java.awt.Color(0, 0, 0));
        lb3rdPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3rdPrice.setText("R$ ");
        add(lb3rdPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, 140, -1));

        lb4thPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb4thPrice.setForeground(new java.awt.Color(0, 0, 0));
        lb4thPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4thPrice.setText("R$ ");
        add(lb4thPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 380, 140, -1));

        lb1stTotal.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb1stTotal.setForeground(new java.awt.Color(0, 0, 0));
        lb1stTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1stTotal.setText("R$ ");
        add(lb1stTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 140, -1));

        lb2ndTotal.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb2ndTotal.setForeground(new java.awt.Color(0, 0, 0));
        lb2ndTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb2ndTotal.setText("R$ ");
        add(lb2ndTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 140, -1));

        lb3rdTotal.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb3rdTotal.setForeground(new java.awt.Color(0, 0, 0));
        lb3rdTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb3rdTotal.setText("R$ ");
        add(lb3rdTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 140, -1));

        lb4thTotal.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lb4thTotal.setForeground(new java.awt.Color(0, 0, 0));
        lb4thTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb4thTotal.setText("R$ ");
        add(lb4thTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 380, 140, -1));

        lbTitleShoppingCart.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lbTitleShoppingCart.setForeground(new java.awt.Color(0, 0, 0));
        lbTitleShoppingCart.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTitleShoppingCart.setText("Shopping Cart");
        lbTitleShoppingCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTitleShoppingCart.setIconTextGap(7);
        add(lbTitleShoppingCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 130, -1));

        lb1stQnt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb1stQnt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(lb1stQnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 140, 35, 35));

        lbIcon1stRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/removeFromCart.png"))); // NOI18N
        lbIcon1stRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIcon1stRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIcon1stRemoveMouseClicked(evt);
            }
        });
        add(lbIcon1stRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 140, 35, 35));

        lbIcon3rdRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/removeFromCart.png"))); // NOI18N
        lbIcon3rdRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIcon3rdRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIcon3rdRemoveMouseClicked(evt);
            }
        });
        add(lbIcon3rdRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 300, 35, 35));

        lbClearCart.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbClearCart.setForeground(new java.awt.Color(0, 0, 0));
        lbClearCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/clearCart.png"))); // NOI18N
        lbClearCart.setText("CLEAR CART");
        lbClearCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClearCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbClearCartMouseClicked(evt);
            }
        });
        add(lbClearCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 520, 120, 35));

        lbIcon4thRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/removeFromCart.png"))); // NOI18N
        lbIcon4thRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIcon4thRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIcon4thRemoveMouseClicked(evt);
            }
        });
        add(lbIcon4thRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 380, 35, 35));

        lbSubtotalItems.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbSubtotalItems.setForeground(new java.awt.Color(0, 0, 0));
        lbSubtotalItems.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSubtotalItems.setText("R$ -");
        lbSubtotalItems.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSubtotalItems.setIconTextGap(7);
        add(lbSubtotalItems, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 90, 80, -1));

        lbCheckout.setBackground(new java.awt.Color(0, 0, 0));
        lbCheckout.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbCheckout.setForeground(new java.awt.Color(255, 255, 255));
        lbCheckout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCheckout.setText("CHECKOUT");
        lbCheckout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbCheckout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCheckout.setOpaque(true);
        lbCheckout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCheckoutMouseClicked(evt);
            }
        });
        add(lbCheckout, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 140, 250, 40));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/backgrounds/base2.png"))); // NOI18N
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, -1, 600));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Evento de clique no ícone de continuar comprando.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbContShoppingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbContShoppingMouseClicked
        MainFrame.products = new Products();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.products);
    }//GEN-LAST:event_lbContShoppingMouseClicked

    /**
     * Evento de clique no ícone de adicionar mais quantidade ao primeiro item
     * do carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lb1stPlusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1stPlusMouseClicked
        if (lb1stPlus.isVisible()) {
            lb1stQnt.setText(String.valueOf(Integer.parseInt(lb1stQnt.getText()) + 1));
            cI1.setQuantity(Integer.parseInt(lb1stQnt.getText()));
            calculateTotal(lb1stTotal, lb1stQnt.getText(), cI1.getProduct().getPrice());
            lbSubtotalItems.setText("R$ " + String.valueOf(userLogged.getCart().getSubtotal()));
        }
    }//GEN-LAST:event_lb1stPlusMouseClicked

    /**
     * Evento de clique no ícone de remover quantidade do primeiro item do
     * carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lb1stMinusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1stMinusMouseClicked
        if (lb1stPlus.isVisible()) {
            int qntProduct1 = Integer.parseInt(lb1stQnt.getText());

            if (qntProduct1 == 1) {
                qntLessThanZero(cI1.getProduct());
            } else {
                lb1stQnt.setText(String.valueOf(Integer.parseInt(lb1stQnt.getText()) - 1));
                cI1.setQuantity(Integer.parseInt(lb1stQnt.getText()));
                calculateTotal(lb1stTotal, lb1stQnt.getText(), cI1.getProduct().getPrice());
                lbSubtotalItems.setText("R$ " + String.valueOf(userLogged.getCart().getSubtotal()));
            }
        }
    }//GEN-LAST:event_lb1stMinusMouseClicked

    /**
     * Evento de clique no ícone de remover o primeiro item do carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbIcon1stRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIcon1stRemoveMouseClicked
        if (lbIcon1stRemove.isVisible()) {
            String msg
                    = EcommerceT1LpApplication.msgManager.getMessage("remove-item-cart-alert");

            int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

            if (option == 0) {
                removeFromCart(cI1.getProduct());
                msg
                        = EcommerceT1LpApplication.msgManager.getMessage("removed-product-alert");

                Alerts.showSuccessMessage(msg, "Operation Completed Successfully", null);
            }
        }
    }//GEN-LAST:event_lbIcon1stRemoveMouseClicked

    /**
     * Evento de clique no ícone de remover quantidade do segundo item do
     * carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lb2ndMinusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2ndMinusMouseClicked
        if (lb2ndPlus.isVisible()) {
            int qntProduct2 = Integer.parseInt(lb2ndQnt.getText());

            if (qntProduct2 == 1) {
                qntLessThanZero(cI2.getProduct());
            } else {
                lb2ndQnt.setText(String.valueOf(Integer.parseInt(lb2ndQnt.getText()) - 1));
                cI2.setQuantity(Integer.parseInt(lb2ndQnt.getText()));
                calculateTotal(lb2ndTotal, lb2ndQnt.getText(), cI2.getProduct().getPrice());
                lbSubtotalItems.setText("R$ " + String.valueOf(userLogged.getCart().getSubtotal()));
            }
        }
    }//GEN-LAST:event_lb2ndMinusMouseClicked

    /**
     * Evento de clique no ícone de adicionar mais quantidade ao segundo item do
     * carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lb2ndPlusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2ndPlusMouseClicked
        if (lb2ndPlus.isVisible()) {
            lb2ndQnt.setText(String.valueOf(Integer.parseInt(lb2ndQnt.getText()) + 1));
            cI2.setQuantity(Integer.parseInt(lb2ndQnt.getText()));
            calculateTotal(lb2ndTotal, lb2ndQnt.getText(), cI2.getProduct().getPrice());
            lbSubtotalItems.setText("R$ " + String.valueOf(userLogged.getCart().getSubtotal()));
        }
    }//GEN-LAST:event_lb2ndPlusMouseClicked

    /**
     * Evento de clique no ícone de remover o segundo item do carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbIcon2ndRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIcon2ndRemoveMouseClicked
        if (lbIcon2ndRemove.isVisible()) {
            String msg
                    = EcommerceT1LpApplication.msgManager.getMessage("remove-item-cart-alert");

            int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

            if (option == 0) {
                removeFromCart(cI2.getProduct());
                msg
                        = EcommerceT1LpApplication.msgManager.getMessage("removed-product-alert");

                Alerts.showSuccessMessage(msg, "Operation Completed Successfully", null);
            }
        }
    }//GEN-LAST:event_lbIcon2ndRemoveMouseClicked

    /**
     * Evento de clique no ícone de remover quantidade do terceiro item do
     * carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lb3rdMinusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3rdMinusMouseClicked
        if (lb3rdPlus.isVisible()) {
            int qntProduct3 = Integer.parseInt(lb3rdQnt.getText());

            if (qntProduct3 == 1) {
                qntLessThanZero(cI3.getProduct());
            } else {
                lb3rdQnt.setText(String.valueOf(Integer.parseInt(lb3rdQnt.getText()) - 1));
                cI3.setQuantity(Integer.parseInt(lb3rdQnt.getText()));
                calculateTotal(lb3rdTotal, lb3rdQnt.getText(), cI3.getProduct().getPrice());
                lbSubtotalItems.setText("R$ " + String.valueOf(userLogged.getCart().getSubtotal()));
            }
        }
    }//GEN-LAST:event_lb3rdMinusMouseClicked

    /**
     * Evento de clique no ícone de adicionar mais quantidade ao terceiro item
     * do carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lb3rdPlusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3rdPlusMouseClicked
        if (lb3rdPlus.isVisible()) {
            lb3rdQnt.setText(String.valueOf(Integer.parseInt(lb3rdQnt.getText()) + 1));
            cI3.setQuantity(Integer.parseInt(lb3rdQnt.getText()));
            calculateTotal(lb3rdTotal, lb3rdQnt.getText(), cI3.getProduct().getPrice());
            lbSubtotalItems.setText("R$ " + String.valueOf(userLogged.getCart().getSubtotal()));
        }
    }//GEN-LAST:event_lb3rdPlusMouseClicked

    /**
     * Evento de clique no ícone de remover o terceiro item do carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbIcon3rdRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIcon3rdRemoveMouseClicked
        if (lbIcon3rdRemove.isVisible()) {
            String msg
                    = EcommerceT1LpApplication.msgManager.getMessage("remove-item-cart-alert");

            int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

            if (option == 0) {
                removeFromCart(cI3.getProduct());
                msg
                        = EcommerceT1LpApplication.msgManager.getMessage("removed-product-alert");

                Alerts.showSuccessMessage(msg, "Operation Completed Successfully", null);
            }
        }
    }//GEN-LAST:event_lbIcon3rdRemoveMouseClicked

    /**
     * Evento de clique no ícone de remover quantidade do quarto item do
     * carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lb4thMinusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb4thMinusMouseClicked
        if (lb4thPlus.isVisible()) {
            int qntProduct4 = Integer.parseInt(lb4thQnt.getText());

            if (qntProduct4 == 1) {
                qntLessThanZero(cI4.getProduct());
            } else {
                lb4thQnt.setText(String.valueOf(Integer.parseInt(lb4thQnt.getText()) - 1));
                cI4.setQuantity(Integer.parseInt(lb4thQnt.getText()));
                calculateTotal(lb4thTotal, lb4thQnt.getText(), cI4.getProduct().getPrice());
                lbSubtotalItems.setText("R$ " + String.valueOf(userLogged.getCart().getSubtotal()));
            }
        }
    }//GEN-LAST:event_lb4thMinusMouseClicked

    /**
     * Evento de clique no ícone de adicionar mais quantidade ao quarto item do
     * carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lb4thPlusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb4thPlusMouseClicked
        if (lb4thPlus.isVisible()) {
            lb4thQnt.setText(String.valueOf(Integer.parseInt(lb4thQnt.getText()) + 1));
            cI4.setQuantity(Integer.parseInt(lb4thQnt.getText()));
            calculateTotal(lb4thTotal, lb4thQnt.getText(), cI4.getProduct().getPrice());
            lbSubtotalItems.setText("R$ " + String.valueOf(userLogged.getCart().getSubtotal()));
        }
    }//GEN-LAST:event_lb4thPlusMouseClicked

    /**
     * Evento de clique no ícone de remover o quarto item do carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbIcon4thRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIcon4thRemoveMouseClicked
        if (lbIcon4thRemove.isVisible()) {
            String msg
                    = EcommerceT1LpApplication.msgManager.getMessage("remove-item-cart-alert");

            int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

            if (option == 0) {
                removeFromCart(cI4.getProduct());
                msg
                        = EcommerceT1LpApplication.msgManager.getMessage("removed-product-alert");

                Alerts.showSuccessMessage(msg, "Operation Completed Successfully", null);
            }
        }
    }//GEN-LAST:event_lbIcon4thRemoveMouseClicked

    /**
     * Evento de clique no ícone de limpar o carrinho.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbClearCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbClearCartMouseClicked

        String msg;

        if (userLogged.getCart() != null && !userLogged.getCart().getItems().isEmpty()) {

            msg
                    = EcommerceT1LpApplication.msgManager.getMessage("clean-cart-alert");

            int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

            if (option == 0) {
                EcommerceT1LpApplication.mainFrame.cartController.cleanCart(SessionController.getInstance().getUserLogged());
                msg
                        = EcommerceT1LpApplication.msgManager.getMessage("success-remove-cart");

                Alerts.showSuccessMessage(msg, "Operation Completed Successfully", null);
                initCartComponents();
                lbSubtotalItems.setText("R$ - ");
            }

        } else {
            msg
                    = EcommerceT1LpApplication.msgManager.getMessage("clean-empty-cart-alert");
            Alerts.showAlertMessage(msg, "Your Cart is Empty", null);
        }

    }//GEN-LAST:event_lbClearCartMouseClicked

    /**
     * Evento de clique no ícone de prosseguir para o checkout.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbCheckoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCheckoutMouseClicked

        String msg;

        try {
            if (userLogged.getCart() != null && !userLogged.getCart().getItems().isEmpty()) {
                MainFrame.checkout = new Checkout();
                EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.checkout);
            } else {
                msg
                        = EcommerceT1LpApplication.msgManager.getMessage("checkout-empty-cart-alert");

                throw new CustomException(msg);
            }
        } catch (CustomException e) {
            Alerts.showAlertMessage(e.getMessage(), "Your Cart is Empty", null);
        }

    }//GEN-LAST:event_lbCheckoutMouseClicked

    public void setText() {
        lbTitleShoppingCart.setText(EcommerceT1LpApplication.msgManager.getMessage("cart-title"));
        lbContShopping.setText(EcommerceT1LpApplication.msgManager.getMessage("continue_shopping"));
        lbTitleTotal.setText(EcommerceT1LpApplication.msgManager.getMessage("total"));
        lbTitleTotalItems.setText(EcommerceT1LpApplication.msgManager.getMessage("total_items"));
        lbTitleOrderSummary.setText(EcommerceT1LpApplication.msgManager.getMessage("order_summary"));
        lbAmountItems.setText(EcommerceT1LpApplication.msgManager.getMessage("items"));
        lbTitleProdDetails.setText(EcommerceT1LpApplication.msgManager.getMessage("product_details"));
        lbTitlePrice.setText(EcommerceT1LpApplication.msgManager.getMessage("price"));
        lbTitleQuantity.setText(EcommerceT1LpApplication.msgManager.getMessage("quantity"));
        lbClearCart.setText(EcommerceT1LpApplication.msgManager.getMessage("clear_cart"));
        lbCheckout.setText(EcommerceT1LpApplication.msgManager.getMessage("checkout"));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb1stBrand;
    private javax.swing.JLabel lb1stItem;
    private javax.swing.JLabel lb1stMinus;
    private javax.swing.JLabel lb1stName;
    private javax.swing.JLabel lb1stPlus;
    private javax.swing.JLabel lb1stPrice;
    private javax.swing.JLabel lb1stQnt;
    private javax.swing.JLabel lb1stTotal;
    private javax.swing.JLabel lb2ndBrand;
    private javax.swing.JLabel lb2ndItem;
    private javax.swing.JLabel lb2ndMinus;
    private javax.swing.JLabel lb2ndName;
    private javax.swing.JLabel lb2ndPlus;
    private javax.swing.JLabel lb2ndPrice;
    private javax.swing.JLabel lb2ndQnt;
    private javax.swing.JLabel lb2ndTotal;
    private javax.swing.JLabel lb3rdBrand;
    private javax.swing.JLabel lb3rdItem;
    private javax.swing.JLabel lb3rdMinus;
    private javax.swing.JLabel lb3rdName;
    private javax.swing.JLabel lb3rdPlus;
    private javax.swing.JLabel lb3rdPrice;
    private javax.swing.JLabel lb3rdQnt;
    private javax.swing.JLabel lb3rdTotal;
    private javax.swing.JLabel lb4thBrand;
    private javax.swing.JLabel lb4thItem;
    private javax.swing.JLabel lb4thMinus;
    private javax.swing.JLabel lb4thName;
    private javax.swing.JLabel lb4thPlus;
    private javax.swing.JLabel lb4thPrice;
    private javax.swing.JLabel lb4thQnt;
    private javax.swing.JLabel lb4thTotal;
    private javax.swing.JLabel lbAmountItems;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbCheckout;
    private javax.swing.JLabel lbClearCart;
    private javax.swing.JLabel lbContShopping;
    private javax.swing.JLabel lbIcon1stRemove;
    private javax.swing.JLabel lbIcon2ndRemove;
    private javax.swing.JLabel lbIcon3rdRemove;
    private javax.swing.JLabel lbIcon4thRemove;
    private javax.swing.JLabel lbSubtotalItems;
    private javax.swing.JLabel lbTitleOrderSummary;
    private javax.swing.JLabel lbTitlePrice;
    private javax.swing.JLabel lbTitleProdDetails;
    private javax.swing.JLabel lbTitleQuantity;
    private javax.swing.JLabel lbTitleShoppingCart;
    private javax.swing.JLabel lbTitleTotal;
    private javax.swing.JLabel lbTitleTotalItems;
    // End of variables declaration//GEN-END:variables
}
