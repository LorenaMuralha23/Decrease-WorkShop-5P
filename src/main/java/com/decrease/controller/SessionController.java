package com.decrease.controller;

import com.decrease.entities.User;
import org.springframework.stereotype.Component;

/**
 * Controlador responsável por gerenciar a sessão do usuário.
 */
@Component
public class SessionController {

    private static SessionController instance;
    private User userLoggedIn;

    /**
     * Construtor privado para garantir que apenas uma instância de SessionController seja criada.
     */
    private SessionController() {
    }

    /**
     * Obtém a instância única de SessionController.
     * @return A instância única de SessionController.
     */
    public static SessionController getInstance() {
        if (instance == null) {
            instance = new SessionController();
        }

        return instance;
    }

    /**
     * Realiza o login do usuário.
     * @param userToLogIn O usuário a ser logado.
     */
    public void logIn(User userToLogIn) {
        this.userLoggedIn = userToLogIn;
    }

    /**
     * Realiza o logout do usuário.
     */
    public void logOut() {
        this.userLoggedIn = null;
    }

    /**
     * Obtém o usuário logado.
     * @return O usuário logado, ou null se nenhum usuário estiver logado.
     */
    public User getUserLogged() {
        return this.userLoggedIn;
    }
    
    /**
     * Verifica se algum usuário está logado.
     * @return true se um usuário estiver logado, false caso contrário.
     */
    public boolean isLoggedIn() {
        return this.userLoggedIn != null;
    }
}

