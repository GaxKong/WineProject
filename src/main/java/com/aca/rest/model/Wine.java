package com.aca.rest.model;

public class Wine {

	
	private String name;
	private int chocolate;
	private int season;
	private int wineID;
	private int dinner;
	private int coffee;
	private int cheese;
	
	
	public Wine(){};
	
	public Wine(String name, int chocolate, int season, int wineID, int dinner, int coffee, int cheese){
		this.name = name;
		this.chocolate = chocolate;
		this.season = season;
		this.wineID = wineID;
		this.dinner = dinner;
		this.coffee = coffee;
		this.cheese = cheese;
		
	}


	public String getName() {
		return name;
	}


	public int getChocolate() {
		return chocolate;
	}


	public int getSeason() {
		return season;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setChocolate(int chocolate) {
		this.chocolate = chocolate;
	}


	public void setSeason(int season) {
		this.season = season;
	}
	
	public int getWineID() {
		return wineID;
	}

	public void setWineID(int wineID) {
		this.wineID = wineID;
	}

	public int getDinner() {
		return dinner;
	}

	public int getCoffee() {
		return coffee;
	}

	public int getCheese() {
		return cheese;
	}

	public void setDinner(int dinner) {
		this.dinner = dinner;
	}

	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}

	public void setCheese(int cheese) {
		this.cheese = cheese;
	}

	public String toString(){
		return "Name of Wine: " + this.name;
	}
}
