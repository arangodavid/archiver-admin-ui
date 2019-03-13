package com.mycervello.adb.jpa.repository;

import com.mycervello.adb.jpa.entity.BulkJobConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BulkJobConfigRepository extends JpaRepository<BulkJobConfig, Integer> {
}