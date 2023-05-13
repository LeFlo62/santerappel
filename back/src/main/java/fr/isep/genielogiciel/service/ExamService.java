package fr.isep.genielogiciel.service;

import fr.isep.genielogiciel.entities.Exam;
import fr.isep.genielogiciel.repositories.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public List<Exam> listExams(Pageable pageable) {
        return examRepository.findAll(pageable).getContent();
    }

}
