package com.mycervello.adb.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mycervello.adb.helpers.dto.OperationResults;
import com.mycervello.adb.jpa.utils.IEntityWithId;

/**
 * This class provides JPA utilities for API.
 * 
 * @author Gennadiy Pervukhin
 * @created 06-03-2019
 */
public class JpaUtilsForApi
{
	//
	//Constants
	//
	private static final String E_SAVE_FAILED = "Unable to save the record:";
	private static final String E_SAVE_ALL_FAILED = "Unable to save the records:";
	private static final String E_DELETE_FAILED = "Unable to delete the record:";
	//
	
	//
	//Public static methods
	//
	public static <EntityT extends IEntityWithId> OperationResults save(
		CrudRepository<EntityT, ?> repository, EntityT entity)
	{
		try {
			repository.save(entity);
			return OperationResults.newSuccess(entity.getId());
		}
		catch (Exception error) {
			return OperationResults.newError(E_SAVE_FAILED, error);
		}
	}
	
	public static <EntityT extends IEntityWithId> OperationResults saveAll(
		CrudRepository<EntityT, ?> repository, Collection<EntityT> entities)
	{
		try {
			//- try to save all passed records
			repository.saveAll(entities);
			
			//- extract Ids of all saved entities and return them in positive results
			List<Object> ids = new ArrayList<>();
			for (EntityT entity : entities)
			{
				ids.add(entity.getId());
			}
			return OperationResults.newSuccess(ids);
		}
		catch (Exception error) {
			return OperationResults.newError(E_SAVE_ALL_FAILED, error);
		}
	}
	
	public static <IdType> OperationResults delete(
		CrudRepository<?, IdType> repository, IdType entityId)
	{
		try {
			repository.deleteById(entityId);
			return OperationResults.newSuccess(entityId);
		}
		catch (Exception error) {
			return OperationResults.newError(E_DELETE_FAILED, error);
		}
	}
	//
}