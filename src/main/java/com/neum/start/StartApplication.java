package com.neum.start;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.neum.start.securtiy.RsaKeyConfigProperties;


@EnableConfigurationProperties(RsaKeyConfigProperties.class)
@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}
	
	    }
