package com.vm.spring.controller;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.vm.spring.entity.Product;
import com.vm.spring.service.ProductService;



@Controller
public class ProductWebController {
    @Autowired
    private ProductService service;
    

    @RequestMapping("/")
    public String viewHomePage(Model model) {  
        return "home";
}  
    
    
    @RequestMapping("/user")
    public String viewUserHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
         
        return "index";
}
    
    @RequestMapping("/admin")
    public String viewAdminHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        model.addAttribute("user", "ADMIN");
         
        return "admin";
}
    @RequestMapping("/admin/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
         
        return "newproduct";
    }
    @RequestMapping(value = "admin/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
         
        return "redirect:/admin";
    }
    @RequestMapping("/admin/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("editproduct");
        Product product = service.get(id);
        mav.addObject("product", product);
         
        return mav;
    }
    @RequestMapping("/admin/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/admin";       
    }
   
}
