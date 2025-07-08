package com.corsojava.wrappperdemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Studente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)   
	private Long id;
	private String nome;
	private String cognome;  
	private Integer eta; 
	
	private Boolean attivo; 
	  
	public Studente(Long id, String nome, Integer eta ) {
		this.id = id;
		this.nome = nome; 
		this.eta = eta;
	} 

	public Studente(  String nome, Integer eta ) {
		this.id = null;
		this.nome = nome; 
		this.eta = eta;
	} 
	
	
	// overload del costruttore
	public Studente() { 
		this.id = null;
		this.nome = null; 
		this.eta = -1; 
	}  
	
	public void mostraInfo() { 
		System.out.println(this.nome + ", " + this.eta); 
	}
 
	
	
	
	public String getNome() { 
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getEta() {
		return this.eta;
	}

	public void setEta(Integer eta) {
		this.eta = eta;
	}

	public Boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(Boolean attivo) {
		this.attivo = attivo;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
 
	
	
 }
