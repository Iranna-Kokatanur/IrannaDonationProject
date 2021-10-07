package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MemberServiceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext	ctx=SpringApplication.run(MemberServiceApplication.class, args);
		
		ctx.close();
	}

}
