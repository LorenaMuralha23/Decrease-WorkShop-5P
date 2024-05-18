package com.decrease.view.panels;

import com.decrease.EcommerceT1LpApplication;
import com.decrease.controller.SessionController;
import com.decrease.entities.User;
import com.decrease.model.Alerts;
import com.decrease.view.MainFrame;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

/**
 * A classe Profile representa o painel que exibe o perfil do usuário e permite
 * realizar ações relacionadas a ele.
 */
public class Profile extends javax.swing.JPanel {

    /**
     * Referência ao usuário logado.
     */
    private User userLogged;

    /**
     * Construtor da classe Profile. Inicializa os componentes do painel, obtém
     * o usuário logado e verifica se há usuário logado.
     */
    public Profile() {
        initComponents();
        userLogged = EcommerceT1LpApplication.mainFrame.userController.getUserLogged(SessionController.getInstance());
        verifyUserLogged();
        setText();
    }

    /**
     * Método que verifica se há um usuário logado e atualiza a exibição dos
     * componentes do perfil conforme necessário.
     */
    public void verifyUserLogged() {
        if (SessionController.getInstance().isLoggedIn()) {
            lbAboutMe.setIcon(new ImageIcon(getClass().getResource("/com/decrease/view/images/icons/aboutMe.png")));
            lbAboutMe.setText("About Me");

            lbDeleteProfile.setVisible(true);
            lbEditPass.setVisible(true);
            lbEditProfile.setVisible(true);
            lbLogOut.setVisible(true);

        } else {
            lbAboutMe.setIcon(new ImageIcon(getClass().getResource("/com/decrease/view/images/icons/login.png")));
            lbAboutMe.setText("Log In");

            lbDeleteProfile.setVisible(false);
            lbEditPass.setVisible(false);
            lbEditProfile.setVisible(false);
            lbLogOut.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb1stTxt = new javax.swing.JLabel();
        lbEditProfile = new javax.swing.JLabel();
        lbAboutMe = new javax.swing.JLabel();
        lbEditPass = new javax.swing.JLabel();
        lbDeleteProfile = new javax.swing.JLabel();
        lbIconLogo = new javax.swing.JLabel();
        lbHome = new javax.swing.JLabel();
        lbProducts = new javax.swing.JLabel();
        lbIconCart = new javax.swing.JLabel();
        lbIconProfile = new javax.swing.JLabel();
        lbLogOut = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb1stTxt.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lb1stTxt.setForeground(new java.awt.Color(0, 0, 0));
        lb1stTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb1stTxt.setText("PROFILE SETTINGS");
        lb1stTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb1stTxt.setIconTextGap(7);
        add(lb1stTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 197, -1));

        lbEditProfile.setFont(new java.awt.Font("Malgun Gothic", 1, 20)); // NOI18N
        lbEditProfile.setForeground(new java.awt.Color(0, 0, 0));
        lbEditProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbEditProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/editUser.png"))); // NOI18N
        lbEditProfile.setText("Edit Profile");
        lbEditProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEditProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEditProfileMouseClicked(evt);
            }
        });
        add(lbEditProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 220, 60));

        lbAboutMe.setFont(new java.awt.Font("Malgun Gothic", 1, 20)); // NOI18N
        lbAboutMe.setForeground(new java.awt.Color(0, 0, 0));
        lbAboutMe.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbAboutMe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/aboutMe.png"))); // NOI18N
        lbAboutMe.setText("About Me");
        lbAboutMe.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbAboutMe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbAboutMeMouseClicked(evt);
            }
        });
        add(lbAboutMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 220, 60));

        lbEditPass.setFont(new java.awt.Font("Malgun Gothic", 1, 20)); // NOI18N
        lbEditPass.setForeground(new java.awt.Color(0, 0, 0));
        lbEditPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbEditPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/passwordReset.png"))); // NOI18N
        lbEditPass.setText("Edit Password");
        lbEditPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbEditPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbEditPassMouseClicked(evt);
            }
        });
        add(lbEditPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 220, 220, 60));

        lbDeleteProfile.setFont(new java.awt.Font("Malgun Gothic", 1, 20)); // NOI18N
        lbDeleteProfile.setForeground(new java.awt.Color(0, 0, 0));
        lbDeleteProfile.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDeleteProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/deleteUser.png"))); // NOI18N
        lbDeleteProfile.setText("Delete Profile");
        lbDeleteProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDeleteProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDeleteProfileMouseClicked(evt);
            }
        });
        add(lbDeleteProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, 220, 60));

        lbIconLogo.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        lbIconLogo.setForeground(new java.awt.Color(0, 0, 0));
        lbIconLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/logoPNG.png"))); // NOI18N
        add(lbIconLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 200));

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
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, -1, 600));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método executado quando o texto "Produtos" é clicado. Abre o painel de
     * produtos.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbProductsMouseClicked
        MainFrame.products = new Products();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.products);
    }//GEN-LAST:event_lbProductsMouseClicked

    /**
     * Método executado quando o ícone do carrinho é clicado. Abre o painel do
     * carrinho se o usuário estiver logado, senão exibe uma mensagem de alerta.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbIconCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbIconCartMouseClicked
        String msg;

        if (SessionController.getInstance().isLoggedIn()) {
            MainFrame.cart = new Cart();
            EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.cart);
        } else {
            msg = EcommerceT1LpApplication.msgManager.getMessage("logged-alert");

            Alerts.showAlertMessage(msg, "Alert!", null);
        }

    }//GEN-LAST:event_lbIconCartMouseClicked

    /**
     * Método executado quando o texto "Sair" é clicado. Realiza o logout do
     * usuário.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogOutMouseClicked
        if (SessionController.getInstance().isLoggedIn()) {

            String msg = 
                    EcommerceT1LpApplication.msgManager.getMessage("quit-alert");

            int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

            if (option == 0) {
                SessionController.getInstance().logOut();

                MainFrame.home = new Home();
                EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
                msg
                        = 
                    EcommerceT1LpApplication.msgManager.getMessage("success-logout-alert");

                Alerts.showSuccessMessage(msg, "Log Out Performed", null);
            }

        }

    }//GEN-LAST:event_lbLogOutMouseClicked

    /**
     * Método executado quando o texto "Sobre Mim" é clicado. Abre o painel
     * "AboutMe" se o usuário estiver logado, senão abre o painel de login.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbAboutMeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbAboutMeMouseClicked
        if (SessionController.getInstance().isLoggedIn()) {
            MainFrame.aboutMe = new AboutMe();
            EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.aboutMe);
        } else {
            MainFrame.signIn = new SignIn();
            EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.signIn);
        }

    }//GEN-LAST:event_lbAboutMeMouseClicked

    /**
     * Método executado quando o texto "Editar Perfil" é clicado. Abre o painel
     * "EditProfile" se estiver visível.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbEditProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEditProfileMouseClicked
        if (lbEditProfile.isVisible()) {
            MainFrame.editProfile = new EditProfile();
            EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.editProfile);
        }
    }//GEN-LAST:event_lbEditProfileMouseClicked

    /**
     * Método executado quando o texto "Editar Senha" é clicado. Abre o painel
     * "EditPassword" se estiver visível.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbEditPassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbEditPassMouseClicked
        if (lbEditPass.isVisible()) {
            MainFrame.editPass = new EditPassword();
            EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.editPass);
        }
    }//GEN-LAST:event_lbEditPassMouseClicked

    /**
     * Método executado quando o texto "Excluir Perfil" é clicado. Exibe uma
     * mensagem de confirmação e, se confirmado, solicita a senha e tenta
     * excluir a conta.
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbDeleteProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDeleteProfileMouseClicked
        if (lbDeleteProfile.isVisible()) {

            String msg
                    = """
                Are you sure you want to delete your account?
                This action, once done, there is no way to undo it.
                """;

            int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

            if (option == 0) {
                JPasswordField passwordField = new JPasswordField();

                ImageIcon icon = new ImageIcon("src/main/resources/com/decrease/view/videos/gifs/confirm.gif");
                option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your password:", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icon);

                if (option == JOptionPane.OK_OPTION) {
                    char[] password = passwordField.getPassword();
                    String typedPassword = new String(password);

                    if (typedPassword.equals(userLogged.getPassword())) {

                        msg
                                = """
                            Your password is correct!
                            We will delete your account.
                            """;
                        Alerts.showSuccessMessage(msg, "Action Confirmed", null);

                        // deleteAccount();
                    } else {
                        msg
                                = """
                            Your password is incorrect.
                            We will cancel the account deletion procedure
                            """;
                        Alerts.showErrorMessage(msg, "Action Canceled", null);
                    }
                } else {
                    msg
                            = """
                        We will cancel the account deletion procedure
                        """;
                    Alerts.showInformationMessage(msg, "Action Canceled by the User", null);
                }
            }

        }
    }//GEN-LAST:event_lbDeleteProfileMouseClicked

    /**
     * Método executado quando o texto "Início" é clicado. Abre o painel "Home".
     *
     * @param evt O evento de clique do mouse associado.
     */
    private void lbHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHomeMouseClicked
        MainFrame.home = new Home();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
        EcommerceT1LpApplication.mainFrame.setTextHome();
    }//GEN-LAST:event_lbHomeMouseClicked

    public void setText() {
        lbHome.setText(EcommerceT1LpApplication.msgManager.getMessage("home-button"));
        lb1stTxt.setText(EcommerceT1LpApplication.msgManager.getMessage("profile-setting"));
        lbProducts.setText(EcommerceT1LpApplication.msgManager.getMessage("products-button"));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb1stTxt;
    private javax.swing.JLabel lbAboutMe;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbDeleteProfile;
    private javax.swing.JLabel lbEditPass;
    private javax.swing.JLabel lbEditProfile;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbIconCart;
    private javax.swing.JLabel lbIconLogo;
    private javax.swing.JLabel lbIconProfile;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbProducts;
    // End of variables declaration//GEN-END:variables
}
