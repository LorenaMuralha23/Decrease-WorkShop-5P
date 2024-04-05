package com.decrease.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Entidade que representa o carrinho de compras de um cliente.
 */
@Entity
@Table(name = "tb_cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_client")
    private User client;

    @OneToMany(mappedBy = "id.cart")
    private Set<CartItem> items = new HashSet<CartItem>();

    /**
     * Construtor padrão.
     */
    public Cart() {
    }

    /**
     * Construtor que inicializa um carrinho com o cliente fornecido.
     * @param client O cliente associado ao carrinho.
     */
    public Cart(User client) {
        this.client = client;
    }
    
    /**
    * Define o ID do objeto.
    * @param id O ID a ser definido.
    */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * Obtém o ID do carrinho.
     * @return O ID do carrinho.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Obtém o cliente associado ao carrinho.
     * @return O cliente associado ao carrinho.
     */
    public User getClient() {
        return client;
    }

    /**
     * Define o cliente associado ao carrinho.
     * @param client O cliente a ser associado ao carrinho.
     */
    public void setClient(User client) {
        this.client = client;
    }

    /**
     * Obtém os itens do carrinho.
     * @return Um conjunto de itens do carrinho.
     */
    public Set<CartItem> getItems() {
        return items;
    }

    /**
     * Calcula o subtotal do carrinho.
     * @return O subtotal do carrinho.
     */
    public Double getSubtotal() {
        Double subtotal = 0.0;
        if (getItems() != null) {
            for (CartItem i : this.items) {
                subtotal += i.getPrice() * i.getQuantity();
            }
        }
        return subtotal;
    }

    /**
     * Gera o código hash para o carrinho.
     * @return O código hash gerado.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Verifica se o carrinho é igual a outro objeto.
     * @param obj O objeto a ser comparado.
     * @return true se o carrinho for igual ao objeto fornecido, false caso contrário.
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
        final Cart other = (Cart) obj;
        return Objects.equals(this.id, other.id);
    }

}
