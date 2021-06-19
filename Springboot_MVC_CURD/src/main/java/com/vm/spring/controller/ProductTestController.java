package com.vm.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vm.spring.entity.Product;
import com.vm.spring.service.ProductService;

@RestController

public class ProductTestController {
    @Autowired
    private ProductService service;
    
    @RequestMapping("/products")
    public List<Product> getAllProducts() {
        List<Product> listProducts = service.listAll();
       
        return listProducts;
}
    @RequestMapping("/products/{id}")
    public Product getProductbyid(@PathVariable(value="id") int id) {
      Product product = service.get(id);  
        return product;
}
    
    @RequestMapping(method = RequestMethod.POST,value = "products/add")
	void addStudent(@RequestBody Product product)
	{
    	service.save(product);
	}
    
    @RequestMapping(method = RequestMethod.PATCH,value = "products/update/{id}")
    public void updateProduct(@RequestBody Product product,@PathVariable(value="id") int id) {
       service.save(product);
    }
       
       @RequestMapping(method = RequestMethod.DELETE,value = "products/delete/{id}")
       public void deleteProduct(@PathVariable(value="id") int id) {
          service.delete(id);
}
    
} 