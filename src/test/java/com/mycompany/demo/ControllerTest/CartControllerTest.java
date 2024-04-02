package com.mycompany.demo.ControllerTest;

import com.decrease.controller.CartController;
import com.decrease.controller.SessionController;
import com.decrease.entities.Cart;
import com.decrease.entities.CartItem;
import com.decrease.entities.Order;
import com.decrease.entities.Product;
import com.decrease.entities.User;
import com.decrease.services.CartService;
import java.time.Instant;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import static org.mockito.MockitoAnnotations.openMocks;

public class CartControllerTest {

    @InjectMocks
    private CartController controller;

    @Mock
    private CartService service;

    @Mock
    private SessionController sessionControllerMock;

    public CartControllerTest() {
    }

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    @Test
    public void testAddProductToCartShouldAddAProduct() {
        Product product = new Product();

        controller.addProductToCart(product, 2, sessionControllerMock);

        verify(service, times(1)).addProductToCart(product, 2, sessionControllerMock);
    }

    @Test
    public void testIfTheItemIsAddedAfterMethod() {
        Product product = new Product();

        controller.addProductToCart(product, 2, sessionControllerMock);

        CartItem itemToTest = new CartItem();
        itemToTest.setProduct(product);
        itemToTest.setQuantity(2);

        when(service.getCartItemById(any(Integer.class))).thenReturn(Optional.of(itemToTest));

        Optional<CartItem> addedItem = controller.getItem(1);
        assertTrue(addedItem.isPresent());
        assertEquals(itemToTest, addedItem.get());

    }

    @Test
    public void testGetItemMethodShouldReturnTheRightProduct() {

        Product product = new Product();

        CartItem itemToTest = new CartItem();
        itemToTest.setProduct(product);

        Cart cart = new Cart();

        itemToTest.setCart(cart);

        when(service.getCartItemById(any(Integer.class))).thenReturn(Optional.of(itemToTest));

        controller.addProductToCart(product, 2, sessionControllerMock);

        verify(service, times(1)).addProductToCart(product, 2, sessionControllerMock);

        Optional<CartItem> cartItem = controller.getItem(1);
        CartItem itemObj = cartItem.orElse(null);

        assertSame(itemToTest, itemObj);
    }

    @Test
    public void testGetItemMethodShouldReturnNullIfTheIdIsWrong() {
        Product product = new Product();

        CartItem itemToTest = new CartItem();
        itemToTest.setProduct(product);

        Cart cart = new Cart();

        itemToTest.setCart(cart);

        controller.addProductToCart(product, 2, sessionControllerMock);

        verify(service, times(1)).addProductToCart(product, 2, sessionControllerMock);

        Optional<CartItem> cartItem = controller.getItem(1000); //invalid id
        CartItem itemObj = cartItem.orElse(null);

        assertNull(itemObj);
    }

    @Test
    public void testCleanCartMethodShouldCleanAllItems() throws Exception {
        User user = new User();
        Product p1 = new Product();
        Product p2 = new Product();
        Cart cart = new Cart();

        CartItem item1 = new CartItem();
        item1.setProduct(p1);
        item1.setCart(cart);
        CartItem item2 = new CartItem();
        item2.setProduct(p2);
        item2.setCart(cart);

        controller.addProductToCart(p1, 1, sessionControllerMock);
        controller.addProductToCart(p2, 1, sessionControllerMock);

        user.setCart(cart);

        controller.cleanCart(user);

        verify(service, times(1)).cleanCart(user);

        int numOfItemInCart = cart.getItems().size();

        assertEquals(0, numOfItemInCart);

    }

    @Test
    public void testDeleteItemMethodShouldRemoveTheRightItem() {
        Cart cart = new Cart();
        Product p1 = new Product();
        Product p2 = new Product();

        CartItem itemToDelete = new CartItem();
        itemToDelete.setProduct(p1);
        itemToDelete.setCart(cart);
        CartItem itemToKeep = new CartItem();
        itemToKeep.setProduct(p2);
        itemToKeep.setCart(cart);

        controller.addProductToCart(p1, 1, sessionControllerMock);
        controller.addProductToCart(p2, 1, sessionControllerMock);

        controller.deleteItem(p1, sessionControllerMock);

        assertFalse(cart.getItems().contains(itemToDelete));
    }

    @Test
    public void testDeleteItemMethodShouldReturnNullIfItemDoesntExists() {
        Cart cart = new Cart();
        Product p1 = new Product();

        CartItem itemToKeep = new CartItem();
        itemToKeep.setProduct(p1);
        itemToKeep.setCart(cart);

        controller.addProductToCart(p1, 1, sessionControllerMock);

        assertNull(controller.deleteItem(new Product(), sessionControllerMock));
    }

    @Test
    public void testGetSubtotalMethod() {
        User user = new User();

        Cart cart = new Cart();

        Product p1 = new Product();
        Product p2 = new Product();
        p1.setPrice(10.0);
        p2.setPrice(20.0);
        p1.setName("P1");
        p2.setName("P2");

        CartItem item1 = new CartItem(cart, p1, 2, p1.getPrice());
        CartItem item2 = new CartItem(cart, p2, 3, p2.getPrice());

        cart.getItems().add(item1);
        cart.getItems().add(item2);

        user.setCart(cart);

        when(service.getSubtotal(sessionControllerMock)).thenReturn(user.getCart().getSubtotal());

        double oficialResult = (item1.getPrice() * item1.getQuantity()) + (item2.getPrice() * item2.getQuantity());

        assertEquals(oficialResult, controller.getSubtotal(sessionControllerMock));
    }

    @Test
    public void testGetSubtotalMethodWhenCartIsEmpty() {
        User user = new User();
        Cart cart = new Cart();
        user.setCart(cart);

        when(service.getSubtotal(sessionControllerMock)).thenReturn(user.getCart().getSubtotal());

        assertEquals(0.0, controller.getSubtotal(sessionControllerMock));
    }

    @Test
    public void testConvertCartToOrderIfReturnsAnOrder() {
        
        Order orderMock = new Order();
        when(service.covertCartToOrder(sessionControllerMock)).thenReturn(orderMock);
        Order orderReturned = controller.covertCartToOrder(sessionControllerMock);
        assertNotNull(orderReturned); // Verifica se o resultado não é nulo
        assertEquals(orderMock, orderReturned);
    }
    
    @Test
    public void testCalculateInstallmentsShouldReturnInstallment(){
        double totalValue = 10.2;
        
        int numOfInstallment = controller.calculateInstallments(totalValue);
        
        double installmentValue = totalValue/numOfInstallment;
        
        assertTrue(installmentValue > 20.0);
    }
            
}
