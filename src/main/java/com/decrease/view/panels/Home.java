package com.decrease.view.panels;

import com.decrease.EcommerceT1LpApplication;
import com.decrease.controller.SessionController;
import com.decrease.model.Alerts;
import com.decrease.view.MainFrame;
import jakarta.annotation.PostConstruct;

/**
 * A classe Home representa o painel inicial da aplicação de comércio eletrônico.
 * Este painel exibe uma interface gráfica com opções de navegação e ações para o usuário.
 * Ele verifica se o usuário está logado e ajusta a exibição de elementos da interface de acordo.
 */
public class Home extends javax.swing.JPanel {

    /**
     * Construtor padrão da classe Home.
     * Inicializa os componentes do painel e verifica se o usuário está logado.
     */
    public Home() {
        initComponents();
        verifyUserLogged();
    }

    /**
     * Verifica se o usuário está logado e ajusta a visibilidade do botão de logout de acordo.
     */
    public void verifyUserLogged(){
        
        if (SessionController.getInstance().isLoggedIn()) {
            lbLogOut.setVisible(true);
        } else {
            lbLogOut.setVisible(false);
        }

    }
    
    public void setText() {
        lbLogOut.setText(EcommerceT1LpApplication.msgManager.getMessage("logout-button"));
        lb1stTxt.setText(EcommerceT1LpApplication.msgManager.getMessage("first-text"));
        lbShopNow.setText(EcommerceT1LpApplication.msgManager.getMessage("shop-now-button"));
        lbHome.setText(EcommerceT1LpApplication.msgManager.getMessage("home-button"));
        lbProducts.setText(EcommerceT1LpApplication.msgManager.getMessage("products-button"));
        tp2ndTxt.setText(EcommerceT1LpApplication.msgManager.getMessage("second-text"));
        tp3rdTxt.setText(EcommerceT1LpApplication.msgManager.getMessage("third-text"));
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbLogOut = new javax.swing.JLabel();
        lb1stTxt = new javax.swing.JLabel();
        lbShopNow = new javax.swing.JLabel();
        lbIconCart = new javax.swing.JLabel();
        lbIconProfile = new javax.swing.JLabel();
        lbHome = new javax.swing.JLabel();
        lbProducts = new javax.swing.JLabel();
        lbIconLogo = new javax.swing.JLabel();
        tp2ndTxt = new javax.swing.JTextPane();
        tp3rdTxt = new javax.swing.JTextPane();
        lbBackground = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(1280, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lb1stTxt.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        lb1stTxt.setForeground(new java.awt.Color(0, 0, 0));
        lb1stTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lb1stTxt.setText("#1 Supplement in the world");
        lb1stTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lb1stTxt.setIconTextGap(7);
        add(lb1stTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 150, 197, -1));

        lbShopNow.setBackground(new java.awt.Color(0, 0, 0));
        lbShopNow.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        lbShopNow.setForeground(new java.awt.Color(255, 255, 255));
        lbShopNow.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbShopNow.setText("SHOP NOW");
        lbShopNow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbShopNow.setIconTextGap(7);
        lbShopNow.setOpaque(true);
        lbShopNow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbShopNowMouseClicked(evt);
            }
        });
        add(lbShopNow, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 450, 197, 50));

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

        lbHome.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        lbHome.setForeground(new java.awt.Color(0, 0, 0));
        lbHome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHome.setText("Home");
        lbHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbHome.setIconTextGap(7);
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

        lbIconLogo.setFont(new java.awt.Font("Malgun Gothic", 1, 24)); // NOI18N
        lbIconLogo.setForeground(new java.awt.Color(0, 0, 0));
        lbIconLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbIconLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/icons/logoPNG.png"))); // NOI18N
        add(lbIconLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 200));

        tp2ndTxt.setEditable(false);
        tp2ndTxt.setBackground(new java.awt.Color(250, 250, 250));
        tp2ndTxt.setBorder(null);
        tp2ndTxt.setFont(new java.awt.Font("Malgun Gothic", 1, 48)); // NOI18N
        tp2ndTxt.setForeground(new java.awt.Color(0, 0, 0));
        tp2ndTxt.setText("All-in-one Supplement for Your Strength");
        tp2ndTxt.setFocusable(false);
        tp2ndTxt.setOpaque(false);
        add(tp2ndTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 400, 200));

        tp3rdTxt.setEditable(false);
        tp3rdTxt.setBackground(new java.awt.Color(250, 250, 250));
        tp3rdTxt.setBorder(null);
        tp3rdTxt.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        tp3rdTxt.setForeground(new java.awt.Color(0, 0, 0));
        tp3rdTxt.setText("Nutritional supplement filled with 33 ingredients, all working together to support your strength and health");
        tp3rdTxt.setFocusable(false);
        tp3rdTxt.setOpaque(false);
        add(tp3rdTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, 350, -1));

        lbBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/decrease/view/images/backgrounds/home.png"))); // NOI18N
        add(lbBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 600));
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Método executado quando o texto "Shop Now" é clicado.
     * Abre o painel de produtos.
     * 
     * @param evt O evento de clique do mouse associado.
     */
    private void lbShopNowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbShopNowMouseClicked
        MainFrame.products = new Products();
        EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.products);
    }//GEN-LAST:event_lbShopNowMouseClicked

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

            String msg
                    = """
                    Are you sure you want to quit?
                    Don't worry, your data will remain saved until you return.
                    """;

            int option = Alerts.showConfirmMessage(msg, "Confirmation Message", null);

            if (option == 0) {
                SessionController.getInstance().logOut();

                MainFrame.home = new Home();
                EcommerceT1LpApplication.mainFrame.initNewPanel(MainFrame.home);
                msg
                    =
                    """
                    Logout completed successfully!
                    You have been logged out of our system.
                    If you want to enjoy all the features, log in again.
                    """;

                Alerts.showSuccessMessage(msg, "Log Out Performed", null);
            }

        }
        
    }//GEN-LAST:event_lbLogOutMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb1stTxt;
    private javax.swing.JLabel lbBackground;
    private javax.swing.JLabel lbHome;
    private javax.swing.JLabel lbIconCart;
    private javax.swing.JLabel lbIconLogo;
    private javax.swing.JLabel lbIconProfile;
    private javax.swing.JLabel lbLogOut;
    private javax.swing.JLabel lbProducts;
    private javax.swing.JLabel lbShopNow;
    private javax.swing.JTextPane tp2ndTxt;
    private javax.swing.JTextPane tp3rdTxt;
    // End of variables declaration//GEN-END:variables
}
