package eserciziopattern.handler;


import eserciziopattern.storage.CloudStorage;
import eserciziopattern.storage.LocalStorage;


public class DocumentHandlerFactory {
	
	public static DocumentHandler createDocument(String type) {
		return switch(type.toLowerCase()) {
        case "local" -> new DocumentHandlerImpl( new LocalStorage());
        case "cloud" -> new DocumentHandlerImpl( new CloudStorage());
        default -> null;
    };
			
	}

}
