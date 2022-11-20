package com.Xbrain.BackendXbrain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;

@SpringBootApplication
public class BackendBrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendBrainApplication.class, args);
	}

//	EntityManagerFactory factory = Persistence.createEntityManagerFactory("application");
//
//	EntityManager entityManager = factory.createEntityManager();
//
//	EntityTransaction transaction = entityManager.getTransaction();
}
