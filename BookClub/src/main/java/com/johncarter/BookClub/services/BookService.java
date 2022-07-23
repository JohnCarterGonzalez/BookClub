package com.johncarter.BookClub.services;

import java.util.List;
import java.util.Optional;

import com.johncarter.BookClub.models.Book;
import com.johncarter.BookClub.repositories.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	@Autowired
	private BookRepository brepo;

	public Book findById(Long id) {
		Optional<Book> result = brepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		return null;
	}

	public List<Book> all() {
		return brepo.findAll();
	}
	
	public Book update(Book b) {
		return brepo.save(b);
	}

	public Book create(Book b) {
		return brepo.save(b);
	}

	public void delete(Book b) {
		brepo.deleteById(b);
	}

}
