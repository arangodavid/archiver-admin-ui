package com.mycervello.adb.helpers.dto;

/**
 * This class encapsulates credentials of a SF User.
 * 
 * @author Gennadiy Pervukhin
 * @created 13-03-2019
 */
public class SfUserCredentials {
	
	//
	//Constructors
	//
	/* For JSON-deserialization */
	public SfUserCredentials() {}
	//
	
	//
	//Variables
	//
	private String username;
	private String password;
	private String token;
	//
	
	//
	//Properties
	//
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	//
}