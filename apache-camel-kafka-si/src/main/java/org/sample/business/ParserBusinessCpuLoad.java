package org.sample.business;

public class ParserBusinessCpuLoad extends ParserBase {

	@Override
	public Double getDoubleValueFromLog(String value) {
		try {
			value = value.replace(",", ".");
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
