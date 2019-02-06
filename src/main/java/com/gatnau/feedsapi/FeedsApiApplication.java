package com.gatnau.feedsapi;

import com.gatnau.feedsapi.customer.CustomerApi;
import com.gatnau.feedsapi.security.UserDetailsApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = {CustomerApi.class, UserDetailsApi.class})
public class FeedsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedsApiApplication.class, args);
	}

}

