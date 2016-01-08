package org.sample;


import org.sample.business.ParserBusiness;
import org.sample.configuration.PropertyConfiguration;
import org.sample.entrypoint.ParserEntrypoint;
import org.sample.processor.FailureProcessor;
import org.sample.processor.MessageProcessor;
import org.sample.route.CamelRoute;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ParserModule {

	@Bean
	public CamelRoute route() {
		return new CamelRoute(
				new MessageProcessor(new ParserEntrypoint(new ParserBusiness())),
				new FailureProcessor(),
				new PropertyConfiguration());
	}
	
}
