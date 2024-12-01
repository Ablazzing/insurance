package com.javaacademy.insurance;

import com.javaacademy.insurance.contract.Contract;
import com.javaacademy.insurance.service.insurance.InsuranceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static com.javaacademy.insurance.contract.InsuranceType.ROBBERY;
import static java.math.BigDecimal.valueOf;

@SpringBootApplication
public class InsuranceApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(InsuranceApplication.class, args);
		InsuranceService insuranceService = context.getBean(InsuranceService.class);
		Contract contract = insuranceService.offer(valueOf(10_000), "Yuri Mol", ROBBERY);
		System.out.println(contract);
	}

}
