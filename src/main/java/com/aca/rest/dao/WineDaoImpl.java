package com.aca.rest.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.aca.rest.model.Wine;

public class WineDaoImpl implements WineDao {
	
	
	
	private static String sqlGetAllWines = "SELECT * " + " FROM wine;";
	
	private final static String sqlInsertWines = 
			"  Insert INTO Wine " + "(name, " + "chocolate, " + "season)" + 
			"  VALUES (?,?,?) "; //6 columns 
	
	private static String sqlUpdateByWineID =  "Update Wine " + "Set Name = ?, Chocolate = ?, Season = ? " + " WHERE WineID = ? " ;
	
	private static String sqlDeleteWine = " DELETE FROM WINE WHERE WineID = ?";
	
	private static String sqlGetByWineID =  "SELECT WineID, name, Chocolate, Season " + " FROM wine " + 
			 " WHERE WineID = ? ";

	
	private Wine makeWine(ResultSet result) throws SQLException{
		Wine wine = new Wine();
		wine.setChocolate(result.getInt("chocolate"));
		wine.setSeason(result.getInt("season"));
		wine.setName(result.getString("name"));
		wine.setWineID(result.getInt("wineID"));
		wine.setDinner(result.getInt("dinner"));
		wine.setCoffee(result.getInt("coffee"));
		wine.setCheese(result.getInt("cheese"));
		
		return wine;
	}
		
	
	
	
	public List<Wine> getAllWines() {
		List<Wine> wines = new ArrayList<Wine>();
		
		ResultSet result = null;
		Statement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();//get connection to database to send requests and get responses 

		try {			
			statement = conn.createStatement();			
			result = statement.executeQuery(sqlGetAllWines);
			
			while(result.next()) {
					wines.add(makeWine(result));
			}			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {				
				result.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		return wines;
	}

	public Wine addWine(Wine newWine) {		
		int	rowCount = 0;
		PreparedStatement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();

		try {				
			statement = conn.prepareStatement(sqlInsertWines);
				
			statement.setString(1, newWine.getName());
			statement.setInt(2, newWine.getChocolate());
			statement.setInt(3, newWine.getSeason());

		
			rowCount = statement.executeUpdate();			
			
//			newWine.setWineID(getLastWineID(conn));
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {				
				statement.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
	
		return newWine;		
	}
	
	private int getLastWineID(Connection conn) throws SQLException {
		Integer wineID = 0;
		Statement statement = conn.createStatement();			
		ResultSet result = statement.executeQuery(" SELECT LAST_INSERT_ID() ");
		
		while(result.next()) {
			wineID = result.getInt("LAST_INSERT_ID()");				
		}
		return wineID;
	}

	
	public Wine updateWine(Wine updateWine) {
		
			int	rowCount = 0;
			PreparedStatement statement = null;
			
			Connection conn = MariaDbUtil.getConnection();

			try {				
				statement = conn.prepareStatement(sqlUpdateByWineID);
					
				statement.setString(1, updateWine.getName());
				statement.setInt(2, updateWine.getChocolate());
				statement.setInt(3, updateWine.getSeason());
				statement.setInt(4, updateWine.getWineID());

			
				rowCount = statement.executeUpdate();
				System.out.println("rows Updated: " + rowCount);
				
			} catch (SQLException e) {			
				e.printStackTrace();
			} finally {
				try {				
					statement.close();
					conn.close();
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}
			
			return updateWine;		
		
		
	}




	
	public List<Wine> deleteByWineID(int wineID) {
		List<Wine> wines = this.getByWineID(wineID);
		int	rowCount = 0;
		PreparedStatement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();

		try {				
			statement = conn.prepareStatement(sqlDeleteWine);
				
			statement.setInt(1, wineID);
		
			rowCount = statement.executeUpdate();			
			
			
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {				
				statement.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
			
		
		return wines;
	
	}




	
	public List<Wine> getByWineID(int wineID) {
		List<Wine> wines = new ArrayList<Wine>();

		ResultSet result = null;
		PreparedStatement statement = null;
		
		Connection conn = MariaDbUtil.getConnection();

		try {				
			statement = conn.prepareStatement(sqlGetByWineID);	
			statement.setInt(1, wineID);
			result  = statement.executeQuery();		
			
			while(result.next()){
				wines.add(makeWine(result));
			}
			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			try {				
				statement.close();
				conn.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
		}
		
		return wines;		
	}

}

