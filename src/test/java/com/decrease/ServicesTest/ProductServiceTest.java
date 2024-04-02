/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.decrease.ServicesTest;

import com.decrease.entities.Product;
import com.decrease.repositories.ProductRepository;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class ProductServiceTest {

    @InjectMocks
    private ProductService service;

    @Mock
    private ProductRepository repository;

    public ProductServiceTest() {
    }

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    /**
     * Test of insert method, of class ProductService.
     */
    @Test
    public void testInsert() {
        Product productTest = new Product();
        service.insert(productTest);
        verify(repository, times(1)).save(productTest);
    }

    /**
     * Test of findById method, of class ProductService.
     */
    @Test
    public void testFindByIdForValidId() {
        Product productExpected = new Product(1, "P1", "Anything", 145.99, "anyimage");
        when(repository.findById(1L)).thenReturn(Optional.of(productExpected));

        Product productReturned = service.findById(1L);
        assertNotNull(productReturned);
        assertEquals(productExpected.getId(), productReturned.getId());
    }

    @Test
    public void testFindByIdForInvalidId() {
        when(repository.findById(any(Long.class))).thenReturn(Optional.empty());

        Product productReturned = service.findById(1L);
        assertNull(productReturned);
    }

    /**
     * Test of createInstance method, of class ProductService.
     */
    @Test
    public void testCreateInstance() {
        String name = "ProductName";
        String description = "Any description";
        double price = 239.87;
        Product productExpected = new Product(1, name, description, price, "imgurl");

        Product productReturned = service.createInstance(name, description, price, "image");

        assertNotNull(productReturned);

    }

    /**
     * Test of getProductByName method, of class ProductService.
     */
    @Test
    public void testGetProductByName() {
        Product productExpected = new Product();
        productExpected.setName("P1");
        when(repository.findByName(productExpected.getName())).thenReturn(Optional.of(productExpected));

        Product productReturned = service.getProductByName("P1");
        assertNotNull(productReturned);
        assertEquals(productExpected.getId(), productReturned.getId());
    }

}
