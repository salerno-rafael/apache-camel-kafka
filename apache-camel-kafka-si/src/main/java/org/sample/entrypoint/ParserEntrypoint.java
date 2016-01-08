package org.sample.entrypoint;

import org.sample.business.ParserBusiness;
import org.sample.ct.EventOutput;
import org.sample.ct.ParserService;
import org.sample.model.EventModel;

public class ParserEntrypoint implements ParserService{
	
	private ParserBusiness business;
	
	public ParserEntrypoint(ParserBusiness business) {
		super();
		this.business = business;
	}

	@Override
	public EventOutput parseLog(String message) {
		EventModel event = business.parseLog(message);
		return new EventOutput(event.getStatus(), event.getName(), event.getAction(), event.getValue(), event.getDoubleValue(), event.getMonitor(), event.getDate());
	}

}
