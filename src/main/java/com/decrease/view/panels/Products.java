package com.decrease.view.panels;

import com.decrease.EcommerceT1LpApplication;
import com.decrease.controller.SessionController;
import com.decrease.entities.Product;
import com.decrease.model.Alerts;
import com.decrease.view.MainFrame;
import javax.swing.ImageIcon;


public class Products extends javax.swing.JPanel {

    private boolean isAnyProductSelected; 
    private Product selectedProduct; 

    public Products() {
        initComponents();
        verifyUserLogged();
        isAnyProductSelected = false;
        initSelectedProductComponents();
    }

    public void initSelectedProductComponents() {
        if (isAnyProductSelected) {
            lbSelectedProduct.setVisible(true);
            lbItemName.setVisible(true);
            lbPrice.setVisible(true);
            lbBrand.setVisible(true);
            lbIconAddToCart.setVisible(true);
            tpDescription.setVisible(true);
        } else {
            lbSelectedProduct.setVisible(false);
            lbItemName.setVisible(false);
            lbPrice.setVisible(false);
            lbBrand.setVisible(false);
            lbIconAddToCart.setVisible(false);
            tpDescription.setVisible(false);
        }
    }

    public void verifyUserLogged() {
        
        if (SessionController.getInstance().isLoggedIn()) {
            lbLogOut.setVisible(true);
        } else {
            lbLogOut.setVisible(false);
        }

    }

    public void setSelectedProduct(Product p){
        selectedProduct = p;
    
        initSelectedProductComponents();
    
        lbSelectedProduct.setIcon(new ImageIcon(getClass().getResource(p.getImgUrl())));
        lbItemName.setText(p.getName());
        lbPrice.setText("R$ " + p.getPrice());
        lbBrand.setText("Decrease");
        tpDescription.setText(p.getDescription());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tpDescription = new javax.swing.JTextPane();
        lbBrand = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        lbIconAddToCart = new javax.swing.JLabel();
        lbSelectedProduct = new javax.swing.JLabel();
        lb1stProduct = new javax.swing.JLabel();
        lb2ndProduct = new javax.swing.JLabel();
        lb3rdProduct = new javax.swing.JLabel();
        lb4thProduct = new javax.swing.JLabel();
        lbItemName = new javax.swing.JLabel();
        lbHome = new javax.swing.JLabel();
        lbProducts = new javax.swing.JLabel();
        lbIconCart = new javax.swing.JLabel();
        lbIconProfile = new javax.swing.JLabel();
        lbLogOut = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tpDescription.setEditable(false);
        tpDescription.setBackground(new java.awt.Color(250, 250, 250));
        tpDescription.setBorder(null);
        tpDescription.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        tpDescription.setForeground(new java.awt.Color(51, 51, 51));
        tpDescription.setFocusable(false);
        tpDescription.setOpaque(false);
        add(tpDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 200, 160));

