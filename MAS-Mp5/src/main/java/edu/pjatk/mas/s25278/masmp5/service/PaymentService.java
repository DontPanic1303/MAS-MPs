package edu.pjatk.mas.s25278.masmp5.service;

import edu.pjatk.mas.s25278.masmp5.enums.PaymentStatus;
import edu.pjatk.mas.s25278.masmp5.model.Lesson;
import edu.pjatk.mas.s25278.masmp5.model.Payment;
import edu.pjatk.mas.s25278.masmp5.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public void changePaymentStatusByLessonId(PaymentStatus paymentStatus, Long lessonId) {

        Optional<Payment> payment = paymentRepository.findByLessonId(lessonId);

        if (payment.isEmpty())
            throw new IllegalArgumentException("Id lesson is incorrect");

        payment.get().setStatus(paymentStatus);

        paymentRepository.save(payment.get());
    }

}
