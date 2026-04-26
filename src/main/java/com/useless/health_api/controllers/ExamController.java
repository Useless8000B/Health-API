package com.useless.health_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.useless.health_api.exceptions.NotFoundException;
import com.useless.health_api.models.ExamModel;
import com.useless.health_api.repositories.ExamRepository;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/medical-exams")
public class ExamController {
	@Autowired
	private ExamRepository examRepository;

	@GetMapping
	public ResponseEntity<List<ExamModel>> getExams(HttpServletRequest request) {
		String uid = (String) request.getAttribute("uid");

		if (uid == null || uid.isEmpty()) {
			throw new RuntimeException("User not authenticated properly");
		}

		List<ExamModel> exams = examRepository.findByFirebaseUuid(uid);

		if (exams.isEmpty()) {
			throw new NotFoundException("No medical exams for this user");
		}

		return ResponseEntity.ok(exams);
	}

	@PostMapping
	public ExamModel createExam(@RequestBody ExamModel exam, HttpServletRequest request) {
		String uid = (String) request.getAttribute("uid");
		
		if (uid == null || uid.isEmpty()) {
			throw new RuntimeException("User not authenticated properly");
		}

		exam.setFirebaseUuid(uid);

		return examRepository.save(exam);
	}
}
