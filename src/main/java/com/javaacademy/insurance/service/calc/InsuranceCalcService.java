package com.javaacademy.insurance.service.calc;

import com.javaacademy.insurance.contract.InsuranceType;

import java.math.BigDecimal;

public interface InsuranceCalcService {

    BigDecimal calculate(BigDecimal coverageAmount, InsuranceType insuranceType);
}
