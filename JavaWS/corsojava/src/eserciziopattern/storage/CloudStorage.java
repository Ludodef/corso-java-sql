package eserciziopattern.storage;

import java.util.ArrayList;
import java.util.List;

import eserciziopattern.document.Document;

public class CloudStorage implements Storage {
	
	List<Document> cloud = new ArrayList<>();

	@Override
	public void store(Document doc) {
		cloud.add(doc);
		
	}

	@Override
	public Document retrieve(String docName) {
		for(Document e:cloud) {
			if(e.getNome().equals(docName)) {
				return e;
			}
		};
		return null;
		
		
	}

}
