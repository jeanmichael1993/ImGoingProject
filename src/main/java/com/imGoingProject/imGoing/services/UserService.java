package com.imGoingProject.imGoing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imGoingProject.imGoing.Repositories.UserRepository;
import com.imGoingProject.imGoing.entities.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findbyId(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void deleted(Long id) {
		repository.deleteById(id);
	}
}
