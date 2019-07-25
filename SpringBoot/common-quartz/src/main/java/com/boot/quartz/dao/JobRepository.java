package com.boot.quartz.dao;

import com.boot.quartz.entites.JobPojo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobPojo, Integer> {
}
