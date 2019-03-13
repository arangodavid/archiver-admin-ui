package com.mycervello.adb.api.ui;

import com.mycervello.adb.api.JpaUtilsForApi;
import com.mycervello.adb.helpers.dto.OperationResults;
import com.mycervello.adb.helpers.dto.SfUserCredentials;
import com.mycervello.adb.jpa.entity.AppSetting;
import com.mycervello.adb.jpa.repository.AppSettingRepository;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with Application Settings.
 * 
 * @author Gennadiy Pervukhin
 * @created 12-03-2019
 */
@RestController
@RequestMapping("${adb.url.ui-api-path}/appSettings")
public class AppSettingsApi {

	//
	//Variables
	//
	@Autowired
	private AppSettingRepository appSettingRepo;
	//

	//
	//Public methods
	//
	/**
	 * @return OperationResults with list of the AppSetting entities.
	 */
	@GetMapping(value = "getAll")
	public OperationResults getAll() {
		return OperationResults.newSuccess(appSettingRepo.findAll());
	}
	
	/**
	 * @param SfUserCredentials DTO
	 * @return OperationResults with ids of saved AppSetting entities.
	 */
	@PostMapping(value = "saveSfUserCredentials")
	public OperationResults saveSfUserCredentials(@RequestBody SfUserCredentials credentials) {
		//TODO: we must validate the passed credentials before to save them. The current check is temp
		if (credentials.getUsername().equalsIgnoreCase(credentials.getPassword())) { //TODO: temp logic
			return OperationResults.newError("Temporary validation rule: username must not be equal to the password");
		}
		
		AppSetting[] userSettings = new AppSetting[] {
			new AppSetting(AppSetting.SF_USER_NAME, credentials.getUsername()),
			new AppSetting(AppSetting.SF_USER_PASSWORD, credentials.getPassword()),
			new AppSetting(AppSetting.SF_USER_TOKEN, credentials.getToken())
		};
		return JpaUtilsForApi.saveAll(appSettingRepo, Arrays.asList(userSettings));
	}
	
	/**
	 * @param List of the AppSetting entities.
	 * @return OperationResults with ids of saved AppSetting entities.
	 */
	@PostMapping(value = "saveList")
	public OperationResults saveList(@RequestBody List<AppSetting> settings) {
		return JpaUtilsForApi.saveAll(appSettingRepo, settings);
	}
	//
}