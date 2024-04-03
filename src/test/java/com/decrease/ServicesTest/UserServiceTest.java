package com.decrease.ServicesTest;

import com.decrease.controller.SessionController;
import com.decrease.controller.ValidatorController;
import com.decrease.entities.Address;
import com.decrease.entities.Cart;
import com.decrease.entities.CartItem;
import com.decrease.entities.User;
import com.decrease.model.Alerts;
import com.decrease.model.CustomException;
import com.decrease.repositories.UserRepository;
import com.decrease.services.UserService;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class UserServiceTest {
    //when(service.getCartItemById(any(Integer.class))).thenReturn(Optional.of(itemToTest));

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Mock
    private ValidatorController validator;

    @Mock
    private SessionController sessionControllerMock;

    public UserServiceTest() {
    }

    @BeforeEach
    public void setUp() {
        openMocks(this);
    }

    /**
     * Test of findAll method, of class UserService.
     */
    @Test
    public void testFindAll() {
        User userMock1 = new User();
        User userMock2 = new User();
        User userMock3 = new User();

        List<User> listExpected = Arrays.asList(userMock1, userMock2, userMock3);

        when(repository.findAll()).thenReturn(listExpected);

        List<User> listReturned = service.findAll();

        verify(repository, times(1)).findAll();
        assertEquals(listExpected, listReturned);
        for (int i = 0; i < listExpected.size(); i++) {
            assertTrue(Objects.equals(listExpected.get(i).getId(), listReturned.get(i).getId()));
        }
    }

    @Test
    public void testFindById() {
        User userMock = new User();
        userMock.setId(12L);

        when(repository.findById(any(Long.class))).thenReturn(Optional.of(userMock));

        Optional<User> userOpt = service.findById(12L);
        User userReturned = userOpt.get();

        assertNotNull(userOpt);
        assertNotNull(userReturned);
        assertEquals(userMock.getId(), userReturned.getId());
    }

    @Test
    public void testFindByIdForInvalidId() {
        when(repository.findById(any(Long.class))).thenReturn(Optional.empty());

        Optional<User> userOpt = service.findById(12L);

        assertTrue(userOpt.isEmpty());
    }

    @Test
    public void testInsertForValidUser() throws CustomException {
        User userMock = new User(null, "User Test", "userTst@gmail.com", "99999999", "password");

        when(repository.existsByName(userMock.getName())).thenReturn(false);
        when(repository.existsByName(userMock.getEmail())).thenReturn(false);
        when(repository.save(userMock)).thenReturn(userMock);
        when(validator.isValidEmail(userMock.getEmail())).thenReturn(true);

        User userReturned = service.insert(userMock);

        assertNotNull(userReturned);
        assertEquals("User Test", userReturned.getName());
        assertEquals("userTst@gmail.com", userReturned.getEmail());
        assertEquals("password", userReturned.getPassword());

    }

    @Test
    public void testInsertForAnExistingUsername() {
        User userMock = new User(null, "User Test", "userTst@gmail.com", "99999999", "password");
        Alerts alert = mock(Alerts.class);
        
        when(repository.existsByName(userMock.getName())).thenReturn(true);

        
        CustomException e = assertThrows(CustomException.class, () -> service.insert(userMock));
        String msg = msg = """
                        Username provided is already in use.
                        Try again
                        """;
        assertEquals(msg, e.getMessage());
    }

    @Test
    public void testInsertForExistingEmail() {
        User userMock = new User(null, "User Test", "userTst..INVALID@gmail.com", "99999999", "password");

        when(repository.existsByEmail(userMock.getEmail())).thenReturn(true);

        CustomException e = assertThrows(CustomException.class, () -> service.insert(userMock));
        String msg = """
                        Email provided is already in use.
                        Try again
                        """;
        assertEquals(msg, e.getMessage());
    }

    @Test
    public void testInsertForInvalidEmailFormat() {
        User userMock = new User(null, "User Test", "userTst@gmail.com", "99999999", "password");

        when(repository.existsByName(userMock.getName())).thenReturn(false);
        when(repository.existsByName(userMock.getEmail())).thenReturn(false);
        when(validator.isValidEmail(userMock.getEmail())).thenReturn(false);

        CustomException e = assertThrows(CustomException.class, () -> service.insert(userMock));
        assertEquals("Invalid email format", e.getMessage());

    }

    @Test
    public void testUpdate() {
        User userMock = mock(User.class);
        User userInfoToUpdated = new User(null, "User newName", "userTst@gmail.com", "99999999", "new password");

        when(repository.getReferenceById(userMock.getId())).thenReturn(userMock);
        when(repository.save(userMock)).thenReturn(userMock);

        service.update(userMock.getId(), userInfoToUpdated);

        verify(userMock, times(1)).setName(any(String.class));
        verify(userMock, times(1)).setEmail(any(String.class));
        verify(userMock, times(1)).setPassword(any(String.class));
        verify(userMock, times(1)).setPhone(any(String.class));
    }

    @Test
    public void testLogInForValidUser() throws CustomException {
        User userMock = new User(null, "User Test", "userTst@gmail.com", "99999999", "password");
        when(repository.findByEmail(any(String.class))).thenReturn(Optional.of(userMock));
        assertTrue(service.logIn(userMock.getEmail(), userMock.getPassword(), sessionControllerMock));
    }

    @Test
    public void testLogInForInvalidPassword() {
        User userMock = new User(null, "User Test", "userTst@gmail.com", "99999999", "password");
        when(repository.findByEmail(any(String.class))).thenReturn(Optional.of(userMock));

        CustomException e = assertThrows(CustomException.class, () -> service.logIn(userMock.getEmail(), "invalid password", sessionControllerMock));
        String msg = """
                        Invalid password!
                        """;
        assertEquals(msg, e.getMessage());
    }

    @Test
    public void testLogInForNonExistingUser() {
        User userMock = new User(null, "User Test", "userTst@gmail.com", "99999999", "password");
        when(repository.findByEmail(any(String.class))).thenReturn(Optional.empty());

        CustomException e = assertThrows(CustomException.class, () -> service.logIn(userMock.getEmail(), "password", sessionControllerMock));
        String msg = """
                        User not found!
                        """;
        assertEquals(msg, e.getMessage());
    }

    @Test
    public void testGetUserLogged() {
        User userTest = new User();
        userTest.setId(12L);
        when(sessionControllerMock.getUserLogged()).thenReturn(userTest);
        User userReturned = service.getUserLogged(sessionControllerMock);
        verify(sessionControllerMock, times(1)).getUserLogged();

        assertEquals(userTest.getId(), userReturned.getId());
    }

    @Test
    public void testGetUserCartForAnEmptyCart() {
        User userTest = new User();
        Cart cart = new Cart(userTest);
        userTest.setCart(cart);
        when(sessionControllerMock.getUserLogged()).thenReturn(userTest);
        Set<CartItem> listReturned = service.getUserCart(sessionControllerMock);

        assertNotNull(listReturned);
        assertTrue(listReturned.isEmpty());
    }

    @Test
    public void testGetUserCartForCartWithItems() {
        User userTest = new User();
        Cart cart = new Cart(userTest);

        CartItem item1 = new CartItem();
        CartItem item2 = new CartItem();

        cart.getItems().add(item1);
        cart.getItems().add(item2);

        userTest.setCart(cart);
        when(sessionControllerMock.getUserLogged()).thenReturn(userTest);
        Set<CartItem> listReturned = service.getUserCart(sessionControllerMock);

        assertNotNull(listReturned);
        assertFalse(listReturned.isEmpty());
    }

    @Test
    public void testGetAddressForUserWhoHasAnAddress() {
        User userTest = new User();
        Address address = new Address();
        userTest.setAddress(address);
        when(sessionControllerMock.getUserLogged()).thenReturn(userTest);

        Address addressReturned = service.getAddress(sessionControllerMock);

        assertEquals(userTest.getAddress(), addressReturned);
    }

    @Test
    public void testGetAddressForUserWhoHasNoAddress() {
        User userTest = new User();
        when(sessionControllerMock.getUserLogged()).thenReturn(userTest);

        Address addressReturned = service.getAddress(sessionControllerMock);

        assertNull(addressReturned);
    }

}
