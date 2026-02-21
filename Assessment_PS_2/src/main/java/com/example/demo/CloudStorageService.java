package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("cloudStorage")
@Primary
public class CloudStorageService implements StorageService{

	public CloudStorageService() {
		super();
		System.out.println("CloudStorageService Bean Created");
	}
	
	@Override
	public void storeFile(String filename) {
		System.out.println("File stored in Cloud Storage : " + filename);
	}
	@PostConstruct
	public void init() {
		System.out.println("CloudStorageService Bean initialized");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("CloudStorageService Bean Destroyed");
	}
}
