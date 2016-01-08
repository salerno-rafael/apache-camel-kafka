package org.sample.configuration;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class PropertyConfiguration {
	
	public String getProperty(String key) throws ConfigurationException {
		return new PropertiesConfiguration("kafka.properties").getProperty(key).toString();
	}
}
