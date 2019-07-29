package com.aca.rest.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;


import com.aca.rest.model.Wine;
import com.aca.rest.service.WineService;

@Path("/wines")
public class WineController {
	
	//YO
	
	@Inject 
	private WineService service;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Wine> getAllWines(){
		
		
		
		return service.getAllWines();
	}
	
	@POST 
	@Produces({MediaType.APPLICATION_JSON})
	public Wine addWine(Wine newWine){
	
	return service.addWine(newWine);

	}


	@GET
	@Path("/fancysearch")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Wine> getByFancySearch(
			@QueryParam("english") String english,
			@QueryParam("french") String french,
			@QueryParam("german") String german,
			@QueryParam("spanish") String spanish,
			@QueryParam("media") String media,
			@QueryParam("startdate") String stardate,
			@QueryParam("enddate") String enddate) {
		
		System.out.println("english: " + english);
		System.out.println("french: " + french);
		System.out.println("german: " + german);
		System.out.println("spanish: " + spanish);
		System.out.println("media: " + media);
		System.out.println("startdate: " + stardate);
		System.out.println("enddate: " + enddate);
		
		return getAllWines();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Wine updateMovie(Wine updateWine){
		
		return service.updateWine(updateWine);
		
	}
	
	
	@DELETE
	@Path("/{wineID}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Wine> deleteByWineID(@PathParam("wineID") int wineID){
		
				return service.deleteByWineID(wineID);
	}

}