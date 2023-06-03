package fr.isep.genielogiciel.repositories;

import fr.isep.genielogiciel.entities.Exam;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.util.LinkedMultiValueMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class ExamRepositoryTest {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @BeforeEach
    public void setUp() {
        mongoTemplate.dropCollection(Exam.class);

        Exam exam1 = new Exam();
        exam1.setCountryList(Arrays.asList("France", "Spain"));
        exam1.setAge(Collections.singletonList("20"));
        exam1.setRecommendation(Collections.singletonList("Recommendation 1"));

        Exam exam2 = new Exam();
        exam2.setCountryList(List.of("USA"));
        exam2.setAge(Collections.singletonList("30"));
        exam2.setRecommendation(Collections.singletonList("Recommendation 2"));

        mongoTemplate.insertAll(Arrays.asList(exam1, exam2));
    }

    @Test
    public void testFindDistinctCountryNames() {
        List<String> countries = examRepository.findDistinctCountryNames();
        assertEquals(3, countries.size());
        assertTrue(countries.containsAll(Arrays.asList("France", "Spain", "USA")));
    }

    @Test
    public void testFindDistinctAge() {
        List<String> ages = examRepository.findDistinctAge();
        assertEquals(2, ages.size());
        assertTrue(ages.containsAll(Arrays.asList("20", "30")));
    }

    @Test
    public void testFindDistinctRecommendation() {
        List<String> recommendations = examRepository.findDistinctRecommendation();
        assertEquals(2, recommendations.size());
        assertTrue(recommendations.containsAll(Arrays.asList("Recommendation 1", "Recommendation 2")));
    }

    @Test
    public void testFilter() {
        LinkedMultiValueMap<String, String> filter = new LinkedMultiValueMap<>();
        filter.add("age", "20");
        filter.add("countryList", "France");

        Page<Exam> exams = examRepository.filter(filter, PageRequest.of(0, 10));
        assertEquals(1, exams.getTotalElements());
        Exam exam = exams.getContent().get(0);
        assertEquals(Collections.singletonList("20"), exam.getAge());
        assertTrue(exam.getCountryList().contains("France"));
    }
}
