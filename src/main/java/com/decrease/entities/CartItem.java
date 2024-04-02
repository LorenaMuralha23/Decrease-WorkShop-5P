package com.decrease.entities;

import com.decrease.entities.pk.CartItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tb_cart_item")
public class CartItem {
    
    @EmbeddedId
    private CartItemPK id = new CartItemPK();
    
    private Integer quantity;
    
    private Double price;

    public CartItem() {
    }

    public CartItem(Cart cart, Product product,Integer quantity, Double price) {
        id.setCart(cart);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    
    public Cart getCart(){
        return id.getCart();
    }
    
    public void setCart(Cart cart){
        id.setCart(cart);
    }
    
    public Product getProduct(){
        return id.getProduct();
    }
    
    public void setProduct(Product product){
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CartItem other = (CartItem) obj;
        return Objects.equals(this.id, other.id);
    }

    
    
    
}
