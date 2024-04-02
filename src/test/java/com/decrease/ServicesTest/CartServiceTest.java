package com.decrease.ServicesTest;

import com.decrease.controller.SessionController;
import com.decrease.entities.Cart;
import com.decrease.entities.CartItem;
import com.decrease.entities.Order;
import com.decrease.entities.OrderItem;
import com.decrease.entities.Product;
import com.decrease.entities.User;
import com.decrease.repositories.CartItemRepository;
import com.decrease.repositories.CartRepository;
import com.decrease.services.CartService;
import java.util.Arrays;
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

public class CartServiceTest {

    @InjectMocks
    private CartService service;

    @Mock
    private CartRepository repository;

    @Mock
    private CartItemRepository itemRepository;

    @Mock
    private SessionController sessionControllerMock;

    private User userTest;

    public CartServiceTest() {
    }

    @BeforeEach
    public void setUp() {
        openMocks(this);
        userTest = new User();
        when(sessionControllerMock.getUserLogged()).thenReturn(userTest);
    }

    /**
     * Test of createCart method, of class CartService.
     */
    @Test
    public void testCreateCart() {
        Cart expectedCart = new Cart(userTest);

        when(repository.save(any(Cart.class))).thenReturn(expectedCart);

        service.createCart(userTest, sessionControllerMock);

        verify(sessionControllerMock, times(1)).getUserLogged();
        verify(repository, times(1)).save(expectedCart);
    }

    /**
     * Test of addProductToCart method, of class CartService.
     */
    @Test
    public void testAddProductToCartIfCartIsNull() {

        Product product = new Product();
        Integer quantity = 1;
        User userLogged = new User();

        // Definindo o carrinho do usuário como nulo
        userLogged.setCart(null);

        // Act
        service.addProductToCart(product, quantity, sessionControllerMock);

        // Assert
        verify(sessionControllerMock, times(2)).getUserLogged(); // Verifica se o método getUserLogged foi chamado 2 vezes = cart É null
        verify(itemRepository, times(1)).save(any(CartItem.class));
    }

    @Test
    public void testAddProductToCartIfCartIsNotNull() {
        // Arrange
        Product product = new Product(); // Criando um produto simulado
        Integer quantity = 1; // Definindo a quantidade

        Cart cart = new Cart(userTest);

        // Definindo o carrinho do usuário como nulo
        userTest.setCart(cart);

        // Act
        service.addProductToCart(product, quantity, sessionControllerMock);

        // Assert
        verify(sessionControllerMock, times(1)).getUserLogged(); // Verifica se o método getUserLogged foi chamado uma vez = cart não é null
        verify(itemRepository, times(1)).save(any(CartItem.class));
    }

    /**
     * Test of getCartItemById method, of class CartService.
     */
    @Test
    public void testGetCartItemByIdIfIdIsValid() {
        CartItem itemExpected = new CartItem();
        Product product = new Product();
        product.setId(2);
        Cart cart = new Cart(userTest);
        cart.setId(1);
        itemExpected.setProduct(product);
        itemExpected.setCart(cart);

        when(itemRepository.findById(any(Integer.class))).thenReturn(Optional.of(itemExpected));

        Optional<CartItem> itemReturnedObj = service.getCartItemById(1);
        CartItem itemReturned = itemReturnedObj.get();

        assertNotNull(itemReturnedObj);
        assertEquals(itemExpected.getProduct().getId(), itemReturned.getProduct().getId());
    }

    @Test
    public void testGetCartItemByIdIfIdIsInvalid() {
        when(itemRepository.findById(any(Integer.class))).thenReturn(Optional.empty());

        Optional<CartItem> itemReturnedObj = service.getCartItemById(1);
        assertTrue(itemReturnedObj.isEmpty());
    }

    /**
     * Test of cleanCart method, of class CartService.
     */
    @Test
    public void testCleanCart() {
        CartItem item1 = new CartItem();
        CartItem item2 = new CartItem();
        Product product = new Product();
        product.setId(2);
        Cart cart = new Cart(userTest);
        item1.setProduct(product);
        item2.setProduct(product);
        item2.setCart(cart);
        item1.setCart(cart);

        cart.getItems().add(item1);
        cart.getItems().add(item2);

        userTest.setCart(cart);

        service.cleanCart(userTest);

        verify(itemRepository, times(1)).deleteAll();
        assertTrue(cart.getItems().isEmpty());
    }

    /**
     * Test of deleteItem method, of class CartService.
     */
    @Test
    public void testDeleteItemExistingProduct() {
        Cart cart = new Cart(userTest);
        CartItem itemExpected = new CartItem();
        Product product = new Product(1, "P1", "anything", 100.0, "anyImg");
        itemExpected.setProduct(product);
        itemExpected.setCart(cart);
        userTest.setCart(cart);
        when(itemRepository.findByProductId(product.getId())).thenReturn(Optional.of(itemExpected));

        CartItem itemReturned = service.deleteItem(product, sessionControllerMock);

        verify(itemRepository, times(1)).deleteByProductId(any(Integer.class));
        assertFalse(userTest.getCart().getItems().contains(itemExpected));
        assertEquals(itemExpected, itemReturned);
    }

