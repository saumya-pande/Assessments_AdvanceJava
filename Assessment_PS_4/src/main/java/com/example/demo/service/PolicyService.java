package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.dto.PolicyRequestDTO;
import com.example.demo.dto.PolicyResponseDTO;

public interface PolicyService {
//	•	createPolicy()
//	•	getPolicyById()
//	•	updatePolicy()
//	•	cancelPolicy()
//	•	getPoliciesByType()
//	•	getPoliciesByPremiumRange()

    PolicyResponseDTO createPolicy(PolicyRequestDTO dto);

    PolicyResponseDTO getPolicyById(int id);

    PolicyResponseDTO updatePolicy(int id, PolicyRequestDTO dto);

    void cancelPolicy(int id);

    List<PolicyResponseDTO> getPoliciesByType(String type);

    List<PolicyResponseDTO> getPoliciesByPremiumRange(double min, double max);
    
    Page<PolicyResponseDTO> getAllPolicies(int page, int size, String sortBy, String direction);
}