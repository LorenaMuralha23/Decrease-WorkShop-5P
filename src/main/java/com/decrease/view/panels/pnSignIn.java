package com.decrease.view.panels;

import com.decrease.EcommerceT1LpApplication;
import com.decrease.controller.SessionController;
import com.decrease.model.Alerts;
import com.decrease.model.CustomException;
import com.decrease.view.MainFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A classe SignIn representa o painel de login da aplicação.
 */
public class SignIn extends javax.swing.JPanel {
    
    /**
     * Construtor da classe SignIn.
     * Inicializa os componentes do painel.
     */
    public SignIn() {
        initComponents();
    }

    /**
     * Método para limpar os campos do formulário de login.
     */
    public void clearForm() {
        tfEmail.setText("");
        pFdPass.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbSlogan = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        lbPass = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        pFdPass = new javax.swing.JPasswordField();
        lb1stTxt = new javax.swing.JLabel();
        lbRegister = new javax.swing.JLabel();
        lbLogIn = new javax.swing.JLabel();
        lbClose = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1280, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSlogan.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        lbSlogan.setForeground(new java.awt.Color(0, 0, 0));
        lbSlogan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSlogan.setText("Unlock Your Potential, Decrease Limits");
        add(lbSlogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 400, 50));

        lbBrand.setFont(new java.awt.Font("Malgun Gothic", 1, 70)); // NOI18N
        lbBrand.setForeground(new java.awt.Color(0, 0, 0));
        lbBrand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBrand.setText("decrease");
        add(lbBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 460, 110));

        lbPass.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbPass.setForeground(new java.awt.Color(51, 51, 51));
        lbPass.setText("Password");
        add(lbPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 170, -1));

        lbEmail.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(51, 51, 51));
        lbEmail.setText("Email");
        add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 230, 170, -1));

        tfEmail.setBackground(new java.awt.Color(250, 250, 250));
        tfEmail.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfEmail.setForeground(new java.awt.Color(51, 51, 51));
        tfEmail.setBorder(null);
        tfEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 440, 30));

        pFdPass.setBackground(new java.awt.Color(250, 250, 250));
        pFdPass.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        pFdPass.setForeground(new java.awt.Color(51, 51, 51));
        pFdPass.setBorder(null);
        pFdPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(pFdPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 330, 440, 30));

        lb1stTxt.setFont(new java.awt.Font("Malgun Gothic", 0, 16)); // NOI18N
        lb1stTxt.setForeground(new java.awt.Color(51, 51, 51));
        lb1stTxt.setText("Don't have an account?");
        add(lb1stTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 460, 180, 20));

        lbRegister.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lbRegister.setForeground(new java.awt.Color(128, 78, 67));
        lbRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRegister.setText("Register");
        lbRegister.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRegisterMouseClicked(evt);
            }
        });
        add(lbRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, 70, 20));

        lbLogIn.setFont(new java.awt.Font("Malgun Gothic", 1, 28)); // NOI18N
        lbLogIn.setForeground(new java.awt.Color(0, 0, 0));
        lbLogIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/login.png"))); // NOI18N
        lbLogIn.setText("Log In");
        lbLogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogInMouseClicked(evt);
            }
        });
        add(lbLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 160, 60));

        lbClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/close.png"))); // NOI18N
        lbClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });
        add(lbClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/backgrounds/signIn.png"))); // NOI18N
        lbBackground.setMinimumSize(new java.awt.Dimension(1280, 600));
        lbBackground.setPreferredSize(new java.awt.Dimension(1280, 600));
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método executado quando o texto "Registrar" é clicado.
     * Abre o painel de cadastro (SignUp).
     * 
     * @param evt O evento de clique do mouse associado.
     */
    private void lbRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRegisterMouseClicked
        MainFrame.signUp = new SignUp();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.signUp);
    }//GEN-LAST:event_lbRegisterMouseClicked

    /**
     * Método executado quando o texto "Entrar" é clicado.
     * Obtém o email e a senha do usuário e tenta fazer login.
     * 
     * @param evt O evento de clique do mouse associado.
     */
    private void lbLogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogInMouseClicked
        String email = tfEmail.getText();
        char[] password = pFdPass.getPassword();
        String msg;

        if (email.equals("") || password.equals("")) {
            msg
                    = """
                You must fill in all fields to enter.
                Please try again.
                """;

            Alerts.showAlertMessage(msg, "Fields Not Filled In", null);

        } else {
            String strPass = new String(password);
            boolean logIn;
            try {
                logIn = EcommerceT1LpApplication.mainFrame.userController.login(email, strPass, SessionController.getInstance());

                if (logIn) {
                    msg
                            = """
                    You have been correctly logged into the system!
                    Now you can enjoy all the features
                    """;
                    Alerts.showSuccessMessage(msg, "Action Confirmed", null);

                    MainFrame.home = new Home();
                    EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
                }
            } catch (CustomException ex) {
                Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_lbLogInMouseClicked

    /**
     * Método executado quando o texto "Fechar" é clicado.
     * Retorna ao painel inicial (Home).
     * 
     * @param evt O evento de clique do mouse associado.
     */
    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        MainFrame.home = new Home();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
    }//GEN-LAST:event_lbCloseMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb1stTxt;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbClose;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbLogIn;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbRegister;
    private javax.swing.JLabel lbSlogan;
    private javax.swing.JPasswordField pFdPass;
    private javax.swing.JTextField tfEmail;
    // End of variables declaration//GEN-END:variables
}
