package eserciziodispositivi;

public class TestDispositivo {

	public static void main(String[] args) {
		Cellulare cellulare1 = new Cellulare(false,"Rosso", "Samsung", true, "Cellulare","Wind", "Android");
		cellulare1.mostraInfo();
		cellulare1.accendi();
		System.out.println("\n ------- Cambio stato -------\n");
		cellulare1.mostraInfo();
		 
		System.out.println("\n ---------- Cambio dispositivo ----------\n");
		
		Fisso fisso1 = new Fisso(false,"Nero","Telecom",false, "Cavo", "ADSL","Rullo", "Acciaio");
		fisso1.mostraInfo();
		fisso1.accendi();
		System.out.println("\n ------- Cambio stato -------\n");
		fisso1.mostraInfo();
		
		System.out.println("\n ---------- Cambio dispositivo ----------\n");
		
		Televisore televisore1 = new Televisore(true, "Grigio" , "LG", 1000 , 20);
		televisore1.mostraInfo();
		televisore1.spegni();
		System.out.println("\n ------- Cambio stato -------\n");
		televisore1.mostraInfo();
		
		System.out.println("\n ---------- Cambio dispositivo ----------\n");
		
		Microonde microonde1 = new Microonde(false,"Bianco", "Samsung", true);
		microonde1.mostraInfo();
		microonde1.accendi();
		System.out.println("\n ------- Cambio stato -------\n");
		microonde1.mostraInfo();
		microonde1.mostraInfo(true,"giallo");
		
	}

	
}
