package com.imGoingProject.imGoing.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imGoingProject.imGoing.entities.Category;
import com.imGoingProject.imGoing.services.CategoryService;

@RestController
//user é o caminho para a requisição
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	//metodo para pegar um dado
	@GetMapping
	//findall para pegar todos
	public ResponseEntity<List<Category>> findAll(){
		//criando um objeto com dados
	List<Category> list = service.findAll();
		//retornar o objeto
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id){
		Category obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
