package com.useless.health_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.useless.health_api.models.ExamModel;
import com.useless.health_api.repositories.ExamRepository;

@RestController
@RequestMapping("/api/medical-exams")
public class ExamController {
	@Autowired
	private ExamRepository examRepository;

	@GetMapping
	public List<ExamModel> getAllExams() {
		return examRepository.findAll();
	}

	@PostMapping
	public ExamModel createExam(@RequestBody ExamModel exam) {
		return examRepository.save(exam);
	}
}
