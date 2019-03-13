package com.mycervello.adb.jpa.entity;

import javax.persistence.*;

import com.mycervello.adb.helpers.db.DbSchema;
import com.mycervello.adb.helpers.dto.JobAction;
import com.mycervello.adb.jpa.utils.IEntityWithId;

/**
 * Entity for the table with Bulk Job Configurations.
 * 
 * @author Gennadiy Pervukhin
 * @created 06-03-2019
 */
@Entity
@Table(name = "bulk_job_config", schema = DbSchema.ARCHIVE)
public class BulkJobConfig implements IEntityWithId {

	//
	//Variables
	//
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bulk_job_config_seq_gen")
	@SequenceGenerator(name = "bulk_job_config_seq_gen", sequenceName = "bulk_job_config_id_seq",
		allocationSize = 1,	initialValue = 1)
	private Integer id;

	@Column(name = "object_name", nullable = false)
	private String objectName;

	@Column(name = "sql_condition", nullable = false)
	private String sqlCondition;

	@Column(name = "job_action", nullable = false)
	@Enumerated(EnumType.STRING)
	private JobAction jobAction;

	@Column(name = "job_log_id", nullable = false)
	private Integer jobLogId;
	//

	//
	//Properties
	//
	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public String getObjectName() { return objectName; }

	public void setObjectName(String objectName) { this.objectName = objectName; }

	public String getSqlCondition() { return sqlCondition; }

	public void setSqlCondition(String sqlCondition) { this.sqlCondition = sqlCondition; }

	public JobAction getJobAction() { return jobAction; }

	public void setJobAction(JobAction jobAction) { this.jobAction = jobAction; }

	public Integer getJobLogId() { return jobLogId; }

	public void setJobLogId(Integer jobLogId) { this.jobLogId = jobLogId; }
	//
}
