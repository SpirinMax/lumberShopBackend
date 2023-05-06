package com.partner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = { "com.partner.controllers", "com.partner.service" })
@EntityScan(basePackages = "com.partner.dataObjects")
@EnableJpaRepositories(basePackages = "com.partner.dataCrudInterfaces")
@SpringBootApplication
public class PartnerProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartnerProjectApplication.class, args);
	}

}
