package com.example.demo;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("localStorage")
@Lazy
@Scope("prototype")
public final class LocalStorageService implements StorageService{
	public LocalStorageService() {
		super();
		System.out.println("LocalStorageService Bean Created");
	}
	
	@Override
	public void storeFile(String filename) {
		System.out.println("File stored in Local Storage: " + filename);
	}
}
