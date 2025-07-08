package eserciziodispositivi;

public class Fisso extends Telefono {

	private String linea;
	private String tastiera;
	private String materiale;
	
	public Fisso(boolean stato,String colore, String nome, boolean silenzioso, String tipo, String linea,String tastiera, String materiale) {
		super(stato,colore ,nome,silenzioso, tipo);
		this.linea = linea;
		this.tastiera = tastiera;
		this.materiale = materiale;
	}

	@Override
	public void accendi() {
		
		super.accendi();
		System.out.println("");
    	System.out.println("[OPERAZIONE] Sto accendendo il telefono fisso...");
	}

	@Override
	public void spegni() {
	
		super.spegni();
		System.out.println("");
    	System.out.println("[OPERAZIONE] Sto spegnendo il telefono fisso...");
	}

	@Override
	public void mostraInfo() {
		
		super.mostraInfo();
		System.out.println("Linea -> " + linea +
							"\nTastiera -> " + tastiera +
							"\nMateriale -> " + materiale);
	}

	

}
