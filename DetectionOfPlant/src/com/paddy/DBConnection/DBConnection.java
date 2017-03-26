/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.paddy.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection con=null;
	static{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (Exception e) {
			
			
			e.printStackTrace();
			// TODO: handle exception
		}
		
	}
	
	public static Connection getConnention(){
		
		String url = "jdbc:mysql://localhost:3306/plantDiseasedetection"; 
		String username = "root";
		String password = "root";
		
		try {
//			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/plantDiseasedetection","root","root");
			con = DriverManager.getConnection(url, username, password);
			System.out.println("-----------------------------"+con.getClientInfo());
		} catch (Exception e) {
			e.printStackTrace();;
			// TODO: handle exception
		}
	return con;	
	}


}