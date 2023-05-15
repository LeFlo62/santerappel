package fr.isep.genielogiciel.repositories;

import fr.isep.genielogiciel.entities.Exam;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends MongoRepository<Exam, String>, PagingAndSortingRepository<Exam, String> {
}
