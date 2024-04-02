package com.decrease.controller;

import com.decrease.entities.Address;
import com.decrease.entities.CartItem;
import com.decrease.entities.User;
import com.decrease.model.CustomException;
import com.decrease.services.UserService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserController {
    
    private final UserService service;
    
    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }
    
    public void createNewUser(User newUser) throws CustomException{
        service.insert(newUser);
    }
    
    public boolean login(String email, String password, SessionController session) throws CustomException{
        return service.logIn(email, password, session);
    }
    
    public User getUserLogged(SessionController session){
        return service.getUserLogged(session);
    }
    
    public Set<CartItem> getUserCartItems(SessionController session){
        return service.getUserCart(session);
    }
    
    public Address getAddress(SessionController session){
        return service.getAddress(session);
    }
}
