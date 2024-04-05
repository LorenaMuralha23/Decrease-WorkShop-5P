package com.decrease.model;

/**
 * Exceção personalizada que pode ser lançada para indicar erros específicos do aplicativo.
 */
public class CustomException extends Exception {

    /**
     * Cria uma nova exceção com a mensagem fornecida.
     * @param message A mensagem de erro associada à exceção.
     */
    public CustomException(String message) {
        super(message);
    }
    
}
