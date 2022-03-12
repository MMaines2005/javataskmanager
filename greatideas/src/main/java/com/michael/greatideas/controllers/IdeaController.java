package com.michael.greatideas.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.michael.greatideas.models.Idea;
import com.michael.greatideas.models.User;
import com.michael.greatideas.services.AllService;

@Controller
public class IdeaController {
	
	// Attributes
	
	@Autowired
	private AllService allService;
	
	
	// Dashboard Request
	
	@GetMapping("/ideas")
	public String showIdeasDashboard(Model model, HttpSession session) {
		
		// if no attribute "user_id" in session then redirect to index.jsp
		Long userId = (Long) session.getAttribute("user_id");
		if (userId == null) {
			return "redirect:/";
		}
		
		// Else render the page and pass Attributes
		else {
			
			User currentUser = this.allService.getUserById(userId);
			List <Idea> allIdeas = this.allService.getAllIdeas();
			model.addAttribute("user", currentUser);
			model.addAttribute("ideas", allIdeas);
			return "showIdea.jsp";
		}
	}
	
	// Idea Request
	
	// Get Request to present newIdea page
	@GetMapping("/ideas/new")
	public String showIdeaCreateForm(@ModelAttribute("idea") Idea idea, Model model, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("user_id");
		
		// if there is no attribute "user_id" in session, redirect to index.jsp
		if (userId == null) {
			return "redirect:/";
		}
		else {
			User currentUser = this.allService.getUserById(userId);
			model.addAttribute("user",currentUser);
			return "newIdea.jsp";
		}
		
	}
	
	// Post Request for adding a new idea
	@PostMapping("/ideas/new")
	public String createIdea(@Valid @ModelAttribute("idea")Idea idea, BindingResult result,Model model, HttpSession session) {
		
		if(result.hasErrors()) {
			
			Long userId = (Long) session.getAttribute("user_id");
			User currentUser = allService.getUserById(userId);
			model.addAttribute("user",currentUser);
			return "newIdea.jsp";
		}
		else {
			allService.createIdea(idea);
			return "redirect:/ideas";
		}
	}
	
	// Get Request for showing details of the Idea
	@GetMapping("/ideas/{id}")
	public String showIdeaDetail(@ModelAttribute("error") String error,@PathVariable("id") Long id, Model model, HttpSession session) {
		
		
		Long userId = (Long) session.getAttribute("user_id");
		Idea ideaSelected = this.allService.getIdeaById(id);
		
		if(userId == null) {
			return "redirect:/";
		}
		else if(ideaSelected == null) {
			return "redirect:/ideas";
		}
		else {
			User currentUser = allService.getUserById(userId);
			
			model.addAttribute("user",currentUser);
			model.addAttribute("idea",ideaSelected);
			model.addAttribute("error",error);
			return "detailIdea.jsp";
		}
	}
	
	// Get Request for showing edit
	@GetMapping("/ideas/{id}/edit")
	public String editIdea(@ModelAttribute("idea") Idea idea, @PathVariable("id") Long id, Model model, HttpSession session) {
		
		
		Long userId = (Long) session.getAttribute("user_id");
		Idea ideaSelected = this.allService.getIdeaById(id);
		
		// Check if userId is null. If it is then redirect to login page
		if(userId == null) {
			return "redirect:/";
		}
		
		
		// Else show the editTvShow page
		else {
			User currentUser = this.allService.getUserById(userId);
			model.addAttribute("user",currentUser);
			model.addAttribute("idea",ideaSelected);
			return "editIdea.jsp";
		}
    }
	// PUT Request for showing updating fields of given event
		@PutMapping("/ideas/{id}/edit")
	    public String editTvShow(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, @PathVariable("id") Long id, Model model, HttpSession session) {
					
			if(result.hasErrors()) {
				
				Long userId = (Long) session.getAttribute("user_id");
				User currentUser = this.allService.getUserById(userId);
				Idea ideaSelected = this.allService.getIdeaById(id);
				String error = "Error: Fields must not be empty!";
							
				model.addAttribute("user",currentUser);
				model.addAttribute("shideaow",ideaSelected);
				model.addAttribute("error", error);
				
		        return "editIdea.jsp";
			}
			
			else {
				this.allService.editIdea(idea);
				return "redirect:/ideas";
			}
			
	    }
		
		// GET Request for deleting a TV show
		@GetMapping("/ideas/{id}/delete")
	    public String deleteShow(@PathVariable("id") Long id) {
	        this.allService.deleteIdeaById(id);
	        return "redirect:/ideas";
	    }
}


