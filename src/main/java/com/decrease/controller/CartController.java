package com.decrease.controller;

import com.decrease.entities.CartItem;
import com.decrease.entities.Order;
import com.decrease.entities.Product;
import com.decrease.entities.User;
import com.decrease.services.CartService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Controlador responsável por gerenciar o carrinho de compras.
 */
@Component
public class CartController {

    @Autowired
    private CartService service;
    
    /**
     * Construtor padrão do controlador de carrinho.
     * Inicializa o serviço de carrinho.
     */
    public CartController() {
        service = new CartService();
    }

    /**
     * Adiciona um produto ao carrinho.
     * @param product O produto a ser adicionado.
     * @param quantity A quantidade do produto a ser adicionada.
     * @param session O controlador de sessão associado à operação.
     */
    public void addProductToCart(Product product, Integer quantity, SessionController session) {
        service.addProductToCart(product, quantity, session);
    }

    /**
     * Obtém um item do carrinho pelo seu ID.
     * @param id O ID do item a ser obtido.
     * @return Um Optional contendo o item do carrinho, se encontrado.
     */
    public Optional<CartItem> getItem(Integer id) {
        return service.getCartItemById(id);
    }

    /**
     * Limpa o carrinho do usuário.
     * @param userLogged O usuário logado cujo carrinho será limpo.
     */
    public void cleanCart(User userLogged) {
        service.cleanCart(userLogged);
    }

    /**
     * Exclui um item do carrinho.
     * @param product O produto a ser excluído do carrinho.
     * @param session O controlador de sessão associado à operação.
     * @return O item do carrinho excluído.
     */
    public CartItem deleteItem(Product product, SessionController session) {
        return service.deleteItem(product, session);
    }

    /**
     * Obtém o subtotal do carrinho.
     * @param session O controlador de sessão associado à operação.
     * @return O subtotal do carrinho.
     */
    public Double getSubtotal(SessionController session) {
        return service.getSubtotal(session);
    }

    /**
     * Converte o carrinho em um pedido.
     * @param session O controlador de sessão associado à operação.
     * @return O pedido criado a partir do carrinho.
     */
    public Order covertCartToOrder(SessionController session) {
        return service.covertCartToOrder(session);
    }

    /**
     * Calcula o número de parcelas para um determinado valor total.
     * @param totalValue O valor total para o qual as parcelas serão calculadas.
     * @return O número de parcelas calculado.
     */
    public int calculateInstallments(double totalValue) {
        return service.calculateInstallments(totalValue);
    }
    
}

