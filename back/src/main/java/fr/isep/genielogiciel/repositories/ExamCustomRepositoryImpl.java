package fr.isep.genielogiciel.repositories;

import fr.isep.genielogiciel.entities.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Repository
public class ExamCustomRepositoryImpl implements ExamCustomRepository {

    private final MongoOperations mongoOperations;

    public ExamCustomRepositoryImpl(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    @Override
    public Page<Exam> filter(MultiValueMap<String, String> filter, Pageable pageable) {
        Query query = new Query();

        Criteria criteria = new Criteria();

        if(filter != null){
            for(String key : filter.keySet()){
                criteria = criteria.and(key).in(filter.get(key));
            }
        }

        query.addCriteria(criteria);

        query.with(pageable);

        // Execute the query and return a Page object
        List<Exam> results = mongoOperations.find(query, Exam.class);
        long count = mongoOperations.count(query, Exam.class);
        return PageableExecutionUtils.getPage(results, pageable, () -> count);
    }
}
