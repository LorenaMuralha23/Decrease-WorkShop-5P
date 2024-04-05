package com.decrease.entities;

import com.decrease.entities.pk.OrderItemPK;
import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Entidade que representa um item de um pedido de compra.
 */
@Entity
@Table(name = "tb_order_item")
public class OrderItem {
	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Integer quantity;
	private Double price;
	
        /**
	 * Construtor padrão.
	 */
	public OrderItem() {
		
	}

        /**
	 * Construtor que inicializa um item de pedido com os dados fornecidos.
	 * @param order O pedido ao qual o item pertence.
	 * @param product O produto associado ao item.
	 * @param quantity A quantidade do produto.
	 * @param price O preço do produto.
	 */
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
        /**
	 * Obtém o pedido ao qual o item pertence.
	 * @return O pedido ao qual o item pertence.
	 */
	public Order getOrder() {
		return id.getOrder();
	}
	
        /**
	 * Define o pedido ao qual o item pertence.
	 * @param order O pedido ao qual o item pertence.
	 */
	public void setOrder(Order order) {
		id.setOrder(order);
	}
	
        /**
	 * Obtém o produto associado ao item.
	 * @return O produto associado ao item.
	 */
	public Product getProduct() {
		return id.getProduct();
	}
	
        /**
	 * Define o produto associado ao item.
	 * @param product O produto associado ao item.
	 */
	public void setProduct(Product product) {
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
	 * Calcula o subtotal do item.
	 * @return O subtotal do item.
	 */
	public Double getSubTotal() {
		return price * quantity;
	}

        /**
	 * Gera o código hash para o item de pedido.
	 * @return O código hash gerado.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

        /**
	 * Verifica se o item de pedido é igual a outro objeto.
	 * @param obj O objeto a ser comparado.
	 * @return true se o item de pedido for igual ao objeto fornecido, false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof OrderItem))
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}
	
}