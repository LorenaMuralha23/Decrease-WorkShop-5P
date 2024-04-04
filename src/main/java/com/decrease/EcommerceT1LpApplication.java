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
    public static SessionFactory sessionFactory;

    public static void main(String[] args) {
         ConfigurableApplicationContext context = new SpringApplicationBuilder(EcommerceT1LpApplication.class)
                .headless(false) // Permite que o Spring gerencie componentes gráficos
                .run(args);

        // Inicia as interfaces desktop
        mainFrame = context.getBean(MainFrame.class);
        mainFrame.starting();

    }
    
    public static void startHibernate(){
        // Configurar e construir o registro de serviço Hibernate
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // Carregar configurações do hibernate.cfg.xml padrão
                .build();

        try {
            // Criar uma fábrica de sessões com base nas metadados definidas nas anotações do JPA
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            // Ocorreu um erro ao inicializar o Hibernate, lidar com isso adequadamente
            StandardServiceRegistryBuilder.destroy(registry);
            ex.printStackTrace();
        }
    }
    
}
