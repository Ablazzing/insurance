package com.javaacademy.insurance.calc;

import com.javaacademy.insurance.contract.InsuranceType;
import com.javaacademy.insurance.service.calc.InsuranceCalcService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;

@SpringBootTest
@ActiveProfiles("japan")
public class InsuranceCalcJapanServicеTest {
    private static final BigDecimal ROBBERY_COVERAGE_AMOUNT = BigDecimal.valueOf(1_000_000);
    private static final BigDecimal MEDICAL_COVERAGE_AMOUNT = BigDecimal.valueOf(10_000_000);
    private static final BigDecimal ROBBERY_EXPECTED_PRICE = BigDecimal.valueOf(20_000);
    private static final BigDecimal MEDICAL_EXPECTED_PRICE = BigDecimal.valueOf(162_000);
    @Autowired
    private InsuranceCalcService insuranceCalcService;

    @Test
    public void robberySuccess() {
        BigDecimal price = insuranceCalcService.calculate(ROBBERY_COVERAGE_AMOUNT, InsuranceType.ROBBERY);
        int result = price.compareTo(ROBBERY_EXPECTED_PRICE);
        Assertions.assertEquals(0, result);
    }

    @Test
    public void medicalSuccess() {
        BigDecimal price = insuranceCalcService.calculate(MEDICAL_COVERAGE_AMOUNT, InsuranceType.MEDICAL);
        System.out.println(price);
        int result = price.compareTo(MEDICAL_EXPECTED_PRICE);
        Assertions.assertEquals(0, result);
    }
}
