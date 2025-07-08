package eserciziopattern.handler;

import eserciziopattern.document.Document;
import eserciziopattern.storage.Storage;

public class DocumentHandlerImpl extends DocumentHandler {

	public DocumentHandlerImpl(Storage storage) {
		super(storage);
		
	}

	@Override
	public void saveDocument(Document doc) {
		storage.store(doc);
		
	}

	@Override
	public void openDocument(String docName) {
		System.out.println(storage.retrieve(docName));
		
	}

}
