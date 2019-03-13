package com.mycervello.adb.api.ui;

import com.mycervello.adb.api.JpaUtilsForApi;
import com.mycervello.adb.helpers.dto.OperationResults;
import com.mycervello.adb.jpa.entity.BulkJobConfig;
import com.mycervello.adb.jpa.repository.BulkJobConfigRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class provides endpoints for UI API that work with Bulk Job Config.
 * 
 * @author Gennadiy Pervukhin
 * @created 06-03-2019
 */
@RestController
@RequestMapping("${adb.url.ui-api-path}/bulkJobConfig")
public class BulkJobConfigApi {

	//
	//Variables
	//
	@Autowired
	private BulkJobConfigRepository bulkJobConfigRepo;
	//

	//
	//Public methods
	//
	/**
	 * @return OperationResults with list of BulkJobConfig entities.
	 */
	@GetMapping(value = "getAll")
	public OperationResults getAll() {
		return OperationResults.newSuccess(bulkJobConfigRepo.findAll());
	}
	
	/**
	 * @param Integer id of a BulkJobConfig entity
	 * @return
	 */
	@GetMapping(value = "getById")
	public OperationResults getById(@RequestParam Integer id) {
		return OperationResults.newSuccess(bulkJobConfigRepo.findById(id));
	}
	
	/**
	 * @param BulkJobConfig entity
	 * @return OperationResults with id of a saved entity.
	 */
	@PostMapping(value = "save")
	public OperationResults save(@RequestBody BulkJobConfig config) {
		//TODO: we must check condition before to save the config
		return JpaUtilsForApi.save(bulkJobConfigRepo, config);
	}
	
	/**
	 * @param Integer id of a BulkJobConfig entity
	 * @return OperationResults with id of a deleted entity.
	 */
	@PostMapping(value = "delete")
	public OperationResults delete(@RequestBody Integer id) {
		return JpaUtilsForApi.delete(bulkJobConfigRepo, id);
	}
	//
}