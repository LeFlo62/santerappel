package fr.isep.genielogiciel.controller;

import fr.isep.genielogiciel.dto.ExamDTO;
import fr.isep.genielogiciel.entities.Exam;
import fr.isep.genielogiciel.mapper.ExamMapper;
import fr.isep.genielogiciel.service.ExamService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ExamControllerTest {

    @MockBean
    private ExamMapper examMapper;
    @MockBean
    private ExamService examService;

    @MockBean
    private Pageable pageable;

    @Autowired
    MockMvc mockMvc;

    /**
     * Tests {@link ExamController#getExams(String, Pageable)}
     */
    @Test
    public void getExamsTest() throws Exception {
        List<Exam> mockList = new ArrayList<>();
        Exam exam1 = Exam.builder().name("Examen prostate").build();
        Exam exam2 = Exam.builder().name("Examen vésicule biliaire").build();
        mockList.add(exam1);
        mockList.add(exam2);

        when(examService.listExams(Mockito.any(), Mockito.any())).thenReturn(mockList);

        ExamDTO examDTO1 = ExamDTO.builder().name("Examen prostate").build();
        ExamDTO examDTO2 = ExamDTO.builder().name("Examen vésicule biliaire").build();
        List<ExamDTO> expectedDTOs = Arrays.asList(examDTO1, examDTO2);

        when(examMapper.toDTO(mockList)).thenReturn(expectedDTOs);

        mockMvc.perform(MockMvcRequestBuilders.get("/exams/list/paginated?size=10&page=0"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name").value("Examen prostate"))
                .andExpect(jsonPath("$[1].name").value("Examen vésicule biliaire"));

    }

}
