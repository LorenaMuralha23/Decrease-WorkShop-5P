package com.decrease.entities;

import com.decrease.entities.enums.OrderStatus;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Entidade que representa um pedido de compra.
 */
@Entity
@Table(name = "tb_order")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;
	
	private Integer orderStatus;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
        /**
	 * Construtor padrão.
	 */
	public Order() {
		
	}
	
        /**
	 * Construtor que inicializa um pedido com o ID, momento, status do pedido e cliente fornecidos.
	 * @param id O ID do pedido.
	 * @param moment O momento do pedido.
	 * @param orderStatus O status do pedido.
	 * @param client O cliente associado ao pedido.
	 */
	public Order(Long id, Instant moment, OrderStatus orderStatus,User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

        /**
	 * Obtém o ID do pedido.
	 * @return O ID do pedido.
	 */
	public Long getId() {
		return id;
	}

        /**
	 * Define o ID do pedido.
	 * @param id O ID do pedido.
	 */
	public void setId(Long id) {
		this.id = id;
	}

        /**
	 * Obtém o momento do pedido.
	 * @return O momento do pedido.
	 */
	public Instant getMoment() {
		return moment;
	}

        /**
	 * Define o momento do pedido.
	 * @param moment O momento do pedido.
	 */
	public void setMoment(Instant moment) {
		this.moment = moment;
	}

        /**
	 * Obtém o status do pedido.
	 * @return O status do pedido.
	 */
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

        /**
	 * Define o status do pedido.
	 * @param orderStatus O status do pedido.
	 */
	public void setOrderStatus(OrderStatus orderStatus) {
		if(orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
		
	}

        /**
	 * Obtém o cliente associado ao pedido.
	 * @return O cliente associado ao pedido.
	 */
	public User getClient() {
		return client;
	}

        /**
	 * Define o cliente associado ao pedido.
	 * @param client O cliente associado ao pedido.
	 */
	public void setClient(User client) {
		this.client = client;
	}
	
        /**
	 * Obtém os itens do pedido.
	 * @return Um conjunto de itens do pedido.
	 */
	public Set<OrderItem> getOrderItems() {
		return items;
	}
	
        /**
	 * Obtém o pagamento associado ao pedido.
	 * @return O pagamento associado ao pedido.
	 */
	public Payment getPayment() {
		return payment;
	}

        /**
	 * Define o pagamento associado ao pedido.
	 * @param payment O pagamento associado ao pedido.
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
        /**
	 * Calcula o total do pedido.
	 * @return O total do pedido.
	 */
	public Double getTotal() {
		double sum = 0.0;
		for(OrderItem item : items) {
			sum += item.getSubTotal();
		}
		return sum;
	}

        /**
	 * Gera o código hash para o pedido.
	 * @return O código hash gerado.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

        /**
	 * Verifica se o pedido é igual a outro objeto.
	 * @param obj O objeto a ser comparado.
	 * @return true se o pedido for igual ao objeto fornecido, false caso contrário.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}