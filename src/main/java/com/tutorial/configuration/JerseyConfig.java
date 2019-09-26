package com.tutorial.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JerseyConfig extends ResourceConfig{

	public JerseyConfig() {
		//register(ProductRessource.class);
		packages("com.tutorial.rest");
	}

}
