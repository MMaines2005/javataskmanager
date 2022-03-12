package com.michael.tasksmanager.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.michael.tasksmanager.models.Task;
import com.michael.tasksmanager.models.User;
import com.michael.tasksmanager.services.AllService;
import com.michael.tasksmanager.validator.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private AllService aService;
	@Autowired
	private UserValidator uValid;
	
	@GetMapping("/")
	public String startpage(@ModelAttribute("user") User user) {
		return "homepage.jsp";
	}
	
	    
	    @RequestMapping(value="/registration", method=RequestMethod.POST)
	    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	    	uValid.validate(user, result);
	    	if(result.hasErrors()) {
	    		return "homepage.jsp";
	    	}
	    	User u = aService.createUser(user);
	    	session.setAttribute("userid", u.getId());
	    	return "redirect:/task";

	    }
	    
    
	    
	    @RequestMapping("/task")
	    public String home(HttpSession session, Model model, Task task) {
	        Long userId = (Long) session.getAttribute("userId");
	        User u = aService.getOneUser(userId);
	        model.addAttribute("user",u);
	        model.addAttribute("info",task);
	        return "showTask.jsp";
	    }
	    @RequestMapping("/logout")
	    public String logout(HttpSession session) {
	        session.invalidate();
	        return "redirect:/";
	    }
}

	


