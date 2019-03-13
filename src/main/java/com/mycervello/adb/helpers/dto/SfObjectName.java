package com.mycervello.adb.helpers.dto;

/**
 * This class encapsulates details of a SF object name.
 * 
 * @author Gennadiy Pervukhin
 * @created 13-03-2019
 */
public class SfObjectName {
	
	//
	//Constructors
	//
	public SfObjectName(String label, String apiName) {
		this.label = label;
		this.apiName = apiName;
	}
	//
	
	//
	//Variables
	//
	private String label;
	private String apiName;
	//
	
	//
	//Properties
	//
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getApiName() {
		return apiName;
	}
	public void setApiName(String apiName) {
		this.apiName = apiName;
	}
	//
}