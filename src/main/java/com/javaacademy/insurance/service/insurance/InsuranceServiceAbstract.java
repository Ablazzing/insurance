package com.javaacademy.insurance.service.insurance;

import com.javaacademy.insurance.contract.Contract;
import com.javaacademy.insurance.contract.ContractStatus;
import com.javaacademy.insurance.contract.Country;
import com.javaacademy.insurance.contract.InsuranceType;
import com.javaacademy.insurance.service.ArchiveStorage;
import com.javaacademy.insurance.service.NumberGenerator;
import com.javaacademy.insurance.service.calc.InsuranceCalcService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;

@RequiredArgsConstructor
public abstract class InsuranceServiceAbstract implements InsuranceService {
    private final InsuranceCalcService insuranceCalcService;
    private final NumberGenerator numberGenerator;
    private final ArchiveStorage archiveStorage;
    @Value("${insurance.country}")
    private Country country;
    @Value("${insurance.currency}")
    private String currency;

    @Override
    public Contract offer(BigDecimal coverageAmount, String fullName, InsuranceType insuranceType) {
        BigDecimal price = insuranceCalcService.calculate(coverageAmount, insuranceType);
        String newContractNumber = numberGenerator.generateNumber();
        Contract contract = new Contract(newContractNumber, price, coverageAmount, currency, fullName, country, insuranceType);
        archiveStorage.save(contract);
        return contract;
    }

    @Override
    public Contract pay(String number) {
        Contract contract = archiveStorage.getByNumber(number).orElseThrow();
        contract.setContractStatus(ContractStatus.PAID);
        return contract;
    }
}
