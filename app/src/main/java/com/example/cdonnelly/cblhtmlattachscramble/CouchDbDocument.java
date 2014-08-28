package com.example.cdonnelly.cblhtmlattachscramble;

import com.couchbase.lite.Document;

public class CouchDbDocument {
	private Document document;
	
	// No args constructor in case we want to parse with Jackson, Gson etc
	public CouchDbDocument() {
		
	}
	
	public CouchDbDocument(Document doc) {
		document = doc;
	}
	
	public Document getDocument() {
		return document;
	}
	public void setDocument(Document document) {
		this.document = document;
	}
	
	public String getId(){
		return document.getId();
	}
	
}
