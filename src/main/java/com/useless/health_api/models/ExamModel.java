package com.useless.health_api.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "medical_exams")
@NoArgsConstructor
public class ExamModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "firebase_uuid", nullable = false)
	private String firebaseUuid;

	private String examType;
	private String examLocation;
	private LocalDateTime examDate;
	
}
