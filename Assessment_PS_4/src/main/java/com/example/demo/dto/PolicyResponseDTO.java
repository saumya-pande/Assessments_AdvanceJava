package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@RequiredArgsConstructor
public class PolicyResponseDTO {
	private int id;
    private String policyNumber;
    private String policyType;
    private double premiumAmount;
    private double coverageAmount;
    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    private CustomerResponseDTO customer;
}
