package com.decrease.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entidade que representa um produto.
 */
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    private Double price;

    private String imgUrl;

    @ManyToMany
    @JoinTable(name = "tb_product_category", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "id.product")
    private Set<OrderItem> items = new HashSet<>();

    /**
     * Construtor padrão.
     */
    public Product() {

    }

    /**
     * Construtor que inicializa um produto com os dados fornecidos.
     * @param id O ID do produto.
     * @param name O nome do produto.
     * @param description A descrição do produto.
     * @param price O preço do produto.
     * @param imgUrl A URL da imagem do produto.
     */
    public Product(Integer id, String name, String description, Double price, String imgUrl) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    /**
     * Obtém o ID do produto.
     * @return O ID do produto.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o ID do produto.
     * @param id O ID do produto.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obtém o nome do produto.
     * @return O nome do produto.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do produto.
     * @param name O nome do produto.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém a descrição do produto.
     * @return A descrição do produto.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define a descrição do produto.
     * @param description A descrição do produto.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Obtém a URL da imagem do produto.
     * @return A URL da imagem do produto.
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * Define a URL da imagem do produto.
     * @param imgUrl A URL da imagem do produto.
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
     * Obtém as categorias associadas ao produto.
     * @return Um conjunto de categorias associadas ao produto.
     */
    public Set<Category> getCategories() {
        return categories;
    }

    /**
     * Obtém os pedidos associados ao produto.
     * @return Um conjunto de pedidos associados ao produto.
     */
    public Set<Order> getOrders() {
        Set<Order> set = new HashSet<>();
        for (OrderItem x : items) {
            set.add(x.getOrder());
        }
        return set;
    }

    /**
     * Gera o código hash para o produto.
     * @return O código hash gerado.
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        hash = 97 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
     * Verifica se o produto é igual a outro objeto.
     * @param obj O objeto a ser comparado.
     * @return true se o produto for igual ao objeto fornecido, false caso contrário.
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
        final Product other = (Product) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    

}
