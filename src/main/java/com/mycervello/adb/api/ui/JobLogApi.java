package com.mycervello.adb.api.ui;

import com.mycervello.adb.helpers.dto.OperationResults;
import com.mycervello.adb.jpa.repository.JobLogRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with Job Log.
 * 
 * @author Gennadiy Pervukhin
 * @created 06-03-2019
 */
@RestController
@RequestMapping("${adb.url.ui-api-path}/jobLog")
public class JobLogApi {

	//
	//Variables
	//
	@Autowired
	private JobLogRepository jobLogRepository;
	//

	//
	//Public methods
	//
	@GetMapping(value = "/getAll")
	public OperationResults getAll() {
		return OperationResults.newSuccess(jobLogRepository.findAll());
	}
	//
}