package com.appointments.clcprojectrest1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.appointments.clcprojectrest1"})
public class Clcprojectrest1Application {

	public static void main(String[] args) {
		SpringApplication.run(Clcprojectrest1Application.class, args);
	}

}
