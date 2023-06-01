package fr.isep.genielogiciel.service;

import fr.isep.genielogiciel.entities.Exam;
import fr.isep.genielogiciel.repositories.ExamRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExamServiceTest {

    @Mock
    private ExamRepository examRepository;

    @Mock
    private Pageable pageable;

    @Mock
    private Page pageMock;

    @InjectMocks
    private ExamService examService;

    /**
     * Tests {@link ExamService#listExams(Pageable)}
     */
    @Test
    public void listExamsTest() {

        List<Exam> mockList = new ArrayList<>();
        mockList.add(Exam.builder().name("Examen prostate").build());
        mockList.add(Exam.builder().name("Examen vésicule biliaire").build());
        mockList.add(Exam.builder().name("Examen thyroïde").build());


        Mockito.when(pageMock.getContent()).thenReturn(mockList);
        Mockito.when(examRepository.findAll(Mockito.any(Pageable.class))).thenReturn(pageMock);

        List<Exam> examListTest = examService.listExams(pageable);

        Assertions.assertThatList(examListTest).hasSize(mockList.size());
        Assertions.assertThatList(examListTest).allMatch(mockList::contains);

        Mockito.verify(examRepository).findAll(pageable);
        Mockito.verify(pageMock).getContent();
    }
}
