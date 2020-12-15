package com.imGoingProject.imGoing.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imGoingProject.imGoing.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
