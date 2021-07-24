package com.callforcode.eluf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.callforcode.eluf.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}