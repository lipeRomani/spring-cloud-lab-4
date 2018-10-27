package io.romani.subjectservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubjectserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubjectserviceApplication.class, args);
	}
}
