package com.johncarter.BookClub.controllers;

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

import com.johncarter.BookClub.models.Book;
import com.johncarter.BookClub.models.RegisterLogin;
import com.johncarter.BookClub.models.User;
import com.johncarter.BookClub.services.*;

@Controller
public class BookController {

	@Autowired
	private UserService urepo;

	@Autowired
	private BookService brepo;

	@GetMapping("/dashboard")
	public String dash(Model m, HttpSession s) {

		//if the user is not in session return to login page
		if(s.getAttribute("userId") == null) {
			return "redirect:/";
		}

		m.addAttribute("books", books.all());
		m.addAttribute("user", users.findById(Long)s.getAttribute("userId")));
	}
	 
}
