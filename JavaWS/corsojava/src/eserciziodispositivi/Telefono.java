package eserciziodispositivi;

public class Telefono extends DispositivoElettronico{
	
	private String nome;
	private boolean silenzioso;
	private String tipo;
	
	
	public Telefono(boolean stato, String colore ,String nome, boolean silenzioso , String tipo) {
		super(stato, colore);
		this.nome = nome;
		this.silenzioso = silenzioso;
		this.tipo = tipo;
	}
	
	

	@Override
	public void mostraInfo() {
		
		super.mostraInfo();
		System.out.println("Marca -> " + nome +
							"\nModalita' -> " + ((silenzioso)? "Silenzioso" :"Suoneria")  + 
							"\nMarca -> " + tipo);
	}

}
