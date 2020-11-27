package com.simple.RoleBase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RoleBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleBaseApplication.class, args);
                System.out.println("Welcome");
	}
        
        @Bean
        public RestTemplate getRestTemplate() {
            return new RestTemplate();
        }

}
