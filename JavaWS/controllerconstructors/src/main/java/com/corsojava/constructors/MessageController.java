package com.corsojava.constructors;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	private int id = 1;
	private List<Message> messaggi = new ArrayList<>();
	
	
	
	
	public MessageController() {
	
		messaggi.add(new Message(id++,"Benvenuto!"));
		
		
	}



	@GetMapping("/messages")
	public List<Message> getMessage(){
		return messaggi;
	}
	
	@PostMapping("/add-message")
	public Message addMessage() {
		
		Message nuovoMessaggio = new Message(id++,"Benvenuto! Inserisci messaggio");
		messaggi.add(nuovoMessaggio);
		return nuovoMessaggio;
	}
	

}
