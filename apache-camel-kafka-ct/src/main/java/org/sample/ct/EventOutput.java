package org.sample.ct;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class EventOutput {

	private String status;
	private String name;
	private String monitor;
	private String value;
	private Double doubleValue;
	private String monitorType;
	private String date;

	public EventOutput() {
	}

	public EventOutput(String status, String name, String monitor, String value, Double doubleValue, String monitorType,
			String date) {
		this.status = status;
		this.name = name;
		this.monitor = monitor;
		this.value = value;
		this.doubleValue = doubleValue;
		this.monitorType = monitorType;
		this.date = date;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper().setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String json = "";
		try {
			json = ow.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
}
