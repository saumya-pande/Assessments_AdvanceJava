package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.CustomerRequestDTO;
import com.example.demo.dto.CustomerResponseDTO;
import com.example.demo.exception.CustomerNotFoundException;
import com.example.demo.mapper.CustomerMapper;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {

        Customer customer = CustomerMapper.toEntity(dto);

        Customer saved = customerRepository.save(customer);

        return CustomerMapper.toDTO(saved);
    }

    @Override
    public List<CustomerResponseDTO> getAllCustomers() {

        return customerRepository.findAll()
                .stream()
                .map(CustomerMapper::toDTO)
                .toList();
    }

    @Override
    public CustomerResponseDTO getCustomerById(int id) {

        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + id));

        return CustomerMapper.toDTO(customer);
    }
}