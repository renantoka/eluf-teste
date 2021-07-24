package com.callforcode.eluf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.callforcode.eluf.model.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer>{

}
