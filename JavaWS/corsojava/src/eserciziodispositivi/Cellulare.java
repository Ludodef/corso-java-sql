package eserciziodispositivi;

public class Cellulare extends Telefono  {

	private String sim;
	private String sistemaOperativo; 
	
	public Cellulare(boolean stato,String colore, String nome, boolean silenzioso, String tipo,String sim, String sistemaOperativo) {
		super(stato,colore, nome, silenzioso, tipo);
		this.sim = sim;
		this.sistemaOperativo = sistemaOperativo;
	}
	

	@Override
	public void mostraInfo() {
		
		super.mostraInfo();
		System.out.println("Sim -> " + sim +
							"\nSistema operativo -> " + sistemaOperativo);
	}

	@Override
	public void accendi() {
		
		super.accendi();
		System.out.println("");
    	System.out.println("[OPERAZIONE] Sto accendendo il cellulare...");
	}

	@Override
	public void spegni() {
	
		super.spegni();
		System.out.println("");
    	System.out.println("[OPERAZIONE] Sto spegnendo il cellulare...");
	}
	
	
	public String getSim() {
		return sim;
	}


	public void setSim(String sim) {
		this.sim = sim;
	}


	public String getSistemaOperativo() {
		return sistemaOperativo;
	}


	public void setSistemaOperativo(String sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}
	
	
	
	

}
