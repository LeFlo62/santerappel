package fr.isep.genielogiciel.mapper;

import fr.isep.genielogiciel.dto.ExamDTO;
import fr.isep.genielogiciel.entities.Exam;
import org.springframework.stereotype.Component;

@Component
public class ExamMapper implements EntityToDTOMapper<Exam, ExamDTO> {
    @Override
    public ExamDTO toDTO(Exam exam) {
        return ExamDTO.builder()
                .name(exam.getName())
                .build();
    }
}
