package com.callforcode.eluf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.callforcode.eluf.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}