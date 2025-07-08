package eserciziopattern.handler;

import eserciziopattern.document.Document;
import eserciziopattern.storage.Storage;

public abstract class DocumentHandler {
	protected Storage storage;
	
	
	
	public DocumentHandler(Storage storage) {
		super();
		this.storage = storage;
	}
	
	public abstract void saveDocument(Document doc);
	
	public abstract void openDocument(String docName);

	/*public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
	*/
	

}
