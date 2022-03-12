package com.michael.greatideas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.michael.greatideas.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	// grabs all users from database
	List<User> findAll();
	
	//Grabs one user by email
	Optional <User> findByEmail(String email);
}
