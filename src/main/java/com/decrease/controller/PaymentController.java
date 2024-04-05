package com.decrease.controller;

import com.decrease.entities.Order;
import com.decrease.entities.Payment;
import com.decrease.services.PaymentService;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Controlador responsável por gerenciar os pagamentos.
 */
@Controller
public class PaymentController {
    
    @Autowired
    private PaymentService service;

    /**
     * Construtor padrão do controlador de pagamentos.
     */
    public PaymentController() {
    }
    
    /**
     * Gera um pagamento com base no momento, pedido e tipo fornecidos.
     * @param moment O momento em que o pagamento é gerado.
     * @param order O pedido associado ao pagamento.
     * @param type O tipo de pagamento a ser gerado.
     * @return O pagamento gerado.
     */
    public Payment generatePayment(Instant moment, Order order, Integer type){
        return service.generatePayment(moment, order, type);
    }
    
}