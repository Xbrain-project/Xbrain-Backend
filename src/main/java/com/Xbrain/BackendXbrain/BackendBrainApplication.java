package com.Xbrain.BackendXbrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


@SpringBootApplication

public class BackendBrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBrainApplication.class, args);
	}


}
