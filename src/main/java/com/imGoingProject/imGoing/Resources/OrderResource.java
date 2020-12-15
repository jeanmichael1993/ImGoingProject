package com.imGoingProject.imGoing.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imGoingProject.imGoing.entities.Order;
import com.imGoingProject.imGoing.services.OrderService;

@RestController
//user é o caminho para a requisição
@RequestMapping(value = "/orders")
public class OrderResource {
	
	@Autowired
	private OrderService service;
	
	//metodo para pegar um dado
	@GetMapping
	//findall para pegar todos
	public ResponseEntity<List<Order>> findAll(){
		//criando um objeto com dados
	List<Order> list = service.findAll();
		//retornar o objeto
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
