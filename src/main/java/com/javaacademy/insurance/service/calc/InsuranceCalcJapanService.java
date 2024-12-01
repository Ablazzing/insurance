package com.javaacademy.insurance.service.calc;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("japan")
public class InsuranceCalcJapanService extends InsuranceCalcAbstract {
}
