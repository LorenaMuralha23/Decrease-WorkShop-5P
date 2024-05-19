package com.decrease.controller;

import com.decrease.entities.Product;
import com.decrease.services.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Controlador responsável por gerenciar os produtos.
 */
@Component
public class ProductController {

    @Autowired
    private ProductService service;

    /**
     * Construtor padrão do controlador de produtos.
     */
    public ProductController() {
    }

    /**
     * Insere um novo produto.
     *
     * @param newProduct O novo produto a ser inserido.
     */
    public void insert(Product newProduct) {
        service.insert(newProduct);
    }

    /**
     * Busca um produto pelo seu ID.
     *
     * @param id O ID do produto a ser buscado.
     * @return O produto encontrado, ou null se não for encontrado.
     */
    public Product findById(Long id) {
        Product findedProduct = service.findById(id);

        return findedProduct;
    }

    /**
     * Cria uma instância de produto com os parâmetros fornecidos.
     *
     * @param name O nome do produto.
     * @param description A descrição do produto.
     * @param price O preço do produto.
     * @param imgUrl A URL da imagem do produto.
     * @return A instância de produto criada.
     */
    public Product createInstance(String name, String description, Double price, String imgUrl) {
        return service.createInstance(name, description, price, imgUrl);
    }

    /**
     * Obtém um produto pelo seu nome.
     *
     * @param productName O nome do produto a ser buscado.
     * @return O produto encontrado, ou null se não for encontrado.
     */
    public Product getProductByName(String productName) {
        return service.getProductByName(productName);
    }

    public List<Product> getAllProducts() {
        return service.getAllProducts();
    }
}
