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

    public Cart() {
    }

    public Cart(User client) {
        this.client = client;
    }
    
    public void setId(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Set<CartItem> getItems() {
        return items;
    }

    public Double getSubtotal() {
        Double subtotal = 0.0;
        if (getItems() != null) {
            for (CartItem i : this.items) {
                subtotal += i.getPrice() * i.getQuantity();
            }
        }
        return subtotal;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Cart other = (Cart) obj;
        return Objects.equals(this.id, other.id);
    }

}
