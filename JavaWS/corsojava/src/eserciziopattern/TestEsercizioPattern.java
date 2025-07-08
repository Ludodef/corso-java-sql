package eserciziopattern;


import eserciziopattern.factory.DocumentFactory;
import eserciziopattern.handler.DocumentHandler;
import eserciziopattern.handler.DocumentHandlerFactory;


public class TestEsercizioPattern {

	public static void main(String[] args) {
		
		System.out.println("----- Creazione storage ----");
		
		DocumentHandler local = DocumentHandlerFactory.createDocument("local");
		 
		DocumentHandler cloud = DocumentHandlerFactory.createDocument("cloud");
		
		System.out.println("---- Creazione e salvataggio documenti ----");
		
		cloud.saveDocument(DocumentFactory.createDocument("word.docx"));
		local.saveDocument(DocumentFactory.createDocument("pdf.pdf"));
		
		System.out.println("---- Apertura documento ----");
		
		cloud.openDocument("word.docx");
		
	
	}

}
