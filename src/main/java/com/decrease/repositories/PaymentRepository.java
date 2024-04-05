package com.decrease.repositories;

import com.decrease.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que define um repositório para operações de acesso a dados relacionados a pagamentos.
 */
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}