package com.aca.rest.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.aca.rest.dao.WineDao;
import com.aca.rest.dao.WineDaoImpl;


import com.aca.rest.model.Wine;

public class WineService {
	
	@Inject
	private WineDao dao;
	
	public  List<Wine> getAllWines(){
		
		return dao.getAllWines();
	}

	public Wine addWine(Wine newWine){
		Wine wine = dao.addWine(newWine);
		return wine;
	}

	public Wine updateWine(Wine updateWine) {
		
		return dao.updateWine(updateWine);
	}

	public List<Wine> deleteByWineID(int wineID) {
		if(dao.getByWineID(wineID).size() !=1)  {
			
			Error error = new Error("invalid value for wineID'" + wineID + "'" );
			Response response = Response.status(400)
					.entity(error)
					.build();
			throw new WebApplicationException(response);
		}
		return dao.deleteByWineID(wineID);
	}
	public List<Wine> getByWineID(int wineID) {
		
		return dao.getByWineID(wineID);
		
	}


}
