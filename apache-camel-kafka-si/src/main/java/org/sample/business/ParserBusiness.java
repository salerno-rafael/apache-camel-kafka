package org.sample.business;

import org.sample.model.EventModel;

public class ParserBusiness {
	private LogIdentifier logIdentifier;
	
	public ParserBusiness() {
		this.logIdentifier = new LogIdentifier();
	}
	
	public EventModel parseLog(String message){
		return logIdentifier.Identify(message).parseLog(message);
	}
}
