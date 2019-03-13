package com.mycervello.adb.api.ui;

import com.mycervello.adb.helpers.dto.OperationResults;
import com.mycervello.adb.helpers.dto.SfObjectName;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with Archiver Configurations.
 * 
 * @author Gennadiy Pervukhin
 * @created 13-03-2019
 */
@RestController
@RequestMapping("${adb.url.ui-api-path}/archiverConfig")
public class ArchiverConfigApi {

	//
	//Variables
	//
	
	//

	//
	//Public methods
	//
	/**
	 * @return OperationResults with a list of SfObjectName DTO.
	 */
	@GetMapping(value = "getSupportedSfObjects")
	public OperationResults getSupportedSfObjects() {
		
		//TODO: implement this
		SfObjectName[] supportedSfObjects = new SfObjectName[] {
			new SfObjectName("Account", "Account"),
			new SfObjectName("Service Report", "ServiceReport"),
			new SfObjectName("Campaign Member", "CampaignMember"),
			new SfObjectName("Constituent", "Contact"),
			new SfObjectName("Task", "Task"),
			new SfObjectName("Company Lead", "Lead"),
			new SfObjectName("Opportunity", "Opportunity"),
			new SfObjectName("Case or Ticket", "Case"),
		};
		return OperationResults.newSuccess(supportedSfObjects);
	}
	//
}