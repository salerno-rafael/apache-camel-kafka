package org.sample.business;

public class LogIdentifier {
	public ParserBase Identify(String message) {
		return IsPing(message) ? new ParserBusinessPing()
				: IsCpuLoad(message) ? new ParserBusinessCpuLoad()
						: isCpuUtil(message) ? new ParserBusinessCpuUtil() : new ParserBusinessStatus();
	}

	private Boolean IsPing(String message) {
		return message.contains(":PING\t");
	}

	private Boolean IsCpuLoad(String message) {
		return message.contains(":CPU_LOAD");
	}

	private Boolean isCpuUtil(String message) {
		return message.contains(":CPU_UTIL\t");
	}

}
