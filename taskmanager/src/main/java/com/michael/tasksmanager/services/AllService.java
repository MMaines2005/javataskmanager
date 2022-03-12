package com.michael.tasksmanager.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.michael.tasksmanager.models.Task;
import com.michael.tasksmanager.models.User;
import com.michael.tasksmanager.repositories.TaskRepository;
import com.michael.tasksmanager.repositories.UserRepository;

@Service				
public class AllService {
	@Autowired
	private UserRepository uRepo;
	@Autowired
	private TaskRepository tRepo;
	
	public User createUser(User user) {
		return this.uRepo.save(user);
	}
	
	public Task createTask(Task task) {
		return this.tRepo.save(task);
	}
	
	public User getOneUser(Long id) {
		return this.uRepo.findById(id).orElse(null);
	}
	public List<Task> getAll(Long id) {
		return this.tRepo.findAll();
	}
	
	public Task getOneTask(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
		user.setPassword(hashed);
		return this.uRepo.save(user);
	}
//	public User findUserByEmail(String email) {
//		return this.uRepo.findByEmail(email);
//	}
//	
//	public boolean authUser(String email, String password) {
//		User user = this.uRepo.findByEmail(email);
//		if(user == null) {
//			return false;
//			
//		}else{
//			if(BCrypt.checkpw(password, user.getPassword())) {
//				return true;
//				
//			}else {
//				return false;
//			}
//		}
	}

