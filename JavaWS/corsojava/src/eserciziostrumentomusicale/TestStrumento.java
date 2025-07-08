package eserciziostrumentomusicale;

public class TestStrumento {
	public static void main(String[] args) {
        Chitarra chitarra = new Chitarra();
        Pianoforte pianoforte = new Pianoforte();

        System.out.println("Questa e' la chitarra");
        chitarra.suonaPerformance();

        System.out.println("=============================");
        
        System.out.println("Questo e' il pianoforte");
        pianoforte.suonaPerformance();
    }
}
