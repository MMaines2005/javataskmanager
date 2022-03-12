package com.michael.greatideas.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michael.greatideas.models.Idea;
import com.michael.greatideas.models.User;
import com.michael.greatideas.repositories.IdeaRepository;
import com.michael.greatideas.repositories.UserRepository;

@Service
public class AllService {
	
	// Attributes (Autowired)
	
	@Autowired
	private UserRepository uRepository;
	
	@Autowired
	private IdeaRepository iRepository;
	
	// Create Methods
	
	// Register a user
	
	public User registerUser(User user) {
		String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashedPassword);
		return this.uRepository.save(user);
	}
	
	// Create a idea
	
	public Idea createIdea(Idea idea) {
		return this.iRepository.save(idea);	
	}
	
	// Read Methods
	
	// Grabs a user by id
	
	public User getUserById(Long id) {
		return this.uRepository.findById(id).orElse(null);
	}
	
	// Grabs a user by email
	
	public User getUserByEmail(String email) {
		return this.uRepository.findByEmail(email).orElse(null);
	}
	
	// Grabs all ideas in database
	
	public List<Idea> getAllIdeas(){
		return this.iRepository.findAll();
	}
	
	// Grabs a idea by id
	
	public Idea getIdeaById(Long id) {
		return this.iRepository.findById(id).orElse(null);
	}
	
	// Update Methods
	
	// Edit a Idea
	
	public void editIdea(Idea idea) {
		this.iRepository.save(idea);
	}
	
	// Delete Method
	
	public void deleteIdeaById(Long id) {
		this.iRepository.deleteById(id);
	}
	
	
	// Authentication Method
	
	// authenticate user
	
	public boolean authenticateUser(String email, String password) {
		// Find user by email
		User user = this.getUserByEmail(email);
		// if we can't find user by email, return false
		if(user == null) {
			return false;
		}else {
			// if the passwords match, return true
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			}else {
				// if passwords don't return false
				return false;
			}
		}
	}

}
