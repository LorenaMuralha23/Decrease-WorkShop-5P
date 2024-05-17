package com.decrease.view;

import com.decrease.controller.CartController;
import com.decrease.controller.InvoiceController;
import com.decrease.controller.OrderController;
import com.decrease.controller.PaymentController;
import com.decrease.controller.ProductController;
import com.decrease.controller.UserController;
import com.decrease.view.panels.AboutMe;
import com.decrease.view.panels.Cart;
import com.decrease.view.panels.Checkout;
import com.decrease.view.panels.EditPassword;
import com.decrease.view.panels.EditProfile;
import com.decrease.view.panels.FinishedOrderTest;
import com.decrease.view.panels.Home;
import com.decrease.view.panels.Products;
import com.decrease.view.panels.Profile;
import com.decrease.view.panels.SignIn;
import com.decrease.view.panels.SignUp;
import jakarta.annotation.PostConstruct;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A classe MainFrame representa o frame principal da aplicação.
 */
@Component
public class MainFrame extends javax.swing.JFrame {

    @Autowired
    public UserController userController;

    @Autowired
    public CartController cartController;

    @Autowired
    public ProductController productController;

    @Autowired
    public PaymentController paymentController;

    @Autowired
    public OrderController orderController;

    @Autowired
    public InvoiceController invoiceController;

    public static AboutMe aboutMe;
    public static Cart cart;
    public static Checkout checkout;
    public static EditPassword editPass;
    public static EditProfile editProfile;
    public static Home home;
    public static Products products;
    public static Profile profile;
    public static SignIn signIn;
    public static SignUp signUp;
    public static FinishedOrderTest finishedOrder;

    /**
     * Construtor padrão da classe MainFrame.
     */
    public MainFrame() {
        initComponents();
    }

    /**
     * Método executado após a construção do frame. Inicializa o frame com o
     * painel de home.
     */
    @PostConstruct
    public void starting() {
        this.setLayout(new BorderLayout());

        home = new Home();
        this.setLocationRelativeTo(null);

    }

    /**
     * Inicializa um novo painel no frame.
     *
     * @param newJPanel O novo painel a ser exibido
     */
    public void initNewPanel(JPanel newJPanel) {
        this.getContentPane().removeAll();
        this.add(newJPanel, BorderLayout.CENTER);
        this.pack();
    }

    public void setTextHome() {
        home.setText();
        initNewPanel(home);
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
