package org.sample.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;
import org.sample.ct.EventOutput;
import org.sample.entrypoint.ParserEntrypoint;

public class MessageProcessor  implements Processor{

	private static Logger logger = Logger.getLogger(MessageProcessor.class);
	
	private ParserEntrypoint entrypoint;
	
	public MessageProcessor(ParserEntrypoint entrypoint) {
		super();
		this.entrypoint = entrypoint;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		logger.info(exchange.getIn().getBody(String.class));
		EventOutput output = entrypoint.parseLog(exchange.getIn().getBody(String.class));
		exchange.getOut().setBody(output.toString());
	}

}
