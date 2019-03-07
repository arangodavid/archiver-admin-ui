package com.mycervello.adb.helpers.dto;

public enum JobStatus {
	QUEUED,
	IN_PROGRESS,
	COMPLETED,
	COMPLETED_WITH_ERROR,
	//this status is used in case of unusual interruption of a process (e.g., application termination)
	INTERRUPTED
}
