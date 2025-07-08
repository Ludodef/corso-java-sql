package com.corsojava.restdemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/studente")          //nome del servizio rest
public class StudenteController {
	
	

	private final StudenteService service; 

	StudenteController(StudenteService service) {
		
		this.service = service;
	}
	
	//@RequestMapping("/home")
	// @RequestMapping(value = "/home", method = RequestMethod.GET)
	
	/*
	
	@PostMapping("/home")   
	public String metodoHome() {
		 
		
		return "Sono andato alla home!";
	}
	

	@GetMapping("/{id}/esame/")
	
	@GetMapping("/{id}/esame/{id_esame}")
	
	public Esame getParam( Long id, Long idEsame ) {
		 
			return service.getStudenteEsame(id, idEsame);		
	}
	
	
	*/
	
	// -----------------------------------------------------------------
	// REST
	
	@GetMapping("/")
	public List<Studente> list(String cognome ) {
		if (cognome != null) {
			return service.getStudenteCognome(cognome);
		}
	 
		return service.getStudenteList();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Studente> get(@PathVariable Long id ) {
		 
			Studente s = service.getStudente(id);
			
			if (s==null) {
				return new ResponseEntity<Studente>(HttpStatus.NOT_FOUND);
			}
			
			return new ResponseEntity<Studente>(s, HttpStatus.OK);			
			// oppure ResponseEntity.ok(s);
			
	}
  
/*
	 
	@PostMapping("/bulk")
	public List<Studente> add(@RequestBody List<Studente> studs) {
				 
		 
		return service.addBulkStudente(studs);		
	}
*/	
	
	 
	@PostMapping("/")
	public  ResponseEntity<Studente> add(@RequestBody Studente stud) {
				
		// Studente stud = new Studente( name, eta);
		 
		
		stud = service.addStudente(stud);
		
		return new ResponseEntity<Studente>(stud, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
 
	public ResponseEntity<Studente> mod(@PathVariable Long id, @RequestBody Studente stud) {
				
		
		 
		Studente s = service.modStudente(id, stud);	
		if (s==null) {
			return new ResponseEntity<Studente>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Studente>(s, HttpStatus.OK);		
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Studente> del(@PathVariable Long id) {
				
		// ritorna la risorsa eliminata oppure null 
		
		
		Studente s = service.delStudente(id);	
		
		if (s==null) {
			return new ResponseEntity<Studente>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Studente>(s, HttpStatus.OK);			
	} 
	
	
	
	

}
