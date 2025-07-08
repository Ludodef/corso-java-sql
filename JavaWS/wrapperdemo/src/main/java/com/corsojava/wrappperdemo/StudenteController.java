package com.corsojava.wrappperdemo;

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
	public ResponseEntity<DataWrapper<List<Studente>>> list(String cognome ) {
		if (cognome != null) {
			return DataWrapper.success(DataWrapper.SUCCESS_GET, "GET", service.getStudenteCognome(cognome));		
		} 
		return DataWrapper.success(DataWrapper.SUCCESS_GET, "GET", service.getStudenteList()); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DataWrapper<Studente>> get(@PathVariable Long id ) {
		 
			Studente s = service.getStudente(id);
			
			if (s==null) {
				return DataWrapper.error(DataWrapper.ERROR_NOT_FOUND, "GET", "Non è stato possibile recuperare la risorsa");
			}
			
					
			return DataWrapper.success(DataWrapper.SUCCESS_GET, "GET",  s ); 
			// oppure ResponseEntity.ok(s);
			
	}
  
/*
	 
	@PostMapping("/bulk")
	public List<Studente> add(@RequestBody List<Studente> studs) {
				 
		 
		return service.addBulkStudente(studs);		
	}
*/	
	
	 
	@PostMapping("/")
	public  ResponseEntity<DataWrapper<Studente>> add(@RequestBody Studente stud) {
				 
		
		return DataWrapper.success(DataWrapper.SUCCESS_POST, "POST",  service.addStudente(stud) ); 
	}
	
	@PutMapping("/{id}")
 
	public ResponseEntity<DataWrapper<Studente>>  mod(@PathVariable Long id, @RequestBody Studente stud) { 
		 
		Studente s = service.modStudente(id, stud);	
		if (s==null) {
			return DataWrapper.error(DataWrapper.ERROR_NOT_FOUND, "PUT", "Non è stato possibile modificare la risorsa");
		}
		
		return DataWrapper.success(DataWrapper.SUCCESS_PUT, "PUT",  s ); 
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<DataWrapper<Studente>>  del(@PathVariable Long id) {
				
		// ritorna la risorsa eliminata oppure null 
		
		
		Studente s = service.delStudente(id);	
		
		if (s==null) {
			return DataWrapper.error(DataWrapper.ERROR_NOT_FOUND, "DELETE", "Non è stato possibile eliminare la risorsa");
		}
		
		return   DataWrapper.success(DataWrapper.SUCCESS_DELETE, "DELETE",  s ); 		
	} 
	
	
	
	

}
