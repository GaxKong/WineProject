package com.aca.rest.model;

public class Wine {

	
	private String name;
//	private int chocolate;
//	private int season;
	private int wineID;
	private String summary;
//	private int dinner;
//	private int coffee;
//	private int cheese;
//	
	
	public Wine(){};
	
	public Wine(String name, int wineID, String summary){
		this.name = name;
//		this.chocolate = chocolate;
//		this.season = season;
		this.wineID = wineID;
		this.summary = summary;
//		this.dinner = dinner;
//		this.coffee = coffee;
//		this.cheese = cheese;
		
	}


	public String getName() {
		return name;
	}


//	public int getChocolate() {
//		return chocolate;
//	}
//
//
//	public int getSeason() {
//		return season;
//	}
//
//
	public void setName(String name) {
		this.name = name;
	}
//
//
//	public void setChocolate(int chocolate) {
//		this.chocolate = chocolate;
//	}
//
//
//	public void setSeason(int season) {
//		this.season = season;
//	}
//	
	public int getWineID() {
		return wineID;
	}

	public void setWineID(int wineID) {
		this.wineID = wineID;
	}
//
//	public int getDinner() {
//		return dinner;
//	}
//
//	public int getCoffee() {
//		return coffee;
//	}
//
//	public int getCheese() {
//		return cheese;
//	}
//
//	public void setDinner(int dinner) {
//		this.dinner = dinner;
//	}
//
//	public void setCoffee(int coffee) {
//		this.coffee = coffee;
//	}
//
//	public void setCheese(int cheese) {
//		this.cheese = cheese;
//	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String toString(){
		return "Name of Wine: " + this.name;
	}
}
