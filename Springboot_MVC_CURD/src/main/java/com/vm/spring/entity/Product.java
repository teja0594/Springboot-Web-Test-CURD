package com.vm.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="amazonproduct")
public class Product {
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	    private String name;
	    private String catogery;
	    private int price;
	    
	 
	    public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getCatogery() {
			return catogery;
		}


		public void setCatogery(String catogery) {
			this.catogery = catogery;
		}


		public int getPrice() {
			return price;
		}


		public void setPrice(int price) {
			this.price = price;
		}


		public Product() {
	    }
	    
}
	 
	  
