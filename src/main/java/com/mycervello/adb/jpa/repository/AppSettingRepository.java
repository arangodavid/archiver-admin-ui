package com.mycervello.adb.jpa.repository;

import com.mycervello.adb.jpa.entity.AppSetting;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppSettingRepository extends JpaRepository<AppSetting, Integer> {
}