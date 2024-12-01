package com.javaacademy.insurance.service;

import com.javaacademy.insurance.contract.Contract;
import com.javaacademy.insurance.contract.ContractStatus;
import com.javaacademy.insurance.contract.Country;
import com.javaacademy.insurance.service.calc.InsuranceCalcService;
import com.javaacademy.insurance.service.insurance.InsuranceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Optional;

import static com.javaacademy.insurance.contract.InsuranceType.MEDICAL;
import static com.javaacademy.insurance.contract.InsuranceType.ROBBERY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("japan")
public class InsuranceJapanServiceTest {
    private static final BigDecimal ROBBERY_COVERAGE_AMOUNT = BigDecimal.valueOf(1_000_000);
    private static final BigDecimal MEDICAL_COVERAGE_AMOUNT = BigDecimal.valueOf(10_000_000);
    private static final BigDecimal ROBBERY_EXPECTED_PRICE = BigDecimal.valueOf(20_000);
    private static final BigDecimal MEDICAL_EXPECTED_PRICE = BigDecimal.valueOf(162_000);
    @Autowired
    private InsuranceService insuranceService;

    @MockBean
    private InsuranceCalcService insuranceCalcService;

    @MockBean
    private ArchiveStorage archiveStorage;

    @MockBean
    private NumberGenerator numberGenerator;

    @Test
    public void robberyOfferSuccess() {
        //Иванов Иван Иванович, сумма покрытия 1 000 000, тип - от грабежа.
        Mockito.doReturn(ROBBERY_EXPECTED_PRICE).when(insuranceCalcService).calculate(ROBBERY_COVERAGE_AMOUNT, ROBBERY);
        when(numberGenerator.generateNumber()).thenReturn("001");

        Contract result = insuranceService.offer(ROBBERY_COVERAGE_AMOUNT, "Иванов Иван Иванович", ROBBERY);
        Contract expected = new Contract("001", ROBBERY_EXPECTED_PRICE,
                ROBBERY_COVERAGE_AMOUNT, "yen", "Иванов Иван Иванович", Country.JAPAN, ROBBERY);

        assertEquals(expected, result);
    }

    @Test
    public void medicalOfferSuccess() {
        //Иванов Иван Иванович, сумма покрытия 1 000 000, тип - от грабежа.
        Mockito.doReturn(MEDICAL_EXPECTED_PRICE).when(insuranceCalcService).calculate(MEDICAL_COVERAGE_AMOUNT, MEDICAL);
        when(numberGenerator.generateNumber()).thenReturn("001");

        Contract result = insuranceService.offer(MEDICAL_COVERAGE_AMOUNT, "Иванов Иван Иванович", MEDICAL);
        Contract expected = new Contract("001", MEDICAL_EXPECTED_PRICE,
                MEDICAL_COVERAGE_AMOUNT, "yen", "Иванов Иван Иванович", Country.JAPAN, MEDICAL);

        assertEquals(expected, result);
    }

    @Test
    public void payMedicalSuccess() {
        //Иванов Иван Иванович, сумма покрытия 1 000 000, тип - от грабежа.
        Contract unpaidContract = new Contract("001", MEDICAL_EXPECTED_PRICE,
                MEDICAL_COVERAGE_AMOUNT, "yen", "Иванов Иван Иванович", Country.JAPAN, MEDICAL);
        Mockito.when(archiveStorage.getByNumber("001")).thenReturn(Optional.of(unpaidContract));
        Contract result = insuranceService.pay("001");

        assertEquals(ContractStatus.PAID, result.getContractStatus());
    }
}
