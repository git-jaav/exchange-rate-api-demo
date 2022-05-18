package com.jaav.sys.exchangerateapidemo;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@SpringBootApplication(scanBasePackages={
		"com.jaav.sys"})
public class ExchangeRateApiDemoApplication  {

	public static void main(String[] args) {
		SpringApplication.run(ExchangeRateApiDemoApplication.class, args);
	}

	//@PostConstruct
	//public void displayUI() {
		//	log.info("[INFO-DESK]::INIT-DISPLAY::");
	//}


}
