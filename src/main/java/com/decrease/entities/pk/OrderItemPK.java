package com.decrease.entities.pk;

import com.decrease.entities.Order;
import com.decrease.entities.Product;
import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Classe que representa a chave primária composta para um item de pedido.
 */
@Embeddable
public class OrderItemPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    /**
     * Obtém o pedido associado ao item.
     * @return O pedido associado ao item.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Define o pedido associado ao item.
     * @param order O pedido associado ao item.
     */
    public void setOrder(Order order) {
        this.order = order;
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
        return Objects.hash(order, product);
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
        if (!(obj instanceof OrderItemPK)) {
            return false;
        }
        OrderItemPK other = (OrderItemPK) obj;
        return Objects.equals(order, other.order) && Objects.equals(product, other.product);
    }

}
