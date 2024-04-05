package com.decrease.controller;

import com.decrease.entities.Address;
import com.decrease.entities.CartItem;
import com.decrease.entities.User;
import com.decrease.model.CustomException;
import com.decrease.services.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Controlador responsável por gerenciar os usuários.
 */
@Component
public class UserController {
    
    private final UserService service;
    
    /**
     * Construtor do controlador de usuários.
     * @param service O serviço de usuário a ser injetado.
     */
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    
    /**
     * Cria um novo usuário.
     * @param newUser O novo usuário a ser criado.
     * @throws CustomException Se ocorrer um erro durante a criação do usuário.
     */
    public void createNewUser(User newUser) throws CustomException{
        service.insert(newUser);
    }
    
    /**
     * Realiza o login de um usuário.
     * @param email O email do usuário.
     * @param password A senha do usuário.
     * @param session O controlador de sessão associado à operação.
     * @return true se o login for bem-sucedido, false caso contrário.
     * @throws CustomException Se ocorrer um erro durante o login.
     */
    public boolean login(String email, String password, SessionController session) throws CustomException{
        return service.logIn(email, password, session);
    }
    
    /**
     * Obtém o usuário logado.
     * @param session O controlador de sessão associado à operação.
     * @return O usuário logado, ou null se nenhum usuário estiver logado.
     */
    public User getUserLogged(SessionController session){
        return service.getUserLogged(session);
    }
    
    /**
     * Obtém os itens do carrinho do usuário logado.
     * @param session O controlador de sessão associado à operação.
     * @return Um conjunto de itens do carrinho do usuário logado.
     */
    public Set<CartItem> getUserCartItems(SessionController session){
        return service.getUserCart(session);
    }
    
    /**
     * Obtém o endereço do usuário logado.
     * @param session O controlador de sessão associado à operação.
     * @return O endereço do usuário logado.
     */
    public Address getAddress(SessionController session){
        return service.getAddress(session);
    }
}
