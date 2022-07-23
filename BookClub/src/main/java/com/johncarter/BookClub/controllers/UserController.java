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
	public String reg(@Valid @ModelAttribute("nUser") User nUser, BindingResult r, Model m, HttpSession s) {
		//Todo --call a reg method in the service 
		//extra validations and create a user
		User user = urepo.reg(nUser, r);
		if(r.hasErrors()) {
			m.addAttribute("nLog", new RegisterLogin());
			return "logreg.jsp";
		}

		//store Id of user, log them in
		s.setAttribute("userId", user.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/log")
	public String login(@Valid @ModelAttribute("nLog") RegisterLogin nLog, BindingResult r, Model m, HttpSession s) {
		//once service impl
		User user = urepo.login(nLog, r);
		
		if(r.hasErrors()) {
			m.addAttribute("nUser", new User());
			return "dashboard.jsp";
		}
		
		s.setAttribute("userId", user.getId());
		return "redirect:/home";
	}
}
