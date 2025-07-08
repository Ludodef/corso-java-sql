package eserciziopattern.factory;

import eserciziopattern.document.Document;

public abstract class DocumentFactory {
	
	public abstract Document createDocument(String nome, double size);
	 
	public static Document createDocument(String nome) {
		return switch(nome.substring(nome.indexOf('.'))) {
			case ".xlsx" -> new ExcelDocumentFactory().createDocument(nome,0);
			case ".pdf" -> new PdfDocumentFactory().createDocument(nome,0);
			case ".docx" -> new WordDocumentFactory().createDocument(nome,0);
			default -> null; 
		};
	}
	

	 
	 

}
