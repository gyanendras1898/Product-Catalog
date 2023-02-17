package com.gyan.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.gyan")
@EntityScan(basePackages = "com.gyan.bean")
@EnableJpaRepositories("com.gyan.persistence")
public class InventoryServiceProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceProjectApplication.class, args);
	}

}