    @Test
    public void testDeleteItemNonexistentProduct() {
        Cart cart = new Cart(userTest);
        Product product = new Product(1, "P1", "anything", 100.0, "anyImg");
        userTest.setCart(cart);
        when(itemRepository.findByProductId(product.getId())).thenReturn(Optional.empty());

        // Act
        CartItem itemReturned = service.deleteItem(product, sessionControllerMock);

        assertNull(itemReturned);
    }

    /**
     * Test of removeCartItem method, of class CartService.
     */
    @Test
    public void testRemoveCartItem() {
        Cart cart = new Cart(userTest);
        CartItem itemToDelete = new CartItem();
        Product product = new Product(1, "P1", "anything", 100.0, "anyImg");
        itemToDelete.setProduct(product);
        itemToDelete.setCart(cart);
        cart.getItems().add(itemToDelete);
        userTest.setCart(cart);

        assertTrue(service.removeCartItem(userTest, itemToDelete));
    }

    @Test
    public void testRemoveCartItemForNullCart() {
        assertFalse(service.removeCartItem(userTest, null)); // Passando null como CartItem
    }

    @Test
    public void testRemoveCartItemForNonexistingProduct() {
        Cart cart = new Cart(userTest);
        CartItem rightItem = new CartItem();
        CartItem wrongItem = new CartItem();
        Product rightProduct = new Product(1, "P1", "anything", 100.0, "anyImg");
        rightItem.setProduct(rightProduct);
        rightItem.setCart(cart);
        cart.getItems().add(rightItem);
        userTest.setCart(cart);

        assertFalse(service.removeCartItem(userTest, wrongItem));
    }

    /**
     * Test of getSubtotal method, of class CartService.
     */
    @Test
    public void testGetSubtotal() {
        Cart cart = new Cart(userTest);
        Product p1 = new Product(1, "P1", "anything", 100.0, "anyImg");
        Product p2 = new Product(2, "P2", "anything", 200.0, "anyImg");
        Product p3 = new Product(3, "P3", "anything", 400.0, "anyImg");
        CartItem i1 = new CartItem(cart, p1, 1, p1.getPrice());
        CartItem i2 = new CartItem(cart, p2, 2, p2.getPrice());
        CartItem i3 = new CartItem(cart, p3, 3, p3.getPrice());
        cart.getItems().addAll(Arrays.asList(i1, i2, i3));

        userTest.setCart(cart);

        double resultExcpected = (i1.getPrice() * i1.getQuantity()) + (i2.getPrice() * i2.getQuantity()) + (i3.getPrice() * i3.getQuantity());

        assertEquals(resultExcpected, service.getSubtotal(sessionControllerMock));
    }

    /**
     * Test of covertCartToOrder method, of class CartService.
     */
    @Test
    public void testCovertCartToOrder() {
        Cart cart = new Cart(userTest);
        Product p1 = new Product(1, "P1", "anything", 100.0, "anyImg");
        Product p2 = new Product(2, "P2", "anything", 200.0, "anyImg");
        CartItem i1 = new CartItem(cart, p1, 1, p1.getPrice());
        CartItem i2 = new CartItem(cart, p2, 2, p2.getPrice());
        cart.getItems().addAll(Arrays.asList(i1, i2));

        OrderItem itemP1 = new OrderItem(null, i1.getProduct(), i1.getQuantity(), i1.getPrice());
        OrderItem itemP2 = new OrderItem(null, i1.getProduct(), i1.getQuantity(), i1.getPrice());
        OrderItem itemP3 = new OrderItem(null, i1.getProduct(), i1.getQuantity(), i1.getPrice());

        userTest.setCart(cart);

        // Act
        Order orderReturned = service.covertCartToOrder(sessionControllerMock);
        assertFalse(orderReturned.getOrderItems().isEmpty());
    }

    /**
     * Test of calculateInstallments method, of class CartService.
     */
    @Test
    public void testCalculateInstallmentsForMultiplesOf20() {
        double totalValue = 100.0;
        int numInstallments = service.calculateInstallments(totalValue);
        double installmentValue = totalValue / numInstallments;
        assertTrue(installmentValue > 20.0);

    }

    @Test
    public void testCalculateInstallmentsForNoMultiplesOf20() {
        double totalValue = 543.99;
        int numInstallments = service.calculateInstallments(totalValue);
        double installmentValue = totalValue / numInstallments;
        assertTrue(installmentValue > 20.0);

    }

    @Test
    public void testCalculateInstallmentsForTotalEquals20() {
        double totalValue = 20;
        int numInstallments = service.calculateInstallments(totalValue);
        double installmentValue = totalValue / numInstallments;
        assertTrue(numInstallments == 1);
    }
}
