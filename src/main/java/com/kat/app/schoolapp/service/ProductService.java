package com.kat.app.schoolapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kat.app.schoolapp.model.Product;
import com.kat.app.schoolapp.repo.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> listAll() {
        return productRepository.findAll();
    }
     
    public void save(Product product) {
    	productRepository.save(product);
    }
     
    public Product get(long id) {
        return productRepository.findById(id).get();
    }
     
    public void deleteProductById(long id) {
    	productRepository.deleteById(id);
    }
}
