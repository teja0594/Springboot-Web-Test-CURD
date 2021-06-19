package com.vm.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vm.spring.dao.ProductDao;
import com.vm.spring.entity.Product;

@Service
public class ProductService {
	 
    @Autowired
    private ProductDao productDao;
     
    public List<Product> listAll() {
        return productDao.findAll();
    }
     
    public void save(Product product) {
        productDao.save(product);
    }
     
    public Product get(int id) {
        return productDao.findById(id).get();
    }
     
    public void delete(int id) {
        productDao.deleteById(id);
    }

}