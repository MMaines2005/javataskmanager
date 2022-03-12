package com.michael.greatideas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.michael.greatideas.models.User;
import com.michael.greatideas.services.AllService;
import com.michael.greatideas.validators.UserValidator;

@Controller
public class LogAndRegController {
	
	// Attributes
	
	@Autowired
	private AllService allService;
	
	@Autowired
	private UserValidator userValidator;
	
	
	// Register and Login Requests
	
	@GetMapping("/")
	public String ideaIndex(@ModelAttribute("user")User user, @ModelAttribute("error") String error, Model model) {
		return "index.jsp";
	}
	
	// Post Request for registering a new user
	
	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session, Model model) {
		
		userValidator.validate(user, result);
	if(result.hasErrors()) {
		return "index.jsp";
	}else {
		 User newUser = this.allService.registerUser(user);
		 session.setAttribute("user_id", newUser.getId());
		 return "redirect:/ideas";
	}
	
	}
	
	// Post Request for logging in a user
	
	@PostMapping("/login")
	public String loginUser(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			RedirectAttributes redirect, HttpSession session) {
		
		//if user is authenticated, save user is in session
		if(this.allService.authenticateUser(email, password)) {
			User loggedInUser = this.allService.getUserByEmail(email);
			session.setAttribute("user_id", loggedInUser.getId());
			return "redirect:/ideas";
		}
		else {
			redirect.addFlashAttribute("error", "Invalid credentials. Please try again.");
			return "redirect:/";
		}
	}
	
	// Log out
	
	@GetMapping("/logout")
	public String logoutUser(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}


}
