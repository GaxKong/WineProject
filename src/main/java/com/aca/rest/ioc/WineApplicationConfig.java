package com.aca.rest.ioc;

import org.glassfish.jersey.server.ResourceConfig;

public class WineApplicationConfig extends ResourceConfig {

	
	public WineApplicationConfig(){
		System.out.println("...Calling constructor WineApplicatioConfig");
		this.register(new WineDependencyBinder());
		this.packages(true, "com.aca.rest");
	}
}
