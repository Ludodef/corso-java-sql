package com.corsojava.jpademo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudenteController {
	
	

	private final StudenteService service; 

	StudenteController(StudenteService service) {
		
		this.service = service;
	}
	
	//@RequestMapping("/home")
	// @RequestMapping(value = "/home", method = RequestMethod.GET)
	@PostMapping("/home")
	public String metodoHome() {
		 
		
		return "Sono andato alla home!";
	}
	
	@GetMapping("/studente/list")
	public List<Studente> list(String cognome ) {
		if (cognome != null) {
			return service.getStudenteCognome(cognome);
		}
	 
		return service.getStudenteList();
	}
	
	@GetMapping("/studente/get")
	public Studente get(@RequestParam(value="id", required = true)   Long id ) {
		 
			return service.getStudente(id);		
	}
	
	

	@GetMapping("/studente/add")
	public Studente add(String name, Integer eta) {
				
		Studente stud = new Studente( name, eta);
		 
		//Studente service.addStudente(stud);		
		
		return service.addStudente(stud);
	}
	@PostMapping("/studente/add")
	public Studente add(@RequestBody Studente stud) {
				
		// Studente stud = new Studente( name, eta);
		 
		return service.addStudente(stud);		
	} 

}
