package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dto.PolicyRequestDTO;
import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.exception.PolicyNotFoundException;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.mapper.PolicyMapper;
import com.example.demo.model.Customer;
import com.example.demo.model.Policy;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public PolicyResponseDTO createPolicy(PolicyRequestDTO dto) {

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));

        Policy policy = PolicyMapper.toEntity(dto, customer);

        Policy saved = policyRepository.save(policy);

        return PolicyMapper.toDTO(saved);
    }

    @Override
    public PolicyResponseDTO getPolicyById(int id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        return PolicyMapper.toDTO(policy);
    }

    @Override
    public PolicyResponseDTO updatePolicy(int id, PolicyRequestDTO dto) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        policy.setPolicyNumber(dto.getPolicyNumber());
        policy.setPolicyType(dto.getPolicyType());
        policy.setPremiumAmount(dto.getPremiumAmount());
        policy.setCoverageAmount(dto.getCoverageAmount());
        policy.setStartDate(dto.getStartDate());
        policy.setEndDate(dto.getEndDate());

        Policy updated = policyRepository.save(policy);

        return PolicyMapper.toDTO(updated);
    }

    @Override
    public void cancelPolicy(int id) {

        Policy policy = policyRepository.findById(id)
                .orElseThrow(() -> new PolicyNotFoundException("Policy not found"));

        policy.setStatus("CANCELLED");

        policyRepository.save(policy);
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByType(String type) {

        return policyRepository.findByPolicyType(type)
                .stream()
                .map(PolicyMapper::toDTO)
                .toList();
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByPremiumRange(double min, double max) {

        return policyRepository.findByPremiumAmountBetween(min, max)
                .stream()
                .map(PolicyMapper::toDTO)
                .toList();
    }
    
    public List<PolicyResponseDTO> getPoliciesByEmail(String email){
    	return policyRepository.findByCustomerEmail(email)
    			.stream()
    			.map(PolicyMapper::toDTO)
    			.toList();
    }

    @Override
    public Page<PolicyResponseDTO> getAllPolicies(int page, int size, String sortBy, String direction) {

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Page<Policy> policies = policyRepository.findAll(pageable);

        return policies.map(PolicyMapper::toDTO);
    }
}