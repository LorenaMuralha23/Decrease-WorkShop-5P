package com.decrease.view.panels;

import com.decrease.EcommerceT1LpApplication;
import com.decrease.entities.User;
import com.decrease.model.Alerts;
import com.decrease.model.CustomException;
import com.decrease.view.MainFrame;
import java.util.Arrays;

public class SignUp extends javax.swing.JPanel {

    public SignUp() {
        initComponents();
    }

    public void clearForm() {
        tfName.setText("");
        tfEmail.setText("");
        tfPhoneNum.setText("");
        pFdConfirmPass.setText("");
        pFdPass.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbLogIn = new javax.swing.JLabel();
        lb1stTxt = new javax.swing.JLabel();
        lbRegister = new javax.swing.JLabel();
        lbSlogan = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        tfPhoneNum = new javax.swing.JTextField();
        lbPhoneNum = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        pFdConfirmPass = new javax.swing.JPasswordField();
        lbConfirmPass = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        pFdPass = new javax.swing.JPasswordField();
        lbPass = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        lbClose = new javax.swing.JLabel();
        lbBackground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbLogIn.setFont(new java.awt.Font("Malgun Gothic", 1, 16)); // NOI18N
        lbLogIn.setForeground(new java.awt.Color(128, 78, 67));
        lbLogIn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogIn.setText("Log In");
        lbLogIn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lbLogIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbLogInMouseClicked(evt);
            }
        });
        add(lbLogIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 60, 20));

        lb1stTxt.setFont(new java.awt.Font("Malgun Gothic", 0, 16)); // NOI18N
        lb1stTxt.setForeground(new java.awt.Color(51, 51, 51));
        lb1stTxt.setText("Already have an account?");
        add(lb1stTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 490, 200, 20));

        lbRegister.setFont(new java.awt.Font("Malgun Gothic", 1, 28)); // NOI18N
        lbRegister.setForeground(new java.awt.Color(0, 0, 0));
        lbRegister.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/addUser.png"))); // NOI18N
        lbRegister.setText("Register");
        lbRegister.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbRegisterMouseClicked(evt);
            }
        });
        add(lbRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 410, 160, 60));

        lbSlogan.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        lbSlogan.setForeground(new java.awt.Color(0, 0, 0));
        lbSlogan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSlogan.setText("Unlock Your Potential, Decrease Limits");
        add(lbSlogan, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 400, 50));

        lbBrand.setFont(new java.awt.Font("Malgun Gothic", 1, 70)); // NOI18N
        lbBrand.setForeground(new java.awt.Color(0, 0, 0));
        lbBrand.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbBrand.setText("decrease");
        add(lbBrand, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 460, 110));

        lbName.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbName.setForeground(new java.awt.Color(51, 51, 51));
        lbName.setText("Name");
        add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 170, -1));

        tfPhoneNum.setBackground(new java.awt.Color(250, 250, 250));
        tfPhoneNum.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfPhoneNum.setForeground(new java.awt.Color(51, 51, 51));
        tfPhoneNum.setBorder(null);
        tfPhoneNum.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 290, 310, 30));

        lbPhoneNum.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbPhoneNum.setForeground(new java.awt.Color(51, 51, 51));
        lbPhoneNum.setText("Phone Number");
        add(lbPhoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 170, -1));

        tfEmail.setBackground(new java.awt.Color(250, 250, 250));
        tfEmail.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfEmail.setForeground(new java.awt.Color(51, 51, 51));
        tfEmail.setBorder(null);
        tfEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, 310, 30));

        pFdConfirmPass.setBackground(new java.awt.Color(250, 250, 250));
        pFdConfirmPass.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        pFdConfirmPass.setForeground(new java.awt.Color(51, 51, 51));
        pFdConfirmPass.setBorder(null);
        pFdConfirmPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(pFdConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 310, 30));

        lbConfirmPass.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbConfirmPass.setForeground(new java.awt.Color(51, 51, 51));
        lbConfirmPass.setText("Confirm Password");
        add(lbConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 340, 170, -1));

        lbEmail.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbEmail.setForeground(new java.awt.Color(51, 51, 51));
        lbEmail.setText("Email");
        add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 170, -1));

        pFdPass.setBackground(new java.awt.Color(250, 250, 250));
        pFdPass.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        pFdPass.setForeground(new java.awt.Color(51, 51, 51));
        pFdPass.setBorder(null);
        pFdPass.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(pFdPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 310, 30));

        lbPass.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbPass.setForeground(new java.awt.Color(51, 51, 51));
        lbPass.setText("Password");
        add(lbPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, 170, -1));

        tfName.setBackground(new java.awt.Color(250, 250, 250));
        tfName.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        tfName.setForeground(new java.awt.Color(51, 51, 51));
        tfName.setBorder(null);
        tfName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 640, 30));

        lbClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/close.png"))); // NOI18N
        lbClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });
        add(lbClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/backgrounds/signUp.png"))); // NOI18N
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, -1, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void lbLogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbLogInMouseClicked
        MainFrame.signIn = new SignIn();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.signIn);
    }//GEN-LAST:event_lbLogInMouseClicked

    private void lbRegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbRegisterMouseClicked
        String msg = "";
        String name = tfName.getText();
        String email = tfEmail.getText();
        String phoneNum = tfPhoneNum.getText();
        char[] pass = pFdPass.getPassword();
        char[] confirmPass = pFdConfirmPass.getPassword();

        try {

            if (!name.equals("") && !email.equals("") && !phoneNum.equals("") && !pass.equals("") && !confirmPass.equals("")) {

                if (Arrays.equals(pass, confirmPass)) {

                    String strPass = new String(pass);
                    
                    User newUser = new User();
                    newUser.setName(name);
                    newUser.setEmail(email);
                    newUser.setPassword(strPass);
                    newUser.setPhone(phoneNum);
                    EcommerceT1LpApplication.mainFrame.userController.createNewUser(newUser);
                    
                    msg =
                        """
                        Congratulations, you have completed your registration and can now enjoy all the benefits of our system.
                        See you on the other side!
                        """;

                    Alerts.showSuccessMessage(msg, "Welcome to Decrease!", null);
                    clearForm();

                    MainFrame.signIn = new SignIn();
                    EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.signIn);

                } else {
                    msg =
                        """ 
                        You must fill in the password fields with the same password.
                        Please try again
                        """;

                    throw new CustomException(msg);
                }

            } else {
                msg = "Fill in all the fields to register";
                Alerts.showAlertMessage(msg, "Fields Not Filled In", null);
            }

        } catch (CustomException e) {
            Alerts.showErrorMessage(e.getMessage(), "There was a Problem", null);
        }
    }//GEN-LAST:event_lbRegisterMouseClicked

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        MainFrame.home = new Home();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
    }//GEN-LAST:event_lbCloseMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb1stTxt;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbClose;
    private javax.swing.JLabel lbConfirmPass;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbLogIn;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPass;
    private javax.swing.JLabel lbPhoneNum;
    private javax.swing.JLabel lbRegister;
    private javax.swing.JLabel lbSlogan;
    private javax.swing.JPasswordField pFdConfirmPass;
    private javax.swing.JPasswordField pFdPass;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfName;
    private javax.swing.JTextField tfPhoneNum;
    // End of variables declaration//GEN-END:variables
}
