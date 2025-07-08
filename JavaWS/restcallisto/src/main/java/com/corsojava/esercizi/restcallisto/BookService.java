package com.corsojava.esercizi.restcallisto;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	private BookRepository br;
	
	
	
	
	BookService(BookRepository br) {
		
		this.br = br;
	}

	public List<Book> getAll() {
		return br.findAll();
	}
	
	public List<Book> getBookAuthor(String author) {
		return br.findByAuthor(author);
	}
	
	public List<Book> getBookTitle(String title) {
		return br.findByTitle(title);
	}
	
	public Book add(Book b) {
		return br.save(b);
	}
	
	public Book del(Long id) {
		
		Book b = br.findById(id).orElse(null);
		
		if(b != null) {
			br.delete(b);
		}
		
		return b;
	}
	
	public Book edit(Book b){
		
		if(br.findById(b.getId()).orElse(null) == null){
			return null;
		}
		
		return br.save(b); 
	}
}
