package com.michael.tasksmanager.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.Transient;
import javax.validation.constraints.Email;


@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Email
	private String email;
	@Size(min=8)
	private String password;
	@Transient
	private String confirmpassword;
	@Column(updatable=false)
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="user_task",
	joinColumns = @JoinColumn(name="user_id"),
	inverseJoinColumns = @JoinColumn(name="task_id"))
	private List<Task> task;
	public User() {
		
	}
		

	public Long getId() {
		return id;
	}

	


	public List<Task> getTask() {
		return task;
	}


	public void setTask(List<Task> task) {
		this.task = task;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}


	
	
	
	

}
