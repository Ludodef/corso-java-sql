package com.corsojava.restdemo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudenteRepository extends JpaRepository<Studente, Long> {
	List<Studente> findByCognome( String cognome); 
} 
