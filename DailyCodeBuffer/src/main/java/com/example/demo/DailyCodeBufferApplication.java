package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("Entity")
@EnableJpaRepositories("Repository")
@ComponentScan(basePackages = {"Controller","Service","Exception","com.example.demo"})
public class DailyCodeBufferApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailyCodeBufferApplication.class, args);
	}

}
