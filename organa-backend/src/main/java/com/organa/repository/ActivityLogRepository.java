package com.organa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organa.entity.ActivityLog;

public interface ActivityLogRepository extends JpaRepository<ActivityLog, Long> {

}
