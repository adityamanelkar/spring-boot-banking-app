package com.bankingApplication.controller; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.stereotype.Controller;

import com.bankingApplication.entities.User;
import com.bankingApplication.service.UserService;

//@Controller
@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class BasicController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public void home() {
		// return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void login() {
		// return login;
	}
	
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public void signup(Model model) {
		
		User user = new User();
		model.addAttribute("user", user);
		// return "signup";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public void signupPost(@ModelAttribute("user") User user, Model model) {
		
		if(userService.checkUserExists(user.getUsername(), user.getEmail())) {
			
			if(userService.checkEmailExists(user.getEmail())) {
				model.addAttribute("emailExists", true);
			}
			
			if(userService.checkUsernameExists(user.getUsername())) {
				model.addAttribute("usernameExists", true);
			}
			
			// return "signup";
		}
		
		else {
			userService.save(user);
			
			// return "redirect:/login";
		}
	}
}