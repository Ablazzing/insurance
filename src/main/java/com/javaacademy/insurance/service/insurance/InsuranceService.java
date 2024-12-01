package com.javaacademy.insurance.service.insurance;

import com.javaacademy.insurance.contract.Contract;
import com.javaacademy.insurance.contract.InsuranceType;

import java.math.BigDecimal;

public interface InsuranceService {
    Contract offer(BigDecimal coverageAmount, String fullName, InsuranceType insuranceType);

    Contract pay(String number);
}
