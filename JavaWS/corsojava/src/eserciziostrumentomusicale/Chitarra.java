package eserciziostrumentomusicale;

public class Chitarra extends StrumentoMusicale {
 
	public Chitarra() {
		super("chitarra", "a corde");
	}
	 @Override
	    public void suona() {
	        System.out.println(getNome() + " - Strumming della chitarra.");
	    }

	  @Override
	    public void suonaPerformance() {
	        System.out.println("Sta suonando la chitarra:");
	        accorda();
	        impostaVolume(10);
	        suona();
	    }

}
