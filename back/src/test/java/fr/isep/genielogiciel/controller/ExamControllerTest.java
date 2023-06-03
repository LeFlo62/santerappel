package fr.isep.genielogiciel.controller;

import fr.isep.genielogiciel.dto.ExamDTO;
import fr.isep.genielogiciel.mapper.ExamMapper;
import fr.isep.genielogiciel.service.ExamService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ExamControllerTest {

    @MockBean
    private ExamService examService;

    @MockBean
    private ExamMapper examMapper;

    @Autowired
    MockMvc mockMvc;

    List<ExamDTO> examListDto = new ArrayList<>();
    List<String> agesList = Arrays.asList("18", "25", "30");
    List<String> countriesList = Arrays.asList("France", "Italie", "Espagne");
    List<String> recommendationsList = Arrays.asList("Diabète", "Hypertension");

    @Test
    public void getExamsTest() throws Exception {
        Mockito.when(examService.listExams(Mockito.any(), Mockito.any(Pageable.class))).thenReturn(new ArrayList<>());
        Mockito.when(examMapper.toDTO(Mockito.anyList())).thenReturn(examListDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/exams/list/paginated").contentType(MediaType.APPLICATION_JSON)
                        .param("filter", "age:20"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(examService, Mockito.times(1)).listExams(Mockito.any(), Mockito.any(Pageable.class));
    }

    @Test
    public void getAgesTest() throws Exception {
        Mockito.when(examService.getAges()).thenReturn(agesList);

        mockMvc.perform(MockMvcRequestBuilders.get("/exams/ages").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(examService, Mockito.times(1)).getAges();
    }

    @Test
    public void getCountriesTest() throws Exception {
        Mockito.when(examService.getCountries()).thenReturn(countriesList);

        mockMvc.perform(MockMvcRequestBuilders.get("/exams/countries").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(examService, Mockito.times(1)).getCountries();
    }

    @Test
    public void getRecommendationsTest() throws Exception {
        Mockito.when(examService.getRecommendation()).thenReturn(recommendationsList);

        mockMvc.perform(MockMvcRequestBuilders.get("/exams/recommendations").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(examService, Mockito.times(1)).getRecommendation();
    }
}
