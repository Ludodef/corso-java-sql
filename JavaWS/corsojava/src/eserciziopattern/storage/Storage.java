package eserciziopattern.storage;

import eserciziopattern.document.Document;

public interface Storage {
	void store(Document doc);
	Document retrieve (String docName);
}
