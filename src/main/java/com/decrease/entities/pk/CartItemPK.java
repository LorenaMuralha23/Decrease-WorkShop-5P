package com.decrease.entities.pk;

import com.decrease.entities.Cart;
import com.decrease.entities.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa a chave primária composta para um item de carrinho.
 */
@Embeddable
public class CartItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_cart")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    /**
     * Obtém o carrinho associado ao item.
     * @return O carrinho associado ao item.
     */
    public Cart getCart() {
        return cart;
    }

    /**
     * Define o carrinho associado ao item.
     * @param cart O carrinho associado ao item.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * Obtém o produto associado ao item.
     * @return O produto associado ao item.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Define o produto associado ao item.
     * @param product O produto associado ao item.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gera o código hash para a chave primária composta.
     * @return O código hash gerado.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.cart);
        hash = 29 * hash + Objects.hashCode(this.product);
        return hash;
    }

    /**
     * Verifica se a chave primária composta é igual a outro objeto.
     * @param obj O objeto a ser comparado.
     * @return true se a chave primária composta for igual ao objeto fornecido, false caso contrário.
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
        final CartItemPK other = (CartItemPK) obj;
        if (!Objects.equals(this.cart, other.cart)) {
            return false;
        }
        return Objects.equals(this.product, other.product);
    }
    
}
