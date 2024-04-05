package com.decrease.repositories;

import com.decrease.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que define um repositório para operações de acesso a dados relacionados a categorias.
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}