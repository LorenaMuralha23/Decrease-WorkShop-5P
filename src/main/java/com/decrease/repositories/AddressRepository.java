package com.decrease.repositories;

import com.decrease.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface que define um repositório para operações de acesso a dados relacionados a endereços.
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {

    
}