package io.wspot.confgservertest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfgservertestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfgservertestApplication.class, args);
	}
}
