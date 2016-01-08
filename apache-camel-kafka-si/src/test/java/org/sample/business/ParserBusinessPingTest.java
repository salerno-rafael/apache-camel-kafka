package org.sample.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.sample.business.ParserBusiness;
import org.sample.model.EventModel;

@RunWith(JUnit4.class)
public class ParserBusinessPingTest {

	private ParserBusiness business;
	private String log;
	
	@Before
	public void setup() {
		business = new ParserBusiness();
		log = "11:56:22 11/27/2015	good	201734875	VALENCIA02:INFRA:PING	10 ms	13:2166118	ok	10.0	100";
	}

	@Test
	public void testParserName() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getName(), "VALENCIA02");
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
		Assert.assertEquals(event.getDoubleValue(), 10.0, 0);
	}

	@Test
	public void testParserAction() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getAction(), "PING");
	}

	@Test
	public void testParserStringValue() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getValue(), "10 ms");
	}
}
