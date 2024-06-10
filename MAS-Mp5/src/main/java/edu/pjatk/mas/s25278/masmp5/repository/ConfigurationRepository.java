package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Configuration;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ConfigurationRepository extends CrudRepository<Configuration, Long> {
    Optional<Configuration> findByConfigKey(String configKey);
}
