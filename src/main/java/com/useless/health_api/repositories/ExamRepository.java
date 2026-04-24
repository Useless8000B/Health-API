package com.useless.health_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.useless.health_api.models.ExamModel;

public interface ExamRepository extends JpaRepository <ExamModel, Long>{}
