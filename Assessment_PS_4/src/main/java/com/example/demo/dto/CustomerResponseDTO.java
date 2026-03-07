package com.example.demo.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@RequiredArgsConstructor
public class CustomerResponseDTO {
	
	private int id;
    private String name;
    private String email;
    private long phoneNumber;
    private String address;

    private List<PolicyResponseDTO> policies;
}
