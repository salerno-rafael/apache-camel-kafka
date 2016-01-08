package org.sample.route;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.sample.configuration.PropertyConfiguration;
import org.sample.processor.FailureProcessor;
import org.sample.processor.MessageProcessor;

public class CamelRoute {

	private MessageProcessor messageProcessor;

	private FailureProcessor failureProcessor;
	
	private PropertyConfiguration configuration;
	
	public CamelRoute(MessageProcessor messageProcessor, FailureProcessor failureProcessor, PropertyConfiguration configuration) {
		this.messageProcessor = messageProcessor;
		this.failureProcessor = failureProcessor;
		this.configuration = configuration;
	}

	public void start() throws Exception {
		CamelContext context = new DefaultCamelContext();
		context.addRoutes(new RouteBuilder() {
			public void configure() throws Exception {
				from(kafkaFrom())
				.doTry()
				.process(messageProcessor)
				.to(kafkaTo(configuration.getProperty("kafka.topic.out")))
				.doCatch(Exception.class)
				.process(failureProcessor)
				.to(kafkaTo(configuration.getProperty("kafka.topic.dead")))
				.end();
			}
		});
		context.start();
	}
	
	private String kafka(String topic) throws Exception{
		StringBuilder from = new StringBuilder();
		from.append("kafka:"+configuration.getProperty("kafka.url"));
		from.append(":"+configuration.getProperty("kafka.port"));
		from.append("?topic="+topic);
		from.append("&zookeeperHost="+configuration.getProperty("kafka.url"));
		from.append("&zookeeperPort="+configuration.getProperty("kafka.zookeper.port"));
		from.append("&groupId="+configuration.getProperty("kafka.groupId"));
		return from.toString();
	}

	private String kafkaFrom() throws Exception{
		return kafka(configuration.getProperty("kafka.topic.in"));
	} 
	
	private String kafkaTo(String topic) throws Exception{
		return kafka(topic)+"&serializerClass=kafka.serializer.StringEncoder";
	} 
}
