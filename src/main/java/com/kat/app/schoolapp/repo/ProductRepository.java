package com.kat.app.schoolapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kat.app.schoolapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
