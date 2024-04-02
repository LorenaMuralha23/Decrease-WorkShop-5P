/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.demo.ControllerTest;

import com.decrease.controller.ProductController;
import com.decrease.entities.Product;
import com.decrease.services.ProductService;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

/**
 *
 * @author USER
 */
public class ProductControllerTest {

    @InjectMocks
    private ProductController controller;
    
    @Mock
    private ProductService service;

    public ProductControllerTest() {
    }

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void testInsertMethodShouldCallInsertFromServiceCorrectly(){
        Product productMock = new Product();
        controller.insert(productMock);
        
        verify(service, times(1)).insert(productMock);
    }
    
    @Test
    public void testFindByIdMethodShouldReturnAnOptionalValid(){
        Product productMock = new Product();
        when(service.findById(any(Long.class))).thenReturn(productMock);
        
        Product productReturned = controller.findById(1L);
        
        assertEquals(productMock, productReturned);
    }
    
    @Test
    public void testFindByIdMethodShouldReturnAnOptionalInvalid(){
        when(service.findById(any(Long.class))).thenReturn(null);
        
        Product productReturned = controller.findById(100L);
        
        assertTrue(productReturned == null);
    }
    
    @Test
    public void testCreateInstanceMethodShouldReturnAnInstance(){
        String name = "Product Mock";
        String description = " "; 
        Double price = 30.0; 
        String imgUrl = " ";
        Product productMock = new Product(null, name, description, price, imgUrl);
        
        when(service.createInstance(any(String.class), any(String.class), any(Double.class), any(String.class))).thenReturn(productMock);
        
        Product productInstanciated = controller.createInstance(name, description, price, imgUrl);
        
        verify(service, times(1)).createInstance(name, description, price, imgUrl);
        assertEquals(productMock, productInstanciated);
    }
    
    @Test
    public void testGetProductByNameShouldReturnAnProduct(){
        String name = "Product Mock";
        String description = " "; 
        Double price = 30.0; 
        String imgUrl = " ";
        Product productMock = new Product(null, name, description, price, imgUrl);
        
        when(service.getProductByName(any(String.class))).thenReturn(productMock);
        
        Product productReturned = controller.getProductByName(name);
        
        assertNotNull(productReturned);
        assertEquals(productMock, productReturned);
    }
    
    @Test
    public void testGetProductByNameShouldReturnAnNullOptionalForInvalidName(){
        
        when(service.getProductByName(any(String.class))).thenReturn(null);
        
        Product productReturned = controller.getProductByName("Any name");
        
        assertNull(productReturned);
    }
    
}
