package fr.isep.genielogiciel.controller;

import fr.isep.genielogiciel.dto.ExamDTO;
import fr.isep.genielogiciel.mapper.ExamMapper;
import fr.isep.genielogiciel.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api")
@RestController
@AllArgsConstructor
public class ExamController {

    private ExamService examService;
    private ExamMapper examMapper;


    @GetMapping("/exams")
    public ResponseEntity<List<ExamDTO>> getExams(Pageable pageable) {
        return ResponseEntity.ok(examMapper.toDTO(examService.listExams(pageable)));
    }

}
