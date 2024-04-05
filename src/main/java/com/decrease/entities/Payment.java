package com.decrease.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Entidade que representa um pagamento de um pedido.
 */
@Entity
@Table(name = "tb_payment")
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Instant moment;

    @OneToOne
    @MapsId
    private Order order;
    
    private Integer type;

    /**
     * Construtor padrão.
     */
    public Payment() {

    }

    /**
     * Construtor que inicializa um pagamento com os dados fornecidos.
     * @param id O ID do pagamento.
     * @param moment O momento do pagamento.
     * @param order O pedido associado ao pagamento.
     * @param type O tipo de pagamento.
     */
    public Payment(Integer id, Instant moment, Order order, Integer type) {
        super();
        this.id = id;
        this.moment = moment;
        this.order = order;
        this.type = type;
    }

    /**
     * Obtém o ID do pagamento.
     * @return O ID do pagamento.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o ID do pagamento.
     * @param id O ID do pagamento.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o momento do pagamento.
     * @return O momento do pagamento.
     */
    public Instant getMoment() {
        return moment;
    }

    /**
     * Define o momento do pagamento.
     * @param moment O momento do pagamento.
     */
    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    /**
     * Obtém o pedido associado ao pagamento.
     * @return O pedido associado ao pagamento.
     */
    public Order getOrder() {
        return order;
    }

    /**
     * Define o pedido associado ao pagamento.
     * @param order O pedido associado ao pagamento.
     */
    public void setOrder(Order order) {
        this.order = order;
    }

    /**
     * Obtém o tipo de pagamento.
     * @return O tipo de pagamento.
     */
    public Integer getType() {
        return type;
    }

    /**
     * Define o tipo de pagamento.
     * @param type O tipo de pagamento.
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * Gera o código hash para o pagamento.
     * @return O código hash gerado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Verifica se o pagamento é igual a outro objeto.
     * @param obj O objeto a ser comparado.
     * @return true se o pagamento for igual ao objeto fornecido, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) obj;
        return Objects.equals(id, other.id);
    }

}
