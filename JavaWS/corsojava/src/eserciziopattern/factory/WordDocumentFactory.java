package eserciziopattern.factory;

import eserciziopattern.document.Document;
import eserciziopattern.document.WordDocument;

public class WordDocumentFactory extends DocumentFactory {

	@Override
	public Document createDocument(String nome, double size) {
		return new WordDocument(nome,size);
		
		
	}

}
