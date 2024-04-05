package com.decrease.entities;

import jakarta.persistence.CascadeType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Entidade que representa um usuário.
 */
@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @OneToOne(mappedBy = "user")
    private Address address;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    private Cart cart;

    /**
     * Construtor padrão.
     */
    public User() {

    }

    /**
     * Construtor que inicializa um usuário com os dados fornecidos.
     * @param id O ID do usuário.
     * @param name O nome do usuário.
     * @param email O email do usuário.
     * @param phone O telefone do usuário.
     * @param password A senha do usuário.
     */
    public User(Long id, String name, String email, String phone, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    /**
     * Obtém o ID do usuário.
     * @return O ID do usuário.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do usuário.
     * @param id O ID do usuário.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do usuário.
     * @return O nome do usuário.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do usuário.
     * @param name O nome do usuário.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o email do usuário.
     * @return O email do usuário.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o email do usuário.
     * @param email O email do usuário.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtém o telefone do usuário.
     * @return O telefone do usuário.
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Define o telefone do usuário.
     * @param phone O telefone do usuário.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Obtém a senha do usuário.
     * @return A senha do usuário.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a senha do usuário.
     * @param password A senha do usuário.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Obtém a lista de pedidos associados ao usuário.
     * @return A lista de pedidos associados ao usuário.
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * Define o carrinho de compras do usuário.
     * @param cart O carrinho de compras do usuário.
     */
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * Obtém o carrinho de compras do usuário.
     * @return O carrinho de compras do usuário.
     */
    public Cart getCart() {
        return this.cart;
    }

    /**
     * Obtém o endereço associado ao usuário.
     * @return O endereço associado ao usuário.
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Define o endereço associado ao usuário.
     * @param address O endereço associado ao usuário.
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gera o código hash para o usuário.
     * @return O código hash gerado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Verifica se o usuário é igual a outro objeto.
     * @param obj O objeto a ser comparado.
     * @return true se o usuário for igual ao objeto fornecido, false caso contrário.
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
        User other = (User) obj;
        return Objects.equals(id, other.id);
    }

}
