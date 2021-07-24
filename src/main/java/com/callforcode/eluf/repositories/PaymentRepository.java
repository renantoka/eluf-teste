package com.callforcode.eluf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.callforcode.eluf.model.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

}