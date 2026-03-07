package com.example.demo.model;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
public class Policy {
//	•	id
//	•	policyNumber
//	•	policyType (Health, Life, Vehicle)
//	•	premiumAmount
//	•	coverageAmount
//	•	startDate
//	•	endDate
//	•	status (ACTIVE, EXPIRED, CANCELLED)
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String policyNumber;

    private String policyType;

    private double premiumAmount;

    private double coverageAmount;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}