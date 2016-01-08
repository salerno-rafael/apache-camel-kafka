package org.sample.model;

public class EventModel {

	private String status;
	private String name;
	private String action;
	private String value;
	private Double doubleValue;
	private String monitor;
	private String date;
	
	public EventModel() {
	}

	public EventModel(String status, String name, String action, String value, Double doubleValue, String monitor, String date) {
		this.status = status;
		this.name = name;
		this.action = action;
		this.value = value;
		this.doubleValue = doubleValue;
		this.monitor = monitor;
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(Double doubleValue) {
		this.doubleValue = doubleValue;
	}
	
	public String getMonitor() {
		return monitor;
	}

	public void setMonitor(String monitor) {
		this.monitor = monitor;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}


