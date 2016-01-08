package org.sample.business;

public class ParserBusinessCpuUtil extends ParserBase {

	private int DOUBLE_VALUE_COLUMN = 6;
	public ParserBusinessCpuUtil() {
		setDoubleValue(DOUBLE_VALUE_COLUMN);
	}
	
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
		try {
			String average = value.split(",")[0];
			return average;
		} catch (Exception e) {
			return value;
		}
	}

}
