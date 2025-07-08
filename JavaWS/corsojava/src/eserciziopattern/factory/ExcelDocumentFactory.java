package eserciziopattern.factory;

import eserciziopattern.document.Document;
import eserciziopattern.document.ExcelDocument;

public class ExcelDocumentFactory extends DocumentFactory {

	@Override
	public Document createDocument(String nome, double size) {
		return new ExcelDocument(nome,size);
		
		
	}

}
