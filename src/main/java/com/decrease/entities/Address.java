package com.decrease.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

/**
 * Entidade que representa um endereço de usuário.
 */
@Entity
@Table(name = "tb_address")
public class Address implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;
    
    private String street;
    private String state;
    private String number;

    /**
     * Construtor padrão.
     */
    public Address() {
    }

    /**
     * Construtor que inicializa um endereço com os dados fornecidos.
     * @param user O usuário associado ao endereço.
     * @param street A rua do endereço.
     * @param state O estado do endereço.
     * @param number O número do endereço.
     */
    public Address(User user, String street, String state, String number) {
        this.user = user;
        this.street = street;
        this.state = state;
        this.number = number;
    }

    /**
     * Obtém o ID do endereço.
     * @return O ID do endereço.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Obtém o usuário associado ao endereço.
     * @return O usuário associado ao endereço.
     */
    public User getUser() {
        return user;
    }

    /**
     * Define o usuário associado ao endereço.
     * @param user O usuário a ser associado ao endereço.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Obtém a rua do endereço.
     * @return A rua do endereço.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Define a rua do endereço.
     * @param street A rua a ser definida.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Obtém o estado do endereço.
     * @return O estado do endereço.
     */
    public String getState() {
        return state;
    }

    /**
     * Define o estado do endereço.
     * @param state O estado a ser definido.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Obtém o número do endereço.
     * @return O número do endereço.
     */
    public String getNumber() {
        return number;
    }

    /**
     * Define o número do endereço.
     * @param number O número a ser definido.
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * Gera o código hash para o endereço.
     * @return O código hash gerado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    /**
     * Verifica se o endereço é igual a outro objeto.
     * @param obj O objeto a ser comparado.
     * @return true se o endereço for igual ao objeto fornecido, false caso contrário.
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
        final Address other = (Address) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
