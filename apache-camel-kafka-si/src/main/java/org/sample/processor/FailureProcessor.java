package org.sample.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.log4j.Logger;

public class FailureProcessor implements Processor {

	private static Logger logger = Logger.getLogger(FailureProcessor.class);

	@Override
	public void process(Exchange exchange) throws Exception {
		Exception cause = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);
		logger.error("Tratando erros");
		if (cause.getMessage() != null) {
			logger.error(cause.getMessage() + "\n");
			exchange.getOut().setBody(cause.getMessage());
		} else if (exchange.getIn().getBody(String.class) != null) {
			logger.error(exchange.getIn().getBody(String.class));
			exchange.getOut().setBody(exchange.getIn().getBody(String.class));
		} else {
			logger.error(exchange.getIn().getBody(String.class));
			exchange.getOut().setBody(exchange.getIn().getBody(String.class));
		}
	}
}