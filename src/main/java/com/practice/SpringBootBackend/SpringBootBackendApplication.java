package com.practice.SpringBootBackend;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practice.SpringBootBackend.services.HelloService;

@SpringBootApplication
public class SpringBootBackendApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootBackendApplication.class, args);

		HelloService helloService = context.getBean(HelloService.class);

		System.out.println(helloService.sayHello());
	}

}
