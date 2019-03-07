package com.mycervello.adb.config;

/**
 * This class provides utilities for application settings.
 * 
 * @author Gennadiy Pervukhin
 * @created 20-06-2018
 */
public class AppSettings {
	
	//
	//Constants
	//
	private static final String DEFAULT_DB_URL = "postgres://u46l5uf9d6ufru"
		+ ":p2b65fa5f919e5d4f977105b87cb52a53b75af9b461e440d7a099b6dc091cbb9b"
		+ "@ec2-35-172-166-6.compute-1.amazonaws.com:5432/d9j67tk2hqqieo";
	
	public static final String DATABASE_URL;
	static {
		String dbUrlFromSystemVar = System.getenv("ADB_DATABASE_URL");
		DATABASE_URL = (dbUrlFromSystemVar != null ? dbUrlFromSystemVar : DEFAULT_DB_URL);
	}
	//
}