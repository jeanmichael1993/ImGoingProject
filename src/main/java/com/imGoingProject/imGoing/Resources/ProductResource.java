package com.imGoingProject.imGoing.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imGoingProject.imGoing.entities.Product;
import com.imGoingProject.imGoing.services.ProductService;

@RestController
//user é o caminho para a requisição
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	//metodo para pegar um dado
	@GetMapping
	//findall para pegar todos
	public ResponseEntity<List<Product>> findAll(){
		//criando um objeto com dados
	List<Product> list = service.findAll();
		//retornar o objeto
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
