package com.rmgyantra.genericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.*;

public class BaseApiClass {
public DatabaseUtility dbUtil=new  DatabaseUtility();
@BeforeSuite
public void Bs() {
	System.out.println("--------Connect to Database---------");
	dbUtil.connectToDb();
	baseURI="http://localhost";
	port=8084;
}
@AfterSuite
public void AS() {
	dbUtil.closeDb();
	System.out.println("Database is closed");
}
}
