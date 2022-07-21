package com.johncarter.BookClub.controllers;

import com.johncarter.BookClub.models.RegisterLogin;
import com.johncarter.BookClub.models.User;
import com.johncarter.BookClub.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

	@Autowired
	private UserService urepo;
	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("nU", new User());
		m.addAttribute("nLog", new RegisterLogin());
		return "logreg.jsp";
	}
}

