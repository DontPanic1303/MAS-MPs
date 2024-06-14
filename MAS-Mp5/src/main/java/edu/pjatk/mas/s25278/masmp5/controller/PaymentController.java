package edu.pjatk.mas.s25278.masmp5.controller;

import edu.pjatk.mas.s25278.masmp5.enums.PaymentStatus;
import edu.pjatk.mas.s25278.masmp5.service.PaymentService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService=paymentService;
    }

    @PutMapping("/change/{id}")
    public ResponseEntity<String> changePaymentStatusToPayedByLessonId(@PathVariable Long id){
        this.paymentService.changePaymentStatusByLessonId(PaymentStatus.NOTICED,id);
        return ResponseEntity.ok("Ok");
    }


}
