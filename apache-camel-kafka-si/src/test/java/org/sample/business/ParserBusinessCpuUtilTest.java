package org.sample.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.sample.business.ParserBusiness;
import org.sample.model.EventModel;

@RunWith(JUnit4.class)
public class ParserBusinessCpuUtilTest {
	private ParserBusiness business;
	private String log;

	@Before
	public void setup() {
		business = new ParserBusiness();
		log = "19:29:42 12/09/2015	good	201774382	VALENCIA01:INFRA:CPU_UTIL	55% avg, cpu1 49%, cpu2 61%, cpu3 56%, cpu4 45%, cpu5 46%, cpu6 60%, cpu7 65%, cpu8 50%, cpu9 65%, cpu10 60%	1:13540	55	49	61	56	45	46	60	65	50	65	60";
	}

	@Test
	public void testParserName() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getName(), "VALENCIA01");
	}

	@Test
	public void testParserStatus() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getStatus(), "good");
	}

	@Test
	public void testParserDoubleValue() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getDoubleValue(), 55, 0);
	}

	@Test
	public void testParserAction() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getAction(), "CPU_UTIL");
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
		Assert.assertEquals(event.getValue(), "55% avg");
	}
}
