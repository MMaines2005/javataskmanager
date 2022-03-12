package com.michael.greatideas.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	// Class Attributes
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	@Size(min=8)
	private String password;
	
	@Transient
	@NotBlank
	private String confirmPassword;
	
	@OneToMany(mappedBy="creator",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Idea> ideaCreated;

	public User() {
	
	}

	public Long getId() {
		return id;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public List<Idea> getIdeaCreated() {
		return ideaCreated;
	}

	public void setIdeaCreated(List<Idea> ideaCreated) {
		this.ideaCreated = ideaCreated;
	}
	
	

	
	
}
