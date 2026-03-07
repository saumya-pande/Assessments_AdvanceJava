package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.demo.dto.PolicyRequestDTO;
import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.service.PolicyService;
import com.example.demo.service.PolicyServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyServiceImpl policyServiceImpl;

    @PostMapping
    public ResponseEntity<PolicyResponseDTO> createPolicy(
            @Valid @RequestBody PolicyRequestDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(policyServiceImpl.createPolicy(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> getPolicyById(@PathVariable int id) {

    	return ResponseEntity.ok(policyServiceImpl.getPolicyById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyResponseDTO> updatePolicy(
            @PathVariable int id,
            @Valid @RequestBody PolicyRequestDTO dto) {

        return ResponseEntity.ok(policyServiceImpl.updatePolicy(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> cancelPolicy(@PathVariable int id) {

        policyServiceImpl.cancelPolicy(id);
        return ResponseEntity.ok("Policy cancelled successfully");
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByType(
            @PathVariable String type) {

        return ResponseEntity.ok(policyServiceImpl.getPoliciesByType(type));
    }

    @GetMapping("/premium")
    public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByPremiumRange(
            @RequestParam double min,
            @RequestParam double max) {

        return ResponseEntity.ok(policyServiceImpl.getPoliciesByPremiumRange(min, max));
    }

    @GetMapping
    public ResponseEntity<Page<PolicyResponseDTO>> getAllPolicies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "premiumAmount") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        return ResponseEntity.ok(
                policyServiceImpl.getAllPolicies(page, size, sortBy, direction)
        );
    }
}
