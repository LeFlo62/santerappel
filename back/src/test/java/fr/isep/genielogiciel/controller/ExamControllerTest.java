package fr.isep.genielogiciel.controller;

import fr.isep.genielogiciel.dto.ExamDTO;
import fr.isep.genielogiciel.entities.Exam;
import fr.isep.genielogiciel.mapper.ExamMapper;
import fr.isep.genielogiciel.service.ExamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExamControllerTest {

    @Mock
    private ExamMapper examMapper;
    @Mock
    private ExamService examService;

    @Mock
    private Pageable pageable;
    @InjectMocks
    private ExamController examController;

    /**
     * Tests {@link ExamController#getExams(String, Pageable)}
     */
    @Test
    public void getExamsTest() {
        MultiValueMap<String, String> filters = new LinkedMultiValueMap<>();

        List<Exam> mockList = new ArrayList<>();
        Exam exam1 = Exam.builder().name("Examen prostate").build();
        Exam exam2 = Exam.builder().name("Examen vésicule biliaire").build();
        mockList.add(exam1);
        mockList.add(exam2);

        when(examService.listExams(filters, pageable)).thenReturn(mockList);

        ExamDTO examDTO1 = ExamDTO.builder().name("Examen prostate").build();
        ExamDTO examDTO2 = ExamDTO.builder().name("Examen vésicule biliaire").build();
        List<ExamDTO> expectedDTOs = Arrays.asList(examDTO1, examDTO2);

        when(examMapper.toDTO(mockList)).thenReturn(expectedDTOs);

        ResponseEntity<List<ExamDTO>> response = examController.getExams(null, pageable);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedDTOs, response.getBody());
    }

}
