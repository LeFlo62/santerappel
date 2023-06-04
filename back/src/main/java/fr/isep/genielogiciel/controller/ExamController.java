package fr.isep.genielogiciel.controller;

import fr.isep.genielogiciel.dto.ExamDTO;
import fr.isep.genielogiciel.mapper.ExamMapper;
import fr.isep.genielogiciel.service.ExamService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/exams")
@RestController
@AllArgsConstructor
public class ExamController {

    private ExamService examService;
    private ExamMapper examMapper;


    @GetMapping("/list/paginated")
    public ResponseEntity<List<ExamDTO>> getExams(@RequestParam(value="filter", required = false) String filter, Pageable pageable) {
        MultiValueMap<String, String> filters = new LinkedMultiValueMap<>();
        System.out.println(filter);
        if(filter != null){
            String[] entries = filter.split(",");
            for(int i = 0; i < entries.length; ++i){
                String[] entry = entries[i].split(":");
                filters.add(entry[0], entry[1]);
            }
        }
        return ResponseEntity.ok(examMapper.toDTO(examService.listExams(filters, pageable)));
    }

    @GetMapping("/ages")
    public ResponseEntity<List<String>> getAges(){
        return ResponseEntity.ok(examService.getAges());
    }

    @GetMapping("/countries")
    public ResponseEntity<List<String>> getCountries(){
        return ResponseEntity.ok(examService.getCountries());
    }

    @GetMapping("/recommendations")
    public ResponseEntity<List<String>> getRecommendations(){
        return ResponseEntity.ok(examService.getRecommendation());
    }

}
