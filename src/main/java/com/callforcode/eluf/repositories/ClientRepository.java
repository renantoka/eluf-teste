package com.callforcode.eluf.repositories;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.callforcode.eluf.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Transactional(readOnly=true)
	Client findByEmail(String email);

}