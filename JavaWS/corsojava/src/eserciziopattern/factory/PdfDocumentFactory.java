package eserciziopattern.factory;

import eserciziopattern.document.Document;
import eserciziopattern.document.PdfDocument;

public class PdfDocumentFactory extends DocumentFactory{

	@Override
	public Document createDocument(String nome, double size) {
		return new PdfDocument(nome,size);
	
		
	}

}
