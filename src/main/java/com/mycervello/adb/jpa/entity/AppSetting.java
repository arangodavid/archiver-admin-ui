package com.mycervello.adb.jpa.entity;

import com.mycervello.adb.helpers.db.DbSchema;
import com.mycervello.adb.jpa.utils.IEntityWithId;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.*;

/**
 * Entity for the table with settings.
 * 
 * @author Gennadiy Pervukhin
 * @created 12-03-2019
 */
@Entity
@Table(name = "setting", schema = DbSchema.ARCHIVE)
public class AppSetting implements IEntityWithId {

	//
	//Constructors
	//
	public AppSetting(String name, String value) {
		this.name = name;
		this.value = value;
	}
	//
	
	//
	//Constants
	//
	public static final String SF_USER_NAME = "SF_USER_NAME";
	public static final String SF_USER_PASSWORD = "SF_USER_PASSWORD";
	public static final String SF_USER_TOKEN = "SF_USER_TOKEN";
	public static final String SF_BASE_URL = "SF_BASE_URL";
	//
	
	//
	//Variables
	//
	@Id
	private String name;
	private String value;
	//

	//
	//Properties
	//
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	//
	
	//
	//Implementation of the IEntityWithId interface
	//
	@Override
	public Object getId() {
		return this.name;
	}
	//
	
	//
	//Public methods
	//
	@Override
	public String toString() {
		return "AppSetting [name=" + name + ", value=" + value + "]";
	}
	//
	
	//
	//Public static methods
	//
	public static Map<String, String> extractMap(Collection<AppSetting> settings) {
		Map<String,String> map = new HashMap<>();
		for (AppSetting setting : settings) {
			map.put(setting.getName(), setting.getValue());
		}
		return map;	
	}
	//
}