package com.corsojava.esercizi.restcallisto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book , Long>{
	
	List<Book> findByAuthor(String author);
	List<Book> findByTitle(String title);
}
