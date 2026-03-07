package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Integer>{
	List<Policy> findByPolicyType(String policyType);
	List<Policy> findByCustomerId(int customerId);
	List<Policy> findByPremiumAmountBetween(double min, double max);
	
	@Query("SELECT p FROM Policy p WHERE p.customer.email = :email")
	List<Policy> findByCustomerEmail(@Param("email")String email);
	
}