        lbBrand.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbBrand.setForeground(new java.awt.Color(0, 0, 0));
        lbBrand.setText("Brand");
        add(lbBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        lbPrice.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbPrice.setForeground(new java.awt.Color(0, 0, 0));
        lbPrice.setText("R$0.00");
        add(lbPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        lbIconAddToCart.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbIconAddToCart.setForeground(new java.awt.Color(0, 0, 0));
        lbIconAddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/addCart.png"))); // NOI18N
        lbIconAddToCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIconAddToCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIconAddToCartMouseClicked(evt);
            }
        });
        add(lbIconAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, 30));
        add(lbSelectedProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 200, 200));

        lb1stProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/products/wheyProtein.png"))); // NOI18N
        lb1stProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb1stProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb1stProductMouseClicked(evt);
            }
        });
        add(lb1stProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 200, 200));

        lb2ndProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/products/creatine.png"))); // NOI18N
        lb2ndProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb2ndProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb2ndProductMouseClicked(evt);
            }
        });
        add(lb2ndProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 200, 200));

        lb3rdProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/products/peanutButter.png"))); // NOI18N
        lb3rdProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb3rdProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb3rdProductMouseClicked(evt);
            }
        });
        add(lb3rdProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 120, 200, 200));

        lb4thProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/products/hypercaloric.png"))); // NOI18N
        lb4thProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb4thProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb4thProductMouseClicked(evt);
            }
        });
        add(lb4thProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, 200, 200));

        lbItemName.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lbItemName.setForeground(new java.awt.Color(0, 0, 0));
        lbItemName.setText("Item Name");
        add(lbItemName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, 30));

        lbHome.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbHome.setForeground(new java.awt.Color(0, 0, 0));
        lbHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHome.setText("Home");
        lbHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHome.setIconTextGap(7);
        lbHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHomeMouseClicked(evt);
            }
        });
        add(lbHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 80, -1));

        lbProducts.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbProducts.setForeground(new java.awt.Color(0, 0, 0));
        lbProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProducts.setText("Products");
        lbProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbProducts.setIconTextGap(7);
        add(lbProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 80, -1));

        lbIconCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/cart.png"))); // NOI18N
        lbIconCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIconCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIconCartMouseClicked(evt);
            }
        });
        add(lbIconCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 40, 40));

        lbIconProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/user.png"))); // NOI18N
        lbIconProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIconProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIconProfileMouseClicked(evt);
            }
        });
        add(lbIconProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, 40, 40));

        lbLogOut.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbLogOut.setForeground(new java.awt.Color(0, 0, 0));
        lbLogOut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/logout.png"))); // NOI18N
        lbLogOut.setText("LOG OUT");
        lbLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogOutMouseClicked(evt);
            }
        });
        add(lbLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 50, 110, 40));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/backgrounds/base.png"))); // NOI18N
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void lbIconCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIconCartMouseClicked
        String msg;
        
        if (SessionController.getInstance().isLoggedIn()) {
            MainFrame.cart = new Cart();
            EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.cart);
        } else {
            msg = 
                """
                You must be logged in to access your cart.
                Please access the profile section and log in
                """;

            Alerts.showAlertMessage(msg, "Alert!", null);
        }

    }//GEN-LAST:event_lbIconCartMouseClicked

    private void lbIconProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIconProfileMouseClicked
        MainFrame.profile = new Profile();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.profile);
    }//GEN-LAST:event_lbIconProfileMouseClicked

    private void lbLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseClicked
        if (SessionController.getInstance().isLoggedIn()) {

            String msg = 
                    """
                    Are you sure you want to quit?
                    Don't worry, your data will remain saved until you return.
                    """;

            int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

            if (option == 0) {
                SessionController.getInstance().logOut();

                MainFrame.home = new Home();
                EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
                msg = 
                    """
                    Logout completed successfully!
                    You have been logged out of our system.
                    If you want to enjoy all the features, log in again.
                    """;

                Alerts.showSuccessMessage(msg, "Log Out Performed", null);
            }

        }
        
    }//GEN-LAST:event_lbLogOutMouseClicked

    private void lbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHomeMouseClicked
        MainFrame.home = new Home();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
    }//GEN-LAST:event_lbHomeMouseClicked

    private void lb1stProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb1stProductMouseClicked
        isAnyProductSelected = true;
        Product p1 = EcommerceT1LpApplication.mainFrame.productController.findById(1L);
        setSelectedProduct(p1);
    }//GEN-LAST:event_lb1stProductMouseClicked

    private void lb2ndProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb2ndProductMouseClicked
        isAnyProductSelected = true;
        Product p2 = EcommerceT1LpApplication.mainFrame.productController.findById(2L);
        setSelectedProduct(p2);
    }//GEN-LAST:event_lb2ndProductMouseClicked

    private void lb3rdProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3rdProductMouseClicked
        isAnyProductSelected = true;
        Product p3 = EcommerceT1LpApplication.mainFrame.productController.findById(3L);
        setSelectedProduct(p3);
    }//GEN-LAST:event_lb3rdProductMouseClicked

    private void lb4thProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb4thProductMouseClicked
        isAnyProductSelected = true;
        Product p4 = EcommerceT1LpApplication.mainFrame.productController.findById(4L);
        setSelectedProduct(p4);
    }//GEN-LAST:event_lb4thProductMouseClicked

    private void lbIconAddToCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIconAddToCartMouseClicked
        String msg;
        
        if (SessionController.getInstance().isLoggedIn()) {
            
            if (isAnyProductSelected) {

                msg = 
                    """
                    This product will be added to your cart.
                    Are you sure about this operation?
                    """;

                int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

                if (option == 0) {
                    EcommerceT1LpApplication.mainFrame.cartController.addProductToCart(selectedProduct, 1, SessionController.getInstance());
                }

            }
        
        } else {
            msg = 
                """
                You must be logged in to add an item to your cart.
                Please access the profile section and log in.
                """;

            Alerts.showAlertMessage(msg, "Alert!", null);
        }

    }//GEN-LAST:event_lbIconAddToCartMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb1stProduct;
    private javax.swing.JLabel lb2ndProduct;
    private javax.swing.JLabel lb3rdProduct;
    private javax.swing.JLabel lb4thProduct;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbIconAddToCart;
    private javax.swing.JLabel lbIconCart;
    private javax.swing.JLabel lbIconProfile;
    private javax.swing.JLabel lbItemName;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbProducts;
    private javax.swing.JLabel lbSelectedProduct;
    private javax.swing.JTextPane tpDescription;
    // End of variables declaration//GEN-END:variables
}
