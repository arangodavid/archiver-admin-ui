package com.mycervello.adb.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mycervello.adb.helpers.datatype.DatetimeUtils;
import com.mycervello.adb.helpers.db.DbSchema;
import com.mycervello.adb.helpers.dto.JobAction;
import com.mycervello.adb.helpers.dto.JobStatus;
import com.mycervello.adb.helpers.dto.JobVolume;
import com.mycervello.adb.jpa.utils.IEntityWithId;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "job_log", schema = DbSchema.ARCHIVE)
public class JobLog implements IEntityWithId {

	//
	//Variables
	//
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_log_seq_gen")
	@SequenceGenerator(name = "job_log_seq_gen", sequenceName = "job_log_id_seq",
		allocationSize = 1,	initialValue = 1)
	private Integer id;

	@Column(name = "action", nullable = false)
	@Enumerated(EnumType.STRING)
	private JobAction action;

	@Column(name = "status", nullable = false)
	@Enumerated(EnumType.STRING)
	private JobStatus status;

	@Column(name = "volume", nullable = false)
	@Enumerated(EnumType.STRING)
	private JobVolume volume;

	@Column(name = "date_time_started", columnDefinition = "TIMESTAMP", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp dateTimeStarted;

	@Column(name = "date_time_completed", columnDefinition = "TIMESTAMP")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DatetimeUtils.ISO_DATETIME_FORMAT)
	private Timestamp dateTimeCompleted;

	@Column(name = "num_errors")
	private Integer numErrors = 0;

	@Column(name = "num_records_updated")
	private Integer numRecordsUpdated = 0;

	@Column(name = "error")
	private String error;

	@Column(name = "system_notes")
	private String systemNotes;

	@Column(name = "process_data")
	private String processData;

	@Column(name = "progress_info")
	private String progressInfo;
	//

	//
	//Properties
	//
	public Integer getId() { return id; }

	public void setId(Integer id) { this.id = id; }

	public JobAction getAction() { return action; }

	public void setAction(JobAction action) { this.action = action; }

	public JobStatus getStatus() { return status; }

	public void setStatus(JobStatus status) { this.status = status; }

	public JobVolume getVolume() { return volume; }

	public void setVolume(JobVolume volume) { this.volume = volume; }

	public Timestamp getDateTimeStarted() { return dateTimeStarted; }

	public void setDateTimeStarted(Timestamp dateTimeStarted) {
		this.dateTimeStarted = dateTimeStarted;
	}

	public Timestamp getDateTimeCompleted() { return dateTimeCompleted; }

	public void setDateTimeCompleted(Timestamp dateTimeCompleted) {
		this.dateTimeCompleted = dateTimeCompleted;
	}

	public Integer getNumErrors() { return numErrors; }

	public void setNumErrors(Integer numErrors) { this.numErrors = numErrors; }

	public Integer getNumRecordsUpdated() { return numRecordsUpdated; }

	public void setNumRecordsUpdated(Integer numRecordsUpdated) {
		this.numRecordsUpdated = numRecordsUpdated;
	}

	public String getError() { return error; }

	public void setError(String error) { this.error = error; }

	public String getSystemNotes() { return systemNotes; }

	public void setSystemNotes(String systemNotes) { this.systemNotes = systemNotes; }

	public String getProcessData() { return processData; }

	public void setProcessData(String processData) { this.processData = processData; }

	public String getProgressInfo() { return progressInfo; }

	public void setProgressInfo(String progressInfo) { this.progressInfo = progressInfo; }
	//
}
