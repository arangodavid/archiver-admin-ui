package com.mycervello.adb.jpa.repository;

import com.mycervello.adb.jpa.entity.JobLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobLogRepository extends JpaRepository<JobLog, Integer> {
}