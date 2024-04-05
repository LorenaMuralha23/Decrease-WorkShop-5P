package com.decrease.repositories;

import com.decrease.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que define um repositório para operações de acesso a dados relacionados a usuários.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
    /**
     * Busca um usuário pelo email.
     * 
     * @param email O email do usuário a ser buscado.
     * @return Um objeto Optional contendo o usuário encontrado, se existir, ou vazio caso contrário.
     */
    Optional<User> findByEmail(String email);
    
    /**
     * Verifica se existe um usuário com o nome especificado.
     * 
     * @param username O nome do usuário a ser verificado.
     * @return true se um usuário com o nome especificado existir, false caso contrário.
     */
    boolean existsByName(String username);
    
    /**
     * Verifica se existe um usuário com o email especificado.
     * 
     * @param email O email do usuário a ser verificado.
     * @return true se um usuário com o email especificado existir, false caso contrário.
     */
    boolean existsByEmail(String email);
    
    /**
     * Verifica se existe um usuário com a senha especificada.
     * 
     * @param password A senha do usuário a ser verificada.
     * @return true se um usuário com a senha especificada existir, false caso contrário.
     */
    boolean existsByPassword(String password);
    
}