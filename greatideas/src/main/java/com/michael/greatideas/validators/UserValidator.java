package com.michael.greatideas.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.michael.greatideas.models.User;

@Component
public class UserValidator {
	
	public Boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if (!user.getConfirmPassword().equals(user.getPassword())) {
			
			errors.rejectValue("confirmPassword", "Match Error", "Passwords do not Match!");
		}
	}
	
}
