package com.callforcode.eluf.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.callforcode.eluf.model.Client;
import com.callforcode.eluf.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Transactional(readOnly=true)
	Page<Order> findByCliente(Client client, Pageable pageRequest);
}