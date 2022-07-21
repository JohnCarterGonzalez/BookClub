package com.johncarter.BookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.johncarter.BookClub.models.RegisterLogin;
import com.johncarter.BookClub.models.User;
import com.johncarter.BookClub.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
  
@Controller
public class UserController {
	@Autowired
	private UserService urepo;

	/*
	 * POST routes for App
	 */
	
	@PostMapping("/reg")
	public String reg(@Valid @ModelAttribute("nU") User nU, BindingResult r, Model m, HttpSession s) {
		//Todo --call a reg method in the service 
		//extra validations and create a user
		if(r.hasErrors()) {
			m.addAttribute("nLog", new RegisterLogin());
			return "logreg.jsp";
		}
		return "redirect:/home";
	}
	
	@PostMapping("/log")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser nL, BindingResult result, Model m, HttpSession s) {
		//once service impl
		// User u = uServ.login(newLogin, result);
		
		if(result.hasErrors()) {
			m.addAttribute("newUser", new User());
			return "dashboard.jsp";
		}
		return "redirect:/home";
	}
}
