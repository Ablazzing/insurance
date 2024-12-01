package com.javaacademy.insurance.service.insurance;

import com.javaacademy.insurance.service.ArchiveStorage;
import com.javaacademy.insurance.service.NumberGenerator;
import com.javaacademy.insurance.service.calc.InsuranceCalcService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("brazil")
public class InsuranceServiceBrazil extends InsuranceServiceAbstract {
    public InsuranceServiceBrazil(InsuranceCalcService insuranceCalcService, NumberGenerator numberGenerator, ArchiveStorage archiveStorage) {
        super(insuranceCalcService, numberGenerator, archiveStorage);
    }
}
