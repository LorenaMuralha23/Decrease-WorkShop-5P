package com.decrease.internacionalization.manager;

import java.io.File;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageManager {

    private ResourceBundleMessageSource msgSource;
    private String language, country;
    private Locale userLocale;

    public MessageManager() {
        // Define o locale padrão para pt-BR
        Locale.setDefault(new Locale("pt", "BR"));
        this.language = "pt";
        this.country = "BR";
        configureLanguage();
        configureMessageSource();
    }

    // Versão CLI
    public MessageManager(String language, String country) {
        this.language = language;
        this.country = country;
        configureLanguage();
        configureMessageSource();
    }

    public void configureLanguage() {
        if (this.language.equals("") || this.country.equals("")) {
            this.language = System.getProperty("user.language");
            this.country = System.getProperty("user.country");
        }

//        this.language = "ar";
//        this.country = "MA";
        this.userLocale = new Locale(this.language, this.country);
    }

    private void configureMessageSource() {
        msgSource = new ResourceBundleMessageSource();
        msgSource.setBasename("messages"); // Nome base dos arquivos de propriedades
        msgSource.setDefaultEncoding("UTF-8");
        msgSource.setFallbackToSystemLocale(true); // Fallback para o locale do sistema
    }

    public String getMessage(String key) {
        return msgSource.getMessage(key, null, userLocale);
    }

}
