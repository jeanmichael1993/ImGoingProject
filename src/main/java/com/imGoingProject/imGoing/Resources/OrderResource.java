package com.imGoingProject.imGoing.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imGoingProject.imGoing.DTO.OrderDTO;
import com.imGoingProject.imGoing.entities.Order;
import com.imGoingProject.imGoing.services.OrderService;

@RestController
//user é o caminho para a requisição
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll(){
	List<OrderDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderDTO> findById(@PathVariable Long id){
		OrderDTO obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
