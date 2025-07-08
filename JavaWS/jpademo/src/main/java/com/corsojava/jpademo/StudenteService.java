package com.corsojava.jpademo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class StudenteService {
	

	private final StudenteRepository rep; 

	StudenteService(StudenteRepository rep) {
		
		this.rep = rep;
	}
	
	

	public List<Studente> getStudenteList() {
		 
		return rep.findAll();
	} 
	
	public Studente getStudente(Long id) {
		 
		return rep.findById(id).orElse(null);
	} 
	
	

	public List<Studente> getStudenteCognome(String cognome) {
		 
		return rep.findByCognome(cognome);
	} 
	 
	public Studente addStudente(Studente s) {
		s.setId(null);
		return rep.save(s);
	} 
 
	
 
}
