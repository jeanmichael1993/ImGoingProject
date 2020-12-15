package com.imGoingProject.imGoing.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imGoingProject.imGoing.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
