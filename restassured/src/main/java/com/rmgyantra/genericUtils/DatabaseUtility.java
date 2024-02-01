package com.rmgyantra.genericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	public Connection connect=null;
public void  connectToDb() {
	try{
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		}
	catch(Exception e) {	
		e.printStackTrace();
	}
}
public void closeDb() {
	try {
		connect.close();
	}
	catch(Exception e) {	
		e.printStackTrace();
	}
}
public ResultSet getAllData(String query) {
	try {
          ResultSet result = connect.createStatement().executeQuery(query);
          return result;
	}
	catch(Exception e) {	
		e.printStackTrace();
	}
	return null;
}
public String getDataAndVerify(String query,int columnNo,String expectedData) throws Throwable {
        ResultSet result = connect.createStatement().executeQuery(query);
        boolean flag=false;
        String actualData=null;
        try {
        	while(result.next()) {
        		if(result.getString(columnNo).equals(expectedData)) {
        			actualData=result.getString(columnNo);
        			flag=true;
        			break;
        		}
        	}
	}
	catch(Exception e) {	
		e.printStackTrace();
	}
	if(flag) {
		System.out.println("Data is verified and matching in database");
		return actualData;
	}
	else {
		System.out.println("Data is not matching in Database");
		return actualData;
	}
	
}
}

