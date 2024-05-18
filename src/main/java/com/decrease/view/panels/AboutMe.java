package com.decrease.view.panels;

import com.decrease.EcommerceT1LpApplication;
import com.decrease.controller.SessionController;
import com.decrease.model.Alerts;
import com.decrease.view.MainFrame;

/**
 * A classe AboutMe representa o painel de informações do usuário em uma aplicação de comércio eletrônico.
 * Este painel exibe informações sobre o usuário logado e fornece acesso a funcionalidades como carrinho de compras, perfil do usuário e logout.
 */
public class AboutMe extends javax.swing.JPanel {

    /**
     * Construtor padrão da classe AboutMe.
     * Inicializa os componentes do painel e exibe informações do usuário logado.
     */
    public AboutMe() {
        initComponents();

        lbName.setText(EcommerceT1LpApplication.mainFrame.userController.getUserLogged(SessionController.getInstance()).getName());
        lbEmail.setText(EcommerceT1LpApplication.mainFrame.userController.getUserLogged(SessionController.getInstance()).getEmail());
        lbPhoneNumber.setText(EcommerceT1LpApplication.mainFrame.userController.getUserLogged(SessionController.getInstance()).getPhone());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbEmail = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbPhoneNumber = new javax.swing.JLabel();
        lbTextOne = new javax.swing.JLabel();
        lbIconCart = new javax.swing.JLabel();
        lbIconLogo = new javax.swing.JLabel();
        lbHome = new javax.swing.JLabel();
        lbProducts = new javax.swing.JLabel();
        lbIconProfile = new javax.swing.JLabel();
        lbLogOut = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 600));
        setMinimumSize(new java.awt.Dimension(1280, 600));
        setPreferredSize(new java.awt.Dimension(1280, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbEmail.setFont(new java.awt.Font("Malgun Gothic", 1, 20)); // NOI18N
        lbEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/email.png"))); // NOI18N
        lbEmail.setText("Email");
        lbEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 490, 60));

        lbName.setFont(new java.awt.Font("Malgun Gothic", 1, 20)); // NOI18N
        lbName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/name.png"))); // NOI18N
        lbName.setText("Name");
        lbName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 200, 490, 60));

        lbPhoneNumber.setFont(new java.awt.Font("Malgun Gothic", 1, 20)); // NOI18N
        lbPhoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbPhoneNumber.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/phone.png"))); // NOI18N
        lbPhoneNumber.setText("Phone Number");
        lbPhoneNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(lbPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 490, 60));

        lbTextOne.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbTextOne.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbTextOne.setText("PROFILE INFORMATIONS");
        lbTextOne.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbTextOne.setIconTextGap(7);
        add(lbTextOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 160, 170, -1));

        lbIconCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/cart.png"))); // NOI18N
        lbIconCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIconCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIconCartMouseClicked(evt);
            }
        });
        add(lbIconCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 50, 40, 40));

        lbIconLogo.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        lbIconLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/logoPNG.png"))); // NOI18N
        add(lbIconLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 200));

        lbHome.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
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
        lbProducts.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProducts.setText("Products");
        lbProducts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbProducts.setIconTextGap(7);
        lbProducts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbProductsMouseClicked(evt);
            }
        });
        add(lbProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 60, 80, -1));

        lbIconProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/user.png"))); // NOI18N
        lbIconProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbIconProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIconProfileMouseClicked(evt);
            }
        });
        add(lbIconProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, 40, 40));

        lbLogOut.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
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
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, -1, 600));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método executado quando o ícone do carrinho é clicado.
     * Abre o painel do carrinho se o usuário estiver logado, senão exibe uma mensagem de alerta.
     * 
     * @param evt O evento de clique do mouse associado.
     */
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

    /**
     * Método executado quando o texto "Produtos" é clicado.
     * Abre o painel de produtos.
     * 
     * @param evt O evento de clique do mouse associado.
     */
    private void lbProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbProductsMouseClicked
        MainFrame.products = new Products();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.products);
    }//GEN-LAST:event_lbProductsMouseClicked

    /**
     * Método executado quando o ícone do perfil é clicado.
     * Abre o painel de perfil.
     * 
     * @param evt O evento de clique do mouse associado.
     */
    private void lbIconProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIconProfileMouseClicked
        MainFrame.profile = new Profile();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.profile);
    }//GEN-LAST:event_lbIconProfileMouseClicked

    /**
     * Método executado quando o texto "Sair" é clicado.
     * Realiza o logout do usuário.
     * 
     * @param evt O evento de clique do mouse associado.
     */
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

    /**
     * Método executado quando o texto "Início" é clicado.
     * Retorna à tela inicial.
     * 
     * @param evt O evento de clique do mouse associado.
     */
    private void lbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHomeMouseClicked
        MainFrame.home = new Home();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
    }//GEN-LAST:event_lbHomeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbIconCart;
    private javax.swing.JLabel lbIconLogo;
    private javax.swing.JLabel lbIconProfile;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPhoneNumber;
    private javax.swing.JLabel lbProducts;
    private javax.swing.JLabel lbTextOne;
    // End of variables declaration//GEN-END:variables
}
