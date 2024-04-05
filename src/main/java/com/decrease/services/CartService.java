package com.decrease.services;

import com.decrease.controller.SessionController;
import com.decrease.entities.Cart;
import com.decrease.entities.CartItem;
import com.decrease.entities.Order;
import com.decrease.entities.OrderItem;
import com.decrease.entities.Product;
import com.decrease.entities.User;
import com.decrease.entities.enums.OrderStatus;
import com.decrease.repositories.CartItemRepository;
import com.decrease.repositories.CartRepository;
import java.time.Instant;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável por operações relacionadas ao carrinho de compras.
 */
@Service
public class CartService {

    @Autowired
    CartRepository repository;

    @Autowired
    CartItemRepository itemRepository;
    
    public CartService() {
    }

    /**
     * Cria um novo carrinho de compras para o usuário logado.
     * 
     * @param userLogged o usuário logado
     * @param session o controlador de sessão
     */
    public void createCart(User userLogged, SessionController session) {
        Cart cart = new Cart(userLogged);
        session.getUserLogged().setCart(cart);
        repository.save(cart);
    }

    /**
     * Adiciona um produto ao carrinho de compras.
     * 
     * @param product o produto a ser adicionado
     * @param quantity a quantidade do produto a ser adicionada
     * @param session o controlador de sessão
     */
    public void addProductToCart(Product product, Integer quantity, SessionController session) {
        User userLogged = session.getUserLogged();
        Cart userCart = userLogged.getCart();
        if (userCart == null) {
            createCart(userLogged, session);
            userCart = userLogged.getCart();
        }
        CartItem item = new CartItem(userCart, product, quantity, product.getPrice());
        userCart.getItems().add(item);
        itemRepository.save(item);
    }

    /**
     * Obtém um item de carrinho pelo seu ID.
     * 
     * @param id o ID do item de carrinho
     * @return um {@code Optional} contendo o item de carrinho, ou vazio se não encontrado
     */
    public Optional<CartItem> getCartItemById(Integer id) {
        return itemRepository.findById(id);
    }

    /**
     * Limpa o carrinho de compras do usuário.
     * 
     * @param userLogged o usuário logado
     */
    public void cleanCart(User userLogged) {
        if (userLogged != null) {
            Cart cart = userLogged.getCart();
            if (cart != null && !cart.getItems().isEmpty()) {
                itemRepository.deleteAll();
                cart.getItems().clear();
            }
        }
    }

    /**
     * Remove um item do carrinho de compras.
     * 
     * @param productToDelete o produto a ser removido do carrinho
     * @param session o controlador de sessão
     * @return o item de carrinho removido, ou {@code null} se não encontrado
     */
    public CartItem deleteItem(Product productToDelete, SessionController session) {
        Optional<CartItem> obj = itemRepository.findByProductId(productToDelete.getId());
        CartItem item = obj.orElse(null);
        if (item != null) {
            itemRepository.deleteByProductId(productToDelete.getId());
            removeCartItem(session.getUserLogged(), item);
            return item;
        }
        return null;
    }

    /**
     * Remove um item do carrinho de compras.
     * 
     * @param user o usuário do carrinho
     * @param itemToRemove o item a ser removido
     * @return {@code true} se o item foi removido com sucesso, caso contrário {@code false}
     */
    public boolean removeCartItem(User user, CartItem itemToRemove) {
        // Obtém o carrinho do usuário
        Cart cart = user.getCart();
        boolean deleted = false;
        // Verifica se o carrinho existe e se o item está presente no carrinho
        if (cart != null && cart.getItems().contains(itemToRemove)) {
            // Remove o item do carrinho
            deleted = cart.getItems().remove(itemToRemove);
        }
        return deleted;
    }

    /**
     * Calcula o subtotal do carrinho de compras.
     * 
     * @param session o controlador de sessão
     * @return o subtotal do carrinho
     */
    public Double getSubtotal(SessionController session) {
        return session.getUserLogged().getCart().getSubtotal();
    }

    /**
     * Converte o carrinho de compras em um pedido.
     * 
     * @param session o controlador de sessão
     * @return o pedido criado a partir do carrinho
     */
    public Order covertCartToOrder(SessionController session) {
        User userLogged = session.getUserLogged();
        Order order = new Order(null, Instant.now(), OrderStatus.SHIPPED, userLogged); //por agora, todos os orders terão o status de Shipped
        for (CartItem item : userLogged.getCart().getItems()) {
            OrderItem orderItem = new OrderItem(order, item.getProduct(), item.getQuantity(), item.getPrice());
            order.getOrderItems().add(orderItem);
        }
        cleanCart(userLogged);

        return order;
    }

    /**
     * Calcula o número de parcelas para o pagamento do valor total.
     * 
     * @param totalValue o valor total a ser pago
     * @return o número de parcelas
     */
    public int calculateInstallments(double totalValue) {
        double minInstallmentValue = 20.0;

        // Se o valor total for menor ou igual ao valor mínimo de uma parcela, retorna 1
        if (totalValue <= minInstallmentValue) {
            return 1;
        }

        int numInstallments = (int) Math.floor(totalValue / minInstallmentValue);
        
        if (totalValue%numInstallments == 0) {
            numInstallments--;
        }

        return numInstallments;
    }

}