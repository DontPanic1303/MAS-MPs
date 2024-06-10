package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.repository.ConfigurationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public Double getMinimalHourlySalary() {
        return Double.valueOf(configurationRepository.findByConfigKey("minimalHourlySalary")
                .orElseThrow(() -> new RuntimeException("Minimal hourly salary not configured"))
                .getConfigValue());
    }

}

