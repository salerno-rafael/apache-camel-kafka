package org.sample.business;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.sample.business.ParserBusiness;
import org.sample.model.EventModel;

@RunWith(JUnit4.class)
public class ParserBusinessStatusTest {

	private ParserBusiness business;
	private String log;
	private String logConexaoDb;
	
	@Before
	public void setup() {
		business = new ParserBusiness();
		log = "16:21:01 12/10/2015	good	201790664	PKG_DIST:APPL:PROC_AUTORIZE_ROUTER_BRADESCO	Error=0	3:11369	0	78	78	0";
		logConexaoDb = "17:14:17 12/11/2015	error	201741015	POLIMED_ONLINE:APPL:CONEXAO_DB	not found	1:16738	1	n/a	failure";
	}
	
	@Test
	public void testParserConexaoDb() {
		EventModel event = business.parseLog(logConexaoDb);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getName(), "POLIMED_ONLINE");
	}
	
	@Test
	public void testParserName() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getName(), "PKG_DIST");
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
		Assert.assertEquals(null, event.getDoubleValue());
	}

	@Test
	public void testParserAction() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getAction(), "PROC_AUTORIZE_ROUTER_BRADESCO");
	}

	@Test
	public void testParserStringValue() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getValue(), null);
	}
	
	@Test
	public void testParserMonitor() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals(event.getMonitor(), "APPL");
	}
	
	@Test
	public void testParserDate() {
		EventModel event = business.parseLog(log);
		Assert.assertNotNull(event);
		Assert.assertEquals("16:21:01 12/10/2015", event.getDate());
	}
}
