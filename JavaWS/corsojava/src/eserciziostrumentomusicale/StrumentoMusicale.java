package eserciziostrumentomusicale;

public class StrumentoMusicale {
	private String nome;
	private String tipo;
	private int volume;
	
	

	public StrumentoMusicale(String nome, String tipo){
		super();
		this.nome = nome;
		this.tipo = tipo;
		this.volume = 3;
	}
	
	//getter e setter
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}

	
	//metodi
	
	public void accorda() {
		System.out.println(nome + " e' stato accordato");
	}
	
	public void suona() {
		System.out.println(nome + "sta suonando");
	}
	
	public void impostaVolume(int livello) {
		this.volume = livello;
		System.out.println("Il volume di " + nome + " ha valore " + volume);
	}
	
	public void suonaPerformance() {
		accorda();
		suona();
		impostaVolume(volume);
	}
}
