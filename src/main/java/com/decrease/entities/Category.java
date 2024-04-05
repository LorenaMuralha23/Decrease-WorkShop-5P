package com.decrease.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Entidade que representa uma categoria de produto.
 */
@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Product> products = new HashSet<>();

    /**
     * Construtor padrão.
     */
    public Category() {

    }

    /**
     * Construtor que inicializa uma categoria com o ID e nome fornecidos.
     * @param id O ID da categoria.
     * @param name O nome da categoria.
     */
    public Category(Integer id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    /**
     * Obtém o ID da categoria.
     * @return O ID da categoria.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o ID da categoria.
     * @param id O ID a ser definido.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome da categoria.
     * @return O nome da categoria.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da categoria.
     * @param name O nome a ser definido.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gera o código hash para a categoria.
     * @return O código hash gerado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Verifica se a categoria é igual a outro objeto.
     * @param obj O objeto a ser comparado.
     * @return true se a categoria for igual ao objeto fornecido, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Category)) {
            return false;
        }
        Category other = (Category) obj;
        return Objects.equals(id, other.id);
    }

}
