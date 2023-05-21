package fr.isep.genielogiciel.mapper;

import fr.isep.genielogiciel.dto.ExamDTO;
import fr.isep.genielogiciel.entities.Exam;
import org.springframework.stereotype.Component;

@Component
public class ExamMapper implements EntityToDTOMapper<Exam, ExamDTO> {
    @Override
    public ExamDTO toDTO(Exam exam) {
        return ExamDTO.builder()
                .id(exam.getId())
                .name(exam.getName())
                .description(exam.getDescription())
                .recommendation(exam.getRecommendation())
                .isVaccine(exam.isVaccine())
                .age(exam.getAge())
                .countryList(exam.getCountryList())
                .build();
    }
}
