package com.decrease.view.panels;

import com.decrease.EcommerceT1LpApplication;
import com.decrease.controller.SessionController;
import com.decrease.entities.User;
import com.decrease.model.Alerts;
import com.decrease.view.MainFrame;

/**
 * A classe EditProfile representa o painel de edição de perfil do usuário em uma aplicação de comércio eletrônico.
 * Este painel permite que o usuário edite suas informações pessoais, como nome, email e número de telefone.
 * Além disso, fornece acesso a funcionalidades como carrinho de compras, perfil do usuário e logout.
 */
public class EditProfile extends javax.swing.JPanel {

    /**
     * Construtor padrão da classe EditProfile.
     * Inicializa os componentes do painel.
     */
    public EditProfile() {
        initComponents();
    }

    /**
     * Limpa o formulário de edição de perfil, resetando os campos de nome, email e número de telefone.
     */
    public void clearForm() {
        tfEmail.setText("");
        tfName.setText("");
        tfPhoneNumber.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1stTxt = new javax.swing.JLabel();
        tfPhoneNumber = new javax.swing.JTextField();
        tfName = new javax.swing.JTextField();
        lbName = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbPhoneNumber = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        lbIconName = new javax.swing.JLabel();
        lbIconPhoneNum = new javax.swing.JLabel();
        lbIconEmail = new javax.swing.JLabel();
        lbCancel = new javax.swing.JLabel();
        lbUpdate = new javax.swing.JLabel();
        lbIconLogo = new javax.swing.JLabel();
        lbHome = new javax.swing.JLabel();
        lbProducts = new javax.swing.JLabel();
        lbIconCart = new javax.swing.JLabel();
        lbIconProfile = new javax.swing.JLabel();
        lbLogOut = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 600));
        setMinimumSize(new java.awt.Dimension(1280, 600));
        setPreferredSize(new java.awt.Dimension(1280, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb1stTxt.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lb1stTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb1stTxt.setText("Enter the data to be updated");
        lb1stTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lb1stTxt.setIconTextGap(7);
        add(lb1stTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 270, -1));

        tfPhoneNumber.setBackground(new java.awt.Color(250, 250, 250));
        tfPhoneNumber.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfPhoneNumber.setForeground(new java.awt.Color(51, 51, 51));
        tfPhoneNumber.setBorder(null);
        tfPhoneNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 280, 30));

        tfName.setBackground(new java.awt.Color(250, 250, 250));
        tfName.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfName.setForeground(new java.awt.Color(51, 51, 51));
        tfName.setBorder(null);
        tfName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 610, 30));

        lbName.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(51, 51, 51));
        lbName.setText("Name");
        lbName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 170, -1));

        lbEmail.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(51, 51, 51));
        lbEmail.setText("Email");
        lbEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 170, -1));

        lbPhoneNumber.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbPhoneNumber.setForeground(new java.awt.Color(51, 51, 51));
        lbPhoneNumber.setText("Phone Number");
        lbPhoneNumber.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lbPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 170, -1));

        tfEmail.setBackground(new java.awt.Color(250, 250, 250));
        tfEmail.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfEmail.setForeground(new java.awt.Color(51, 51, 51));
        tfEmail.setBorder(null);
        tfEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 280, 30));

        lbIconName.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        lbIconName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbIconName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/name.png"))); // NOI18N
        lbIconName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lbIconName, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 40, 30));

        lbIconPhoneNum.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        lbIconPhoneNum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbIconPhoneNum.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/phone.png"))); // NOI18N
        lbIconPhoneNum.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lbIconPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 40, 30));

        lbIconEmail.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        lbIconEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbIconEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/email.png"))); // NOI18N
        lbIconEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        add(lbIconEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 40, 30));

        lbCancel.setBackground(new java.awt.Color(0, 0, 0));
        lbCancel.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbCancel.setForeground(new java.awt.Color(255, 255, 255));
        lbCancel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCancel.setText("CANCEL");
        lbCancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbCancel.setOpaque(true);
        lbCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCancelMouseClicked(evt);
            }
        });
        add(lbCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 200, 40));

        lbUpdate.setBackground(new java.awt.Color(0, 0, 0));
        lbUpdate.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbUpdate.setForeground(new java.awt.Color(255, 255, 255));
        lbUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbUpdate.setText("UPDATE");
        lbUpdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lbUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbUpdate.setOpaque(true);
        lbUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbUpdateMouseClicked(evt);
            }
        });
        add(lbUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 380, 200, 40));

        lbIconLogo.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        lbIconLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/logoPNG.png"))); // NOI18N
        lbIconLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/backgrounds/editProfile.png"))); // NOI18N
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, -1, 600));
    }// </editor-fold>//GEN-END:initComponents

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
     * Método executado quando o texto "Atualizar" é clicado.
     * Realiza a atualização das informações do usuário.
     * 
     * @param evt O evento de clique do mouse associado.
     */
    private void lbUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUpdateMouseClicked
        String msg = "";

        if (tfEmail.getText().isBlank() == false && tfName.getText().isBlank() == false && tfPhoneNumber.getText().isBlank() == false) {
            msg =
                """
                Confirm your changes before closing!
                Are you sure you want to edit your data?
                """;

            int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

            if (option == 0) {
                User tempUser = new User();
                tempUser.setEmail(tfEmail.getText());
                tempUser.setName(tfName.getText());
                tempUser.setPhone(tfPhoneNumber.getText());
                // EcommerceT1LpApplication.mainFrame.userController.getUserLogged();

                msg =
                    """
                    Your data has been changed successfully!
                    """;

                Alerts.showSuccessMessage(msg, "Information Message", null);
            }
        
        } else {
            msg = 
                """
                You forgot to fill in a field!
                Please review your information so we can finalize your update.
                """;

            Alerts.showAlertMessage(msg, "Alert!", null);
        }


    }//GEN-LAST:event_lbUpdateMouseClicked

    /**
     * Método executado quando o texto "Cancelar" é clicado.
     * Cancela a ação de atualização de perfil, limpando o formulário.
     * 
     * @param evt O evento de clique do mouse associado.
     */
    private void lbCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCancelMouseClicked
        clearForm();
        String msg =
                """
                The action to update your data has been canceled!
                """;
        Alerts.showErrorMessage(msg, "Operation canceled successfully!", null);
    }//GEN-LAST:event_lbCancelMouseClicked

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
    private javax.swing.JLabel lb1stTxt;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbCancel;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbIconCart;
    private javax.swing.JLabel lbIconEmail;
    private javax.swing.JLabel lbIconLogo;
    private javax.swing.JLabel lbIconName;
    private javax.swing.JLabel lbIconPhoneNum;
    private javax.swing.JLabel lbIconProfile;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPhoneNumber;
    private javax.swing.JLabel lbProducts;
    private javax.swing.JLabel lbUpdate;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
