package fr.isep.genielogiciel.repositories;

import fr.isep.genielogiciel.entities.Exam;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamRepository extends MongoRepository<Exam, String>, PagingAndSortingRepository<Exam, String>, ExamCustomRepository {

    @Aggregation(pipeline = {
            "{$unwind: '$countryList'}",
            "{$group: {_id: '$countryList'}}",
            "{$project: {country: '$_id', _id: 0}}"
    })
    List<String> findDistinctCountryNames();

    @Aggregation(pipeline = {
            "{$unwind: '$age'}",
            "{$group: {_id: '$age'}}",
            "{$project: {country: '$_id', _id: 0}}"
    })
    List<String> findDistinctAge();

}
