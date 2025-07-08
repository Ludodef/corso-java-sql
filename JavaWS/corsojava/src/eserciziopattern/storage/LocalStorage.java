package eserciziopattern.storage;

import java.util.ArrayList;
import java.util.List;

import eserciziopattern.document.Document;

public class LocalStorage implements Storage {
	
	List<Document> local = new ArrayList<>();

	@Override
	public void store(Document doc) {
		local.add(doc);
		
	}

	@Override
	public Document retrieve(String docName) {
		for(Document e:local) {
			if(e.getNome().equals(docName)) {
				return e;
			}
		};
		return null;
		
		
	}

}
