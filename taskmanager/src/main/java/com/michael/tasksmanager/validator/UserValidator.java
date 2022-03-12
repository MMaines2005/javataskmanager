package com.michael.tasksmanager.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.michael.tasksmanager.models.User;

@Component

public class UserValidator implements Validator {

	@Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    
    // 2
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getConfirmpassword().equals(user.getPassword())) {
            // 3
            errors.rejectValue("password", "Match", "Passwords Don't match!!!");
        }         
    }

	
}
