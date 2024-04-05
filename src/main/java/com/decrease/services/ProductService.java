package com.decrease.services;

import com.decrease.entities.Product;
import com.decrease.repositories.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta classe de serviço fornece métodos relacionados às operações de produto.
 */
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    /**
     * Constrói uma nova instância de ProductService.
     */
    public ProductService() {
    }

    /**
     * Insere um novo produto no banco de dados.
     *
     * @param product O produto a ser inserido
     */
    public void insert(Product product) {
        repository.save(product);
    }

    /**
     * Busca um produto pelo seu ID.
     *
     * @param id O ID do produto a ser buscado
     * @return O produto encontrado, ou null se não encontrado
     */
    public Product findById(Long id) {
        Optional<Product> productObj = repository.findById(id);
        Product productFinded = productObj.orElse(null);
        return productFinded;
    }

    /**
     * Cria uma nova instância de produto com os dados fornecidos e a insere no banco de dados.
     *
     * @param name        O nome do produto
     * @param description A descrição do produto
     * @param price       O preço do produto
     * @param imgUrl      A URL da imagem do produto
     * @return O produto recém-criado
     */
    public Product createInstance(String name, String description, Double price, String imgUrl) {
        Product product = new Product(null, name, description, price, imgUrl);
        repository.save(product);
        return product;
    }

    /**
     * Busca um produto pelo seu nome.
     *
     * @param name O nome do produto a ser buscado
     * @return O produto encontrado, ou null se não encontrado
     */
    public Product getProductByName(String name) {
        Optional<Product> productObj = repository.findByName(name);
        Product productFinded = productObj.orElse(null);
        return productFinded;
    }
    
}