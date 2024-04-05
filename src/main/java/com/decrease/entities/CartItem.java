package com.decrease.entities;

import com.decrease.entities.pk.CartItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

/**
 * Entidade que representa um item no carrinho de compras.
 */
@Entity
@Table(name = "tb_cart_item")
public class CartItem {
    
    @EmbeddedId
    private CartItemPK id = new CartItemPK();
    
    private Integer quantity;
    
    private Double price;

    /**
     * Construtor padrão.
     */
    public CartItem() {
    }

    /**
     * Construtor que inicializa um item no carrinho com os dados fornecidos.
     * @param cart O carrinho ao qual o item pertence.
     * @param product O produto associado ao item.
     * @param quantity A quantidade do produto.
     * @param price O preço do produto.
     */
    public CartItem(Cart cart, Product product,Integer quantity, Double price) {
        id.setCart(cart);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }
    
    /**
     * Obtém o carrinho ao qual o item pertence.
     * @return O carrinho ao qual o item pertence.
     */
    public Cart getCart(){
        return id.getCart();
    }
    
    /**
     * Define o carrinho ao qual o item pertence.
     * @param cart O carrinho ao qual o item pertence.
     */
    public void setCart(Cart cart){
        id.setCart(cart);
    }
    
    /**
     * Obtém o produto associado ao item.
     * @return O produto associado ao item.
     */
    public Product getProduct(){
        return id.getProduct();
    }
    
    /**
     * Define o produto associado ao item.
     * @param product O produto associado ao item.
     */
    public void setProduct(Product product){
        id.setProduct(product);
    }

    /**
     * Obtém a quantidade do produto.
     * @return A quantidade do produto.
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Define a quantidade do produto.
     * @param quantity A quantidade do produto.
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Obtém o preço do produto.
     * @return O preço do produto.
     */
    public Double getPrice() {
        return price;
    }

    /**
     * Define o preço do produto.
     * @param price O preço do produto.
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Gera o código hash para o item do carrinho.
     * @return O código hash gerado.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Verifica se o item do carrinho é igual a outro objeto.
     * @param obj O objeto a ser comparado.
     * @return true se o item do carrinho for igual ao objeto fornecido, false caso contrário.
     */
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
