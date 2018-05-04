package com.acn.manu.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import com.acn.manu.dto.DtoLogin;

public class DaoLogin {

	//private DataSource dataSource;
	private Connection connection;
    private PreparedStatement pstm;
    private ResultSet rs ;
    
    private final String SQL = "SELECT USERNAME FROM LOGIN WHERE USERNAME=? AND PWD=?";

    public boolean verifyLogin(DtoLogin dtoLogin, DataSource ds) {
    	boolean result=false;
    		try {
    			//apertura della connessione
    			//creazione del prepared statement
    			//esecuzione della query
    			connection = ds.getConnection();
    			System.out.println("User: "+dtoLogin.getUsername() + " Pass: "+ dtoLogin.getPassword());
    			 
				 pstm = connection.prepareStatement(SQL);
				 pstm.setString(1, dtoLogin.getUsername());
				 pstm.setString(2, dtoLogin.getPassword());
				 
				 rs=pstm.executeQuery();  
				 
				 
				 
				 while (rs.next()) {
					 System.out.println("Nome: "+rs.getString(1));
					 result=true;
				 }
				 
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
    		System.out.println(" Result: " +result);
    		return result;
	
}
}
