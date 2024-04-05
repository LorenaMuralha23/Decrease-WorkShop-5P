package com.decrease;

import com.decrease.view.MainFrame;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan("com.decrease.entities")
public class EcommerceT1LpApplication {

    public static MainFrame mainFrame;
    
    /**
     * Método principal que inicia a aplicação.
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
         ConfigurableApplicationContext context = new SpringApplicationBuilder(EcommerceT1LpApplication.class)
                .headless(false) // Permite que o Spring gerencie componentes gráficos
                .run(args);

        // Inicia as interfaces desktop
        mainFrame = context.getBean(MainFrame.class);
        mainFrame.starting();

    }       
    
}
