package org.sample.business;

public class ParserBusinessGeneric extends ParserBase {
	@Override
	public Double getDoubleValueFromLog(String value) {
		try {
			return Double.parseDouble(value);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String getStringValueFromLog(String value) {
		return value;
	}
}
