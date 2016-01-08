package org.sample.business;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.ArrayUtils;
import org.sample.model.EventModel;

public abstract class ParserBase {
	private int STATUS = 1;
	private int NAME_AND_ACTION = 3;
	private int NAME = 0;
	private int ACTION = 1;
	private int MONITOR = 0;
	private int STRING_VALUE = 4;
	private int DOUBLE_VALUE = 7;
	private int DATE = 0;
	
	public void setStatus(int status) {
		this.STATUS = status;
	}
	
	public int getStatus() {
		return STATUS;
	}
	
	public void setNameAndAction(int nameAndAction) {
		this.NAME_AND_ACTION = nameAndAction;
	}
	
	public int getNameAndAction() {
		return NAME_AND_ACTION;
	}
	
	public void setName(int name) {
		this.NAME = name;
	}
	
	public int getName() {
		return NAME;
	}
	
	public void setStringValue(int value) {
		this.STRING_VALUE = value;
	}
	
	public int getStringValue() {
		return STRING_VALUE;
	}
	
	public void setDoubleValue(int value) {
		this.DOUBLE_VALUE = value;
	}
	
	public int getDoubleValue() {
		return DOUBLE_VALUE;
	}
	
	public List<String> getElements(String message) {
        List<String> elements = new ArrayList<String>();
        StringTokenizer tokenizer = new StringTokenizer(message, "\t");

        while (tokenizer.hasMoreElements()) elements.add(tokenizer.nextToken());

        return elements;
    }
	
	public String[] extractNameAndLabel(String message) {
		return message.split(":");
	}
	
	public String extractAction(String[] nameAndAction) {
		nameAndAction = (String[])ArrayUtils.removeElement(nameAndAction, nameAndAction[NAME]);
		return nameAndAction[ACTION];
	}
	
	public String extractMonitor(String[] nameAndAction) {
		nameAndAction = (String[])ArrayUtils.removeElement(nameAndAction, nameAndAction[NAME]);
		return nameAndAction[MONITOR];
	}
	
	public Boolean validateNameAndAction(String[] nameAndAction) {
		if (nameAndAction.length != 2 && nameAndAction.length != 3) return false;
		return true;
	}
	
	public Boolean validateMessage(List<String> elements) {
		return elements.size() >= 5;
	}
	
	public EventModel parseLog(String message){
		List<String> elements = getElements(message);
		String[] nameAndAction = extractNameAndLabel(elements.get(getNameAndAction()));
		
		if (validateMessage(elements) && validateNameAndAction(nameAndAction)) {
			
			return buildEventModel(elements, nameAndAction);
		}
		return null;
	}
	
	private EventModel buildEventModel(List<String> elements, String[] nameAndAction) {
		return new EventModel(elements.get(getStatus()), nameAndAction[getName()], extractAction(nameAndAction), 
				getStringValueFromLog(elements.get(getStringValue())), getDoubleValueFromLog(elements.get(getDoubleValue())), extractMonitor(nameAndAction), elements.get(DATE));
	}
	
	public abstract Double getDoubleValueFromLog(String value);
	public abstract String getStringValueFromLog(String value);
}
