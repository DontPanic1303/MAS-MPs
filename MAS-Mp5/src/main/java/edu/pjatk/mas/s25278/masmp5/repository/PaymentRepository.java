package edu.pjatk.mas.s25278.masmp5.repository;

import edu.pjatk.mas.s25278.masmp5.model.Configuration;
import edu.pjatk.mas.s25278.masmp5.model.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
