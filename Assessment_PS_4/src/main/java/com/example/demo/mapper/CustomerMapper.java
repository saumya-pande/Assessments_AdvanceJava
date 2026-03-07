package com.example.demo.mapper;

import com.example.demo.dto.CustomerRequestDTO;
import com.example.demo.dto.CustomerResponseDTO;
import com.example.demo.dto.PolicyResponseDTO;
import com.example.demo.model.Customer;

public class CustomerMapper {
	
	public static CustomerResponseDTO toDTO(Customer customer) {
		CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
		
		customerResponseDTO.setAddress(customer.getAddress());
		customerResponseDTO.setEmail(customer.getEmail());
		customerResponseDTO.setName(customer.getName());
		customerResponseDTO.setPhoneNumber(customer.getPhoneNumber());
		customerResponseDTO.setId(customer.getId());
		
		return customerResponseDTO;
	}
	
	public static Customer toEntity(CustomerRequestDTO customerRequestDTO) {
		Customer customer = new Customer();
		customer.setAddress(customerRequestDTO.getAddress());
		customer.setEmail(customerRequestDTO.getEmail());
		customer.setName(customerRequestDTO.getName());
		customer.setPhoneNumber(customerRequestDTO.getPhoneNumber());
		
		
		
		return customer;
	}
	
}	