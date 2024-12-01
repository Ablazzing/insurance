package com.javaacademy.insurance.service.calc;

import com.javaacademy.insurance.contract.InsuranceType;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

@Setter
public abstract class InsuranceCalcAbstract implements InsuranceCalcService {
    @Value("${insurance.coefficient.robbery}")
    protected BigDecimal robberyCoef;
    @Value("${insurance.base-price.robbery}")
    protected BigDecimal robberyBasePrice;
    @Value("${insurance.coefficient.medical}")
    protected BigDecimal medicalCoef;
    @Value("${insurance.base-price.medical}")
    protected BigDecimal medicalBasePrice;

    @Override
    public BigDecimal calculate(BigDecimal coverageAmount, InsuranceType insuranceType) {
        return switch (insuranceType) {
            case ROBBERY -> coverageAmount.multiply(robberyCoef).add(robberyBasePrice);
            case MEDICAL -> coverageAmount.multiply(medicalCoef).add(medicalBasePrice);
        };
    }


}
