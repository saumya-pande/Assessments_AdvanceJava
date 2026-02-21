package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AssessmentPs2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AssessmentPs2Application.class, args);
		
		StorageService service = context.getBean(StorageService.class);
		service.storeFile("file_0_storage.txt");
		
		LocalStorageService localStorageService = context.getBean(LocalStorageService.class);
		localStorageService.storeFile("file1_local.txt");
		
		LocalStorageService localStorageService2 = context.getBean(LocalStorageService.class);
		localStorageService2.storeFile("file2_local.txt");
		
	}
}
