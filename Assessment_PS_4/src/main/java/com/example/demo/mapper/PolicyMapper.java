package com.example.demo.mapper;

import com.example.demo.dto.CustomerResponseDTO;
import com.example.demo.dto.PolicyRequestDTO;
import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.Policy;

public class PolicyMapper {
	public static Policy toEntity(PolicyRequestDTO dto, Customer customer) {

	    Policy policy = new Policy();

	    policy.setPolicyNumber(dto.getPolicyNumber());
	    policy.setPolicyType(dto.getPolicyType());
	    policy.setPremiumAmount(dto.getPremiumAmount());
	    policy.setCoverageAmount(dto.getCoverageAmount());
	    policy.setStartDate(dto.getStartDate());
	    policy.setEndDate(dto.getEndDate());

	    policy.setCustomer(customer);

	    return policy;
	}
	
	public static PolicyResponseDTO toDTO(Policy policy) {

	    PolicyResponseDTO dto = new PolicyResponseDTO();

	    dto.setId(policy.getId());
	    dto.setPolicyNumber(policy.getPolicyNumber());
	    dto.setPolicyType(policy.getPolicyType());
	    dto.setPremiumAmount(policy.getPremiumAmount());
	    dto.setCoverageAmount(policy.getCoverageAmount());
	    dto.setStartDate(policy.getStartDate());
	    dto.setEndDate(policy.getEndDate());
	    dto.setStatus(policy.getStatus());

	    CustomerResponseDTO customerDTO = new CustomerResponseDTO();
	    customerDTO.setId(policy.getCustomer().getId());
	    customerDTO.setName(policy.getCustomer().getName());
	    customerDTO.setEmail(policy.getCustomer().getEmail());
	    customerDTO.setPhoneNumber(policy.getCustomer().getPhoneNumber());
	    customerDTO.setAddress(policy.getCustomer().getAddress());

	    dto.setCustomer(customerDTO);

	    return dto;
	}
}
