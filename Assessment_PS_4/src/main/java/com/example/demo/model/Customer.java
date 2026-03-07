package com.example.demo.model;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@RequiredArgsConstructor
public class Customer {

	
//	•	id
//	•	name
//	•	email
//	•	phoneNumber
//	•	address
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String name;
	private String email;
	private long phoneNumber;
	private String address;	
	
	@OneToMany(mappedBy ="customer", cascade = CascadeType.ALL)
	private List<Policy> policies;
}
