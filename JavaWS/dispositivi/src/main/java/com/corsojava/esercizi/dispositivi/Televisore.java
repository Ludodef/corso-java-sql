package com.corsojava.esercizi.dispositivi;

public class Televisore extends DispositivoElettronico{
	 
	private String nome;
	private int numeroCanali;
	private int volume;
	
	public Televisore(boolean stato, String colore , String nome, int numeroCanali , int volume ) {
		super(stato,colore);
		this.nome= nome;
		this.numeroCanali = numeroCanali;
		this.volume = volume;
	}
	
	

	@Override
	public void accendi() {
		
		super.accendi();
		
	}



	@Override
	public void spegni() {
		
		super.spegni();
	}



	@Override
	public void mostraInfo() {
		super.mostraInfo();
		System.out.println("Marca -> " + nome +
							"\nCanali -> " +numeroCanali + 
							"\nVolume -> " +volume);
	}

}
