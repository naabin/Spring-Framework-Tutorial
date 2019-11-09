package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;

@Controller
public class BookController {
	
	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	
	public BookController(BookRepository bookReposotory, AuthorRepository authorRepository) {
		this.bookRepository = bookReposotory;
		this.authorRepository = authorRepository;
	}

	@RequestMapping("/books")
	public String getBook(Model model) {
		
		model.addAttribute("books", this.bookRepository.findAll());
		
		return "books";
		
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", this.authorRepository.findAll());
		System.out.println("Authors----------" + authorRepository.findAll());
		return "authors";
	}
}
