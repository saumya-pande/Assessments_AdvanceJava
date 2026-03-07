package com.example.demo.dto;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@RequiredArgsConstructor
public class CustomerRequestDTO {
	private String name;
	@Email
	private String email;
	private long phoneNumber;
	private String address;
}