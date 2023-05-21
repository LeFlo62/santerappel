package fr.isep.genielogiciel.repositories;

import fr.isep.genielogiciel.entities.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.util.MultiValueMap;

public interface ExamCustomRepository {

    Page<Exam> filter(MultiValueMap<String, String> filter, Pageable pageable);

}
