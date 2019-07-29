package com.aca.rest.ioc;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.aca.rest.dao.WineDao;
import com.aca.rest.dao.WineDaoImpl;
import com.aca.rest.service.WineService;

public class WineDependencyBinder extends AbstractBinder {
	
	@Override
	protected void configure(){
		System.out.println("...injecting concrete objects into wine app");
		this.bind(WineService.class).to(WineService.class);
		this.bind(WineDaoImpl.class).to(WineDao.class);
	}
	

}
