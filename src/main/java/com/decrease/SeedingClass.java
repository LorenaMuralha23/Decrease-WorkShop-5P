package com.decrease;

import com.decrease.entities.Address;
import com.decrease.entities.Product;
import com.decrease.entities.User;
import com.decrease.repositories.AddressRepository;
import com.decrease.repositories.ProductRepository;
import com.decrease.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class SeedingClass implements ApplicationRunner {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        seedDatabase();
    }

    private void seedDatabase() {
        // Criar um usuário
        User user = new User(null, "User Middlename Lastname", "user@gmail.com", "99 9999999", "12345");

        // Salvar o usuário
        userRepository.save(user);

        // Criar um endereço
        Address address = new Address(user, "First Avenue", "Camelot", "53A");

        // Associar o endereço ao usuário
        user.setAddress(address);

        // Salvar o endereço
        addressRepository.save(address);

        // Atualizar o usuário para refletir a associação com o endereço
        userRepository.save(user);

        // Agora você pode salvar outros dados como produtos, se necessário
        
        String tempName, tempDescription, tempIcon;
        
        tempName = "Whey Protein";
        tempDescription = "Premium protein supplement for muscle recovery and growth.";
        tempIcon = "/com/decrease/view/images/products/wheyProtein.png";
        Product wheyProtein = new Product(1, tempName, tempDescription, 100.0, tempIcon);
        
        tempName = "Creatine";
        tempDescription = "Performance-enhancing compound for strength and power.";
        tempIcon = "/com/decrease/view/images/products/creatine.png";
        Product creatine = new Product(2, tempName, tempDescription, 98.97, tempIcon);
        
        tempName = "Peanut Butter";
        tempDescription = "Nutritious spread rich in protein and healthy fats.";
        tempIcon = "/com/decrease/view/images/products/peanutButter.png";
        Product peanutButter = new Product(3, tempName, tempDescription, 24.99, tempIcon);
        
        tempName = "Hypercaloric";
        tempDescription = "High-calorie formula for mass gain and energy.";
        tempIcon = "/com/decrease/view/images/products/hypercaloric.png";
        Product hypercaloric = new Product(4, tempName, tempDescription, 127.39, tempIcon);

        productRepository.save(wheyProtein);
        productRepository.save(creatine);
        productRepository.save(peanutButter);
        productRepository.save(hypercaloric);
    }

}
