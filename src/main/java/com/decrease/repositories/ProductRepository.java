package com.decrease.repositories;

import com.decrease.entities.Product;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que define um repositório para operações de acesso a dados relacionados a produtos.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Busca um produto pelo nome.
     * 
     * @param name O nome do produto a ser buscado.
     * @return Um objeto Optional contendo o produto encontrado, se existir, ou vazio caso contrário.
     */
    Optional<Product> findByName(String name);
    
}