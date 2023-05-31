package fr.isep.genielogiciel.mapper;

import fr.isep.genielogiciel.dto.ExamDTO;
import fr.isep.genielogiciel.entities.Exam;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExamMapper {

    public List<ExamDTO> toDTO(List<Exam> entities){
        return entities.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public ExamDTO toDTO(Exam exam) {
        return ExamDTO.builder()
                .id(exam.getId())
                .age(exam.getAge())
                .bigDescription(exam.getBigDescription())
                .countryList(exam.getCountryList())
                .description(exam.getDescription())
                .familyBackground(exam.getFamilyBackground())
                .isVaccine(exam.isVaccine())
                .name(exam.getName())
                .personalBackground(exam.getPersonalBackground())
                .recommendation(exam.getRecommendation())
                .sex(exam.getSex())
                .build();
    }
}
