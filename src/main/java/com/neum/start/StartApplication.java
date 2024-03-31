package com.neum.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.neum.start.securtiy.RsaKeyConfigProperties;


@EnableConfigurationProperties(RsaKeyConfigProperties.class)
@SpringBootApplication
@EnableAutoConfiguration
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}
	
	    }
