package com.imGoingProject.imGoing.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imGoingProject.imGoing.entities.User;
import com.imGoingProject.imGoing.services.UserService;

@RestController
//user é o caminho para a requisição
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	//metodo para pegar um dado
	@GetMapping
	//findall para pegar todos
	public ResponseEntity<List<User>> findAll(){
		//criando um objeto com dados
	List<User> list = service.findAll();
		//retornar o objeto
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User obj = service.findbyId(id);
		return ResponseEntity.ok().body(obj);
	}
	

}
