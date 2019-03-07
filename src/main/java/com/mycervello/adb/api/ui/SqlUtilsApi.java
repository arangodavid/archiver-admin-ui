package com.mycervello.adb.api.ui;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycervello.adb.helpers.dto.OperationResults;

/**
 * This class provides endpoints to work with SQL for UI API.
 * 
 * @author Gennadiy Pervukhin
 * @created 06-03-2019
 */
@RestController
@RequestMapping("${adb.url.ui-api-path}/sqlUtils")
public class SqlUtilsApi {

	//
	//Public methods
	//
	@GetMapping(value = "checkCondition")
	public OperationResults checkCondition() {
		return OperationResults.notImplementedError();
	}
	//
}
