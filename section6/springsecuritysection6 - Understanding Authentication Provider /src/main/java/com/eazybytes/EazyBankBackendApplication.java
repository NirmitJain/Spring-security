package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@EnableWebSecurity // optional in spring security
@ComponentScan("com.eazybtes.springsecuritysection1.controller")
@EntityScan("com.eazybytes.model")
@EnableJpaRepositories("com.eazybytes.repo")*/
public class EazyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
	}

}
