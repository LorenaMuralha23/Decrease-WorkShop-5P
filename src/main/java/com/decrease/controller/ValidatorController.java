package com.decrease.controller;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

/**
 * Controlador responsável por validar dados.
 */
@Component
public class ValidatorController {

    // Expressão regular para validar o formato de um endereço de email
    private static final String EMAIL_REGEX = "^(?!.*\\.\\.)[A-Za-z0-9_]+(?:\\.[A-Za-z0-9_]+)*@[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)*$";

    /**
     * Verifica se um endereço de email é válido.
     * @param email O endereço de email a ser validado.
     * @return true se o email for válido, false caso contrário.
     */
    public boolean isValidEmail(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

}
