package com.corsojava.wrappperdemo;

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
 
	
	public Studente delStudente(Long id) {
		
		Studente s = rep.findById(id).orElse(null);
		
		if (s != null) {
			rep.deleteById(id);
		}
		return  s;
	}
	

	
	public Studente modStudente(Long id, Studente stud) {
		
		if (! rep.existsById(id)) {
			return null;
		}
		
		stud.setId(id);
		rep.save(stud);
		return stud;
	}
	
 
}
