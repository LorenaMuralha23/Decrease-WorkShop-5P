package com.decrease.services;

import com.decrease.entities.Order;
import com.decrease.entities.Payment;
import com.decrease.repositories.PaymentRepository;
import java.time.Instant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Esta classe de serviço fornece métodos relacionados às operações de pagamento.
 */
@Service
public class PaymentService {
    
    @Autowired
    PaymentRepository repository;

    /**
     * Constrói uma nova instância de PaymentService.
     */
    public PaymentService() {
    }
    
    /**
     * Gera um novo pagamento para o pedido especificado.
     * 
     * @param moment O momento em que o pagamento é gerado
     * @param order O pedido para o qual o pagamento é gerado
     * @param type O tipo de pagamento
     * @return O objeto de pagamento recém-gerado
     */
    public Payment generatePayment(Instant moment, Order order, Integer type){
        Payment newPayment = new Payment(null, moment, order, type);
        repository.save(newPayment);
        return newPayment;
    }
    
}