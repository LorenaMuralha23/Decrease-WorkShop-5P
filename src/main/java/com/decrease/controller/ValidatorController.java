package com.decrease.controller;

import java.util.regex.Pattern;
import org.springframework.stereotype.Component;

@Component
public class ValidatorController {

    private static final String EMAIL_REGEX = "^(?!.*\\.\\.)[A-Za-z0-9_]+(?:\\.[A-Za-z0-9_]+)*@[A-Za-z0-9-]+(?:\\.[A-Za-z0-9-]+)*$";

    public boolean isValidEmail(String email) {
        return Pattern.compile(EMAIL_REGEX).matcher(email).matches();
    }

}
