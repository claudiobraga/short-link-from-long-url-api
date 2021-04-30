package com.claudio.braga.bank.of.america;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.claudio.braga.bank.of.america.api.configuration.property.ShortLinkApiProperty;

@SpringBootApplication
@EnableConfigurationProperties(ShortLinkApiProperty.class)
public class BankofAmericaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankofAmericaApplication.class, args);
	}

}
