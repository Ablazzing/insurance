package com.javaacademy.insurance.contract;

import lombok.Data;

import java.math.BigDecimal;

import static com.javaacademy.insurance.contract.ContractStatus.UNPAID;

@Data
public class Contract {
    private String number;
    private BigDecimal price;
    private BigDecimal coverageAmount;
    private String currency;
    private String fullName;
    private Country country;
    private InsuranceType insuranceType;
    private ContractStatus contractStatus = UNPAID;

    public Contract(String number, BigDecimal price, BigDecimal coverageAmount, String currency,
                    String fullName, Country country, InsuranceType insuranceType) {
        this.number = number;
        this.price = price;
        this.coverageAmount = coverageAmount;
        this.currency = currency;
        this.fullName = fullName;
        this.country = country;
        this.insuranceType = insuranceType;
    }
}
