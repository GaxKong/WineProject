package com.aca.rest.dao;

import java.util.List;

import com.aca.rest.model.Wine;

public interface WineDao {

	
	public List<Wine> getAllWines();

	public Wine addWine(Wine newWine);

	public Wine updateWine(Wine updateWine);

	public List<Wine> deleteByWineID(int wineID);

	public List<Wine> getByWineID(int wineID);

	
}
