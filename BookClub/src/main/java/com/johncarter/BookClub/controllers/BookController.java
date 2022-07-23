package com.johncarter.BookClub.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
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

	/*
	GetMapping for the App
	*/

	@GetMapping("/dashboard")
	public String dash(Model m, HttpSession s) {

		//if the user is not in session return to login page
		if(s.getAttribute("userId") == null) {
			return "redirect:/";
		}

		m.addAttribute("books", brepo.all());
		m.addAttribute("user", urepo.findById(Long)s.getAttribute("userId")));
		return "dashboard.jsp";
	}

	@GetMapping("/add/book")
	public String addBook(@ModelAttribute("book") Book b, Model m, HttpSession s) {

		User user = urepo.findById(Long)s.getAttribute("userId"));
		m.addAttribute("user", user);

		return "addBook.jsp";
	}


	@GetMapping("/books/edit/{id}")
	public String editBook(Model m, @PathVariable("id") Long id, HttpSession s) {

		if (s.getAttribute("userId") == null ) {
			return "redirect:/";
		}

		Book b = brepo.findById(id);
		m.addAttribute("book", b);

		return "editBook.jsp";
	}
	 
	@GetMapping("books/{id}")
	public String showBook(Model m, @PathVariable("id") Long id, HttpSession s) {

		if(s.getAttribute("userId") == null) {
			return "redirect:/";
		}

		Book b = brepo.findById(id);
		m.addAttribute("book", b);
		m.addAttribute("user", urepo.findById(Long)s.getAttribute("userId")));
		return "showBook.jsp";
	}

	@GetMapping("/logout")
	public String logout(HttpSession s) {
		s.invalidate();
		return "redirect:/";
	}

	/*
	POST and PUT mapps for the App
	*/

	@PostMapping("/books/create") 
	public String createBook(@Valid @ModelAttribute("book") Book b, BindingResult r) {

		if (r.hasErrors()) {
			return "addBook.jsp";
		}

		brepo.create(b);

		return "redirect:/dashboard";
	}

	@PutMapping("books/{id}")
	public String update(@Valid @ModelAttribute("book") Book b, BindingResult r, Model m) {
		
		if(r.hasErrors()) {
			return "editBook.jsp";
		}
		
		brepo.update(b);
		return "redirect:/dashboard";

	}

	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable("id") Long id) {
		brepo.delete(id);
		return "redirect/dashboard";
	}

}
