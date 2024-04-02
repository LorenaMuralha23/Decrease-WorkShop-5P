package com.decrease.view.panels;

import com.decrease.EcommerceT1LpApplication;
import com.decrease.controller.SessionController;
import com.decrease.model.Alerts;
import com.decrease.model.CustomException;
import com.decrease.view.MainFrame;
import java.util.Arrays;

public class EditPassword extends javax.swing.JPanel {

    public EditPassword() {
        initComponents();
    }

    public void clearForm() {
        pFdConfirmNewPass.setText("");
        pFdCurrentPass.setText("");
        pFdNewPass.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIconCurrentPass = new javax.swing.JLabel();
        lbIconNewPass = new javax.swing.JLabel();
        lbNewPass = new javax.swing.JLabel();
        lbCurrentPass = new javax.swing.JLabel();
        pFdCurrentPass = new javax.swing.JPasswordField();
        pFdNewPass = new javax.swing.JPasswordField();
        lbConfirmNewPass = new javax.swing.JLabel();
        pFdConfirmNewPass = new javax.swing.JPasswordField();
        lb1stTxt = new javax.swing.JLabel();
        lbUpdate = new javax.swing.JLabel();
        lbCancel = new javax.swing.JLabel();
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

        lbIconCurrentPass.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        lbIconCurrentPass.setForeground(new java.awt.Color(0, 0, 0));
        lbIconCurrentPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbIconCurrentPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/key.png"))); // NOI18N
        lbIconCurrentPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(lbIconCurrentPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 40, 40));

        lbIconNewPass.setFont(new java.awt.Font("Nirmala UI", 1, 20)); // NOI18N
        lbIconNewPass.setForeground(new java.awt.Color(0, 0, 0));
        lbIconNewPass.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbIconNewPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/addKey.png"))); // NOI18N
        lbIconNewPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add(lbIconNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 40, 40));

        lbNewPass.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbNewPass.setForeground(new java.awt.Color(51, 51, 51));
        lbNewPass.setText("New Password");
        add(lbNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 170, -1));

        lbCurrentPass.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbCurrentPass.setForeground(new java.awt.Color(51, 51, 51));
        lbCurrentPass.setText("Current Password");
        add(lbCurrentPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 200, 170, -1));

        pFdCurrentPass.setBackground(new java.awt.Color(250, 250, 250));
        pFdCurrentPass.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        pFdCurrentPass.setForeground(new java.awt.Color(51, 51, 51));
        pFdCurrentPass.setBorder(null);
        add(pFdCurrentPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 310, 30));

        pFdNewPass.setBackground(new java.awt.Color(250, 250, 250));
        pFdNewPass.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        pFdNewPass.setForeground(new java.awt.Color(51, 51, 51));
        pFdNewPass.setBorder(null);
        add(pFdNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 290, 310, 30));

        lbConfirmNewPass.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbConfirmNewPass.setForeground(new java.awt.Color(51, 51, 51));
        lbConfirmNewPass.setText("Confirm New Password");
        add(lbConfirmNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 340, 170, -1));

        pFdConfirmNewPass.setBackground(new java.awt.Color(250, 250, 250));
        pFdConfirmNewPass.setFont(new java.awt.Font("Nirmala UI Semilight", 0, 14)); // NOI18N
        pFdConfirmNewPass.setForeground(new java.awt.Color(51, 51, 51));
        pFdConfirmNewPass.setBorder(null);
        add(pFdConfirmNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 310, 30));

        lb1stTxt.setFont(new java.awt.Font("Malgun Gothic", 1, 18)); // NOI18N
        lb1stTxt.setForeground(new java.awt.Color(0, 0, 0));
        lb1stTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb1stTxt.setText("Enter the data to be updated");
        lb1stTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb1stTxt.setIconTextGap(7);
        add(lb1stTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 150, 260, -1));

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
        add(lbUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 200, 40));

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
        add(lbCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 430, 200, 40));

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

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/backgrounds/editPassword.png"))); // NOI18N
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, -1, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void lbProductsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbProductsMouseClicked
        MainFrame.products = new Products();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.products);
    }//GEN-LAST:event_lbProductsMouseClicked

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

    private void lbUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUpdateMouseClicked

        String msg = "";

        try {
            if (pFdCurrentPass.getPassword().length != 0
                    && pFdNewPass.getPassword().length != 0
                    && pFdConfirmNewPass.getPassword().length != 0) {

                msg =
                    """
                    Are you sure you want to update your password?
                    This change cannot be undone later.
                    """;

                int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

                if (option == 0) {
                    char[] currentPass = pFdCurrentPass.getPassword();
                    char[] newPass = pFdNewPass.getPassword();
                    char[] confirmNewPass = pFdConfirmNewPass.getPassword();

                    // if (Arrays.equals(currentPass, userLogged.getPassword())) { Verifica a senha digitada com a cadastrada
                    if (Arrays.equals(newPass, confirmNewPass)) {

                        // if (updateUserPassword(newPass) == true) { Atualizar Senha
                        msg =
                            """
                            Password updated successfully.
                            From now on we will use your new password.
                            For security reasons we will log out all devices with your old password.
                            See you later.
                            """;

                        Alerts.showSuccessMessage(msg, "Registration Updated Successfully!", null);
                        // logOut();
                        // }

                    } else {
                        throw new CustomException("Your new password must be the same in both fields!");
                    }

                    /*} else {
                        throw new CustomException("Old password is incorrect!\nPlease review your details and try again.");
                    }*/
                }
            } else {
                msg =
                    """
                    You must fill in all fields to enter.
                    Please try again.
                    """;

                Alerts.showAlertMessage(msg, "Fields Not Filled In", null);
            }
        } catch (CustomException e) {
            Alerts.showErrorMessage(msg, "There was a Problem", null);
        }
    }//GEN-LAST:event_lbUpdateMouseClicked

    private void lbCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCancelMouseClicked
        clearForm();
        String msg =
                """
                The action to update your password has been canceled!
                """;
        Alerts.showErrorMessage(msg, "Operation canceled successfully!", null);
    }//GEN-LAST:event_lbCancelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb1stTxt;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbCancel;
    private javax.swing.JLabel lbConfirmNewPass;
    private javax.swing.JLabel lbCurrentPass;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbIconCart;
    private javax.swing.JLabel lbIconCurrentPass;
    private javax.swing.JLabel lbIconLogo;
    private javax.swing.JLabel lbIconNewPass;
    private javax.swing.JLabel lbIconProfile;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbNewPass;
    private javax.swing.JLabel lbProducts;
    private javax.swing.JLabel lbUpdate;
    private javax.swing.JPasswordField pFdConfirmNewPass;
    private javax.swing.JPasswordField pFdCurrentPass;
    private javax.swing.JPasswordField pFdNewPass;
    // End of variables declaration//GEN-END:variables
}
