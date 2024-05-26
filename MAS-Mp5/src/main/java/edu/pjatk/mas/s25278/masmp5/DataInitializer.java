package edu.pjatk.mas.s25278.masmp5;

import edu.pjatk.mas.s25278.masmp5.model.Subject;
import edu.pjatk.mas.s25278.masmp5.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final SubjectRepository subjectRepository;

    @EventListener
    public void atStart(ContextRefreshedEvent event) {
        System.out.println("context refreshed");
//        Iterable<Subject> all = subjectRepository.findAll();
//        System.out.println(all);
    }

}
