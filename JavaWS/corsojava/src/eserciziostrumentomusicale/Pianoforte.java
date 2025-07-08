package eserciziostrumentomusicale;

public class Pianoforte extends StrumentoMusicale {
	public Pianoforte() {
		super("pianoforte" , "a corde");
	}

	  @Override
	    public void suona() {
	        System.out.println(getNome() + " - Esecuzione di un arpeggio.");
	    }
	  
	  @Override
	    public void suonaPerformance() {
	        System.out.println("Sta suonando il pianoforte:");
	        accorda();
	        impostaVolume(10);
	        suona();
	    }
}
