package org.sample.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.sample.business.ParserBusiness;
import org.sample.model.EventModel;

@RunWith(JUnit4.class)
public class ParserBusinessCpuLoadTest {

	private ParserBusiness business;
	private String log;

	@Before
	public void setup() {
		business = new ParserBusiness();
		log = "19:36:05 12/09/2015	good	201776715	MADRID01:INFRA:CPU_LOAD	Load Average\5minAvg=0,42	3:13471	0	0,42";
	}

	@Test
	public void testParseLog() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
	}

	@Test
	public void testParserName() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getName(), "MADRID01");
	}

	@Test
	public void testParserStatus() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getStatus(), "good");
	}

	@Test
	public void testParserValue() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getDoubleValue(), 0.42, 0);
	}

	@Test
	public void testParserAction() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getAction(), "CPU_LOAD");
	}

	@Test
	public void testParserMonitor() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getMonitor(), "INFRA");
	}

	@Test
	public void testParserStringValue() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals("Load Average\5minAvg=0,42", event.getValue());
	}
}
