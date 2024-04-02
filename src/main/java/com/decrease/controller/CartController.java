package com.decrease.controller;

import com.decrease.entities.CartItem;
import com.decrease.entities.Order;
import com.decrease.entities.Product;
import com.decrease.entities.User;
import com.decrease.services.CartService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartController {

    @Autowired
    private CartService service;
    

    public CartController() {
        service = new CartService();
    }

    public void addProductToCart(Product product, Integer quantity, SessionController session) {
        service.addProductToCart(product, quantity, session);
    }

    public Optional<CartItem> getItem(Integer id) {
        return service.getCartItemById(id);
    }

    public void cleanCart(User userLogged) {
        service.cleanCart(userLogged);
    }

    public CartItem deleteItem(Product product, SessionController session) {
        return service.deleteItem(product, session);
    }

    public Double getSubtotal(SessionController session) {
        return service.getSubtotal(session);
    }

    public Order covertCartToOrder(SessionController session) {
        return service.covertCartToOrder(session);
    }

    public int calculateInstallments(double totalValue) {
        return service.calculateInstallments(totalValue);
    }
    
}
