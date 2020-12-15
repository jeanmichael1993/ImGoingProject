package com.imGoingProject.imGoing.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imGoingProject.imGoing.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
