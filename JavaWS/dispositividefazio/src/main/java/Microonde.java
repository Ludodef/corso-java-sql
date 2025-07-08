

public class Microonde extends DispositivoElettronico {
	 
	private String nome;
	private boolean pieno;
	
	public Microonde(boolean stato,String colore, String nome, boolean pieno) {
		super(stato,colore);
		this.nome = nome;
		this.pieno = pieno;
	}



	@Override
	public void accendi() {
		
		super.accendi();
		System.out.println("[OPERAZIONE] Sto accendendo il microonde "+ nome + "...");
	}



	@Override
	public void spegni() {
		
		super.spegni();
		System.out.println("[OPERAZIONE] Sto spegnendo il microonde "+ nome + "...");
	}



	@Override
	public void mostraInfo() {
	
		super.mostraInfo();
		System.out.println("Marca -> " + nome +
							"\nPieno -> " + ((pieno)? "Si" :"No"));
	}
	
	

}
