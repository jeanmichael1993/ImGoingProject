package com.imGoingProject.imGoing.Resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imGoingProject.imGoing.entities.User;

@RestController
//user é o caminho para a requisição
@RequestMapping(value = "/users")
public class UserResource {
	
	//metodo para pegar um dado
	@GetMapping
	//findall para pegar todos
	public ResponseEntity<User> findAll(){
		//criando um objeto com dados
		User u = new User(1L,"Maria","Maria@gmail.com","1234","123");
		//retornar o objeto
		return ResponseEntity.ok().body(u);
	}

}
