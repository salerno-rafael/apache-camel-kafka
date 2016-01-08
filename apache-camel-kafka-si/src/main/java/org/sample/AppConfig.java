package org.sample;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ParserModule.class })
public class AppConfig {

}