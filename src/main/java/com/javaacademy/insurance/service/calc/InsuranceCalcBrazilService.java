package com.javaacademy.insurance.service.calc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("brazil")
public class InsuranceCalcBrazilService extends InsuranceCalcAbstract {
}
