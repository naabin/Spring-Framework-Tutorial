package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import com.example.demo.model.Publisher;
import com.example.demo.repositories.AuthorRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
	
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;
	private PublisherRepository publisherRepository;
	
	public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}
	
	
	private void initData() {
		Publisher publisher = new Publisher("Apress", "Langley Virginai");
		publisherRepository.save(publisher);
		
		Author eric = new Author("Eric", "Evans");
		Book ddd = new Book("Domain Driven Design","1234",publisher);
		
		
		eric.getBooks().add(ddd);
		
		authorRepository.save(eric);
		bookRepository.save(ddd);
		
		

		
		
		Publisher publisher2 = new Publisher("Orielly", "New York");
		this.publisherRepository.save(publisher2);
		
		Author rod = new Author("Rod", "Johnson");
		Book noEJB = new Book("J2EE Development without EJB", "2344", publisher2);
		rod.getBooks().add(noEJB);
		
		authorRepository.save(rod);
		bookRepository.save(noEJB);
		
		
		noEJB.setPublisher(publisher2);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		initData();
	}

}
