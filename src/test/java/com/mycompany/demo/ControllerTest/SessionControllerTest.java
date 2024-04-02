package com.mycompany.demo.ControllerTest;

import com.decrease.controller.SessionController;
import com.decrease.entities.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SessionControllerTest {

    private User user;
    private SessionController sessController;
    
    public SessionControllerTest() {
    }

    @BeforeEach
    public void setUp() {
        user = new User();
        sessController = SessionController.getInstance();
        sessController.logOut();
    }

    @Test
    public void testGetInstanceShouldReturnAnInstance() {
        SessionController call1 = SessionController.getInstance();
        SessionController call2 = SessionController.getInstance();

        assertEquals(call1, call2);
    }

    @Test
    public void testLogInMethodShouldReturnAnUserIfAnUserIsLogged() {

        sessController.logIn(user);

        assertTrue(sessController.isLoggedIn());
        assertEquals(user, sessController.getUserLogged());
    }

    @Test
    public void testLogOutMethodShouldLogOutTheUser() {
        sessController.logIn(user);
        
        sessController.logOut();
        
        assertNull(sessController.getUserLogged());
    }
    
    @Test
    public void testGetUserLoggedShouldReturnAnUserIfUserIsLogged(){
        sessController.logIn(user);
        
        assertSame(user, sessController.getUserLogged());
    }
    
    @Test
    public void testGetUserLoggedShouldReturnNullIfThereIsNoUserLogged(){
        assertNull(sessController.getUserLogged());
    }
    
    @Test
    public void testIsLoggedInMethodShouldReturnTrueIfThereIsAnUserLogged(){
        sessController.logIn(user);
        
        assertTrue(sessController.isLoggedIn());
    }
    
    @Test
    public void testIsLoggedInMethodShouldReturnFalseIfThereIsAnUserLogged(){
        assertFalse(sessController.isLoggedIn());
    }
    
}
