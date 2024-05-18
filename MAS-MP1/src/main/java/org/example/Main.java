package org.example;

import model.Tutor;

import java.time.LocalDate;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Tutor t1 = new Tutor(
                "Jan",
                "Kowalski",
                LocalDate.of(1990,11,11),
                "jan.kowalski@gmail.com",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );

        Tutor t2 = new Tutor(
                "Kot",
                "Kowalski",
                LocalDate.of(1991,11,11),
                "jan.kowalski@gmail.com",
                "123456789",
                LocalDate.now(),
                Set.of("Polski","Fizyka"),
                50.0
        );

        Tutor t3 = new Tutor(
                "Pies",
                "Kowalski",
                LocalDate.of(1992,11,11),
                "jan.kowalski@gmail.com",
                LocalDate.now(),
                Set.of("Matematyka","Fizyka"),
                50.0
        );

        var tutors = Tutor.FindTutorsBySubject("Polski");
        for (Tutor t :
                tutors) {
            System.out.println(t);
        }

        Tutor.saveExtensjaToFile();

        Tutor.loadExtensjaFromFile();



        for (Tutor t :
                Tutor.getTutorList()) {
            System.out.println(t);
        }




    }
}