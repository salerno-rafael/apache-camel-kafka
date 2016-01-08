package org.sample;

import org.apache.log4j.Logger;
import org.sample.route.CamelRoute;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({ParserModule.class })
public class Application {
	
	private static Logger logger = Logger.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		CamelRoute route = (CamelRoute) applicationConext().getBean(CamelRoute.class);
		logger.info("starting parser");
		route.start();
	}

	private static AnnotationConfigApplicationContext applicationConext() {
		return new AnnotationConfigApplicationContext(AppConfig.class);
	}

}
