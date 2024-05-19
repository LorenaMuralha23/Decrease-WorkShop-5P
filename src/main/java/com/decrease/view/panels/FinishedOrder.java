package com.decrease.view.panels;

import com.decrease.EcommerceT1LpApplication;
import com.decrease.model.Alerts;
import com.decrease.view.MainFrame;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class FinishedOrder extends javax.swing.JPanel {

    public FinishedOrder() {
        initComponents();
        centerTxt(tp1stTxt);
    }

    public void centerTxt(JTextPane tp) {
        StyledDocument doc = tp.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbIconPaid = new javax.swing.JLabel();
        lbSuccess = new javax.swing.JLabel();
        lbDownInvoice = new javax.swing.JLabel();
        lbBackToHome = new javax.swing.JLabel();
        tp1stTxt = new javax.swing.JTextPane();
        tp2ndTxt = new javax.swing.JTextPane();
        lbBackground = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbIconPaid.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/paid.png"))); // NOI18N
        add(lbIconPaid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 100, 100));

        lbSuccess.setFont(new java.awt.Font("Nirmala UI", 0, 18)); // NOI18N
        lbSuccess.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSuccess.setText("Success");
        lbSuccess.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSuccess.setIconTextGap(7);
        add(lbSuccess, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 80, -1));

        lbDownInvoice.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbDownInvoice.setForeground(new java.awt.Color(0, 0, 0));
        lbDownInvoice.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDownInvoice.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/openDocument.png"))); // NOI18N
        lbDownInvoice.setText("DOWNLOAD INVOICE");
        lbDownInvoice.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbDownInvoice.setIconTextGap(7);
        lbDownInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDownInvoiceMouseClicked(evt);
            }
        });
        add(lbDownInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 170, -1));

        lbBackToHome.setFont(new java.awt.Font("Malgun Gothic", 0, 12)); // NOI18N
        lbBackToHome.setForeground(new java.awt.Color(172, 74, 213));
        lbBackToHome.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbBackToHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/leftArrow.png"))); // NOI18N
        lbBackToHome.setText("BACK TO HOME");
        lbBackToHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbBackToHome.setIconTextGap(7);
        lbBackToHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbBackToHomeMouseClicked(evt);
            }
        });
        add(lbBackToHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 520, 140, -1));

        tp1stTxt.setEditable(false);
        tp1stTxt.setBackground(new java.awt.Color(250, 250, 250));
        tp1stTxt.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        tp1stTxt.setText("Congratulations. \nYour order is accepted.");
        tp1stTxt.setFocusable(false);
        tp1stTxt.setOpaque(false);
        add(tp1stTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 370, 80));

        tp2ndTxt.setEditable(false);
        tp2ndTxt.setBackground(new java.awt.Color(250, 250, 250));
        tp2ndTxt.setBorder(null);
        tp2ndTxt.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        tp2ndTxt.setText("We at Decrease thank you for your preference!\nYour order is now being prepared to be shipped to you.\nTo the next!");
        tp2ndTxt.setFocusable(false);
        tp2ndTxt.setOpaque(false);
        add(tp2ndTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 360, 110));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/backgrounds/finishedOrder.png"))); // NOI18N
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void lbBackToHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbBackToHomeMouseClicked
        MainFrame.home = new Home();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
        EcommerceT1LpApplication.mainFrame.setTextHome();
    }//GEN-LAST:event_lbBackToHomeMouseClicked

    private void lbDownInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDownInvoiceMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Invoice");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int userSelection = fileChooser.showSaveDialog(EcommerceT1LpApplication.mainFrame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedDirectory = fileChooser.getSelectedFile();
            String directoryChoosed = selectedDirectory.getAbsolutePath();
            EcommerceT1LpApplication.mainFrame.invoiceController.generateInvoice(directoryChoosed);
            
            String msg
                = """
                Your download was completed successfully!
                """;

            Alerts.showSuccessMessage(msg, "Success!", null);
            
            MainFrame.home = new Home();
            EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
            EcommerceT1LpApplication.mainFrame.setTextHome();
        }
  
    }//GEN-LAST:event_lbDownInvoiceMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbBackToHome;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbDownInvoice;
    private javax.swing.JLabel lbIconPaid;
    private javax.swing.JLabel lbSuccess;
    private javax.swing.JTextPane tp1stTxt;
    private javax.swing.JTextPane tp2ndTxt;
    // End of variables declaration//GEN-END:variables
}