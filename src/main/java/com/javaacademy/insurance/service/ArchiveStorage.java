package com.javaacademy.insurance.service;

import com.javaacademy.insurance.contract.Contract;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class ArchiveStorage {
    private final Map<String, Contract> data = new HashMap<>();

    public void save(Contract contract) {
        if (data.containsKey(contract.getNumber())) {
            throw new RuntimeException("Договор с таким номером уже есть");
        }
        data.put(contract.getNumber(), contract);
    }

    public Optional<Contract> getByNumber(String number) {
        return Optional.ofNullable(data.get(number));
    }
}
