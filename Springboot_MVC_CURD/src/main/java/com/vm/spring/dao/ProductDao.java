package com.vm.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vm.spring.entity.Product;

@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

}
