package com.bankingApplication.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankingApplication.entities.CurrentAccount;
import com.bankingApplication.entities.SavingsAccount;
import com.bankingApplication.entities.User;
import com.bankingApplication.service.UserService;

@Controller
@RequestMapping("/account")
public class UserAccountController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/savingsAccount")
	public String savingsAccount(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		SavingsAccount savingsAccount = user.getSavingsAccount();
		
		model.addAttribute("savingsAccount", savingsAccount);
		
		return "savingsAccount";
	}
	
	@RequestMapping("/currentAccount")
	public String currentAccount(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		CurrentAccount currentAccount = user.getCurrentAccount();
		
		model.addAttribute("currentAccount", currentAccount);
		
		return "currentAccount";
	}

}
