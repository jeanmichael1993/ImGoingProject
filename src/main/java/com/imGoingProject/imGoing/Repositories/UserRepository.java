package com.imGoingProject.imGoing.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imGoingProject.imGoing.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);

}
