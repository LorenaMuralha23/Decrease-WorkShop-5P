/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demo.ControllerTest;

import com.decrease.controller.ValidatorController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import static org.mockito.MockitoAnnotations.openMocks;

public class ValidatorControllerTest {
    
    ValidatorController controller;
    
    public ValidatorControllerTest() {
    }
    
    @BeforeEach
    public void setUp() {
        controller = new ValidatorController();
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testIsValidEmail() {
        assertTrue(controller.isValidEmail("user@gmail.com"));
    }
    
    @Test
    public void testIsInvalidEmail() {
        assertFalse(controller.isValidEmail("user..test23@gmail.com"));
    }
    
}
