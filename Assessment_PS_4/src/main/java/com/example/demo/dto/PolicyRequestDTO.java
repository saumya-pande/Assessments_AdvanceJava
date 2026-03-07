package com.example.demo.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@RequiredArgsConstructor
public class PolicyRequestDTO {
//	Example fields in PolicyRequestDTO:
//		•	policyNumber
//		•	policyType
//		•	premiumAmount
//		•	coverageAmount
//		•	startDate
//		•	endDate
//		•	customerId
		
	@NotBlank
    private String policyNumber;
    private String policyType;
    @Positive
    private double premiumAmount;
    @Positive
    private double coverageAmount;
    @NotNull
    private LocalDate startDate;
    private LocalDate endDate;
    private int customerId;
}