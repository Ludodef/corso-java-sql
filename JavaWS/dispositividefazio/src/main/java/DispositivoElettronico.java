

public class DispositivoElettronico {
   
	private boolean stato;
	private String colore;
	
	public DispositivoElettronico(boolean stato, String colore) {
		this.stato = stato;
		this.colore = colore;
	}
    
    public void accendi() {
    	stato = true;
	    	//System.out.println("");
	    	//System.out.println("[OPERAZIONE] Sto accendendo il dispositivo...");
    	
    }
 
    public void spegni() {
    	stato = false;
	    	//System.out.println("");
	    	//System.out.println("[OPERAZIONE] Sto spegnendo il dispositivo...");
    }
 
    public void mostraInfo() {
    	mostraInfo(this.stato,this.colore);
    }
    	
    
    public void mostraInfo(boolean stato ,String colore) {
    	System.out.println("Stato -> " + ((stato)? "Acceso": "Spento") +
    						"\nColore -> " + colore);
    }


	public boolean isStato() {
		return stato;
	}

	
}
