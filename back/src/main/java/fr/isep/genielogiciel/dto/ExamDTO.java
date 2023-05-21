package fr.isep.genielogiciel.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ExamDTO {

    private String id;
    private String name;
    private String description;
    private String recommendation;
    private boolean isVaccine;
    private List<String> countryList;
    private List<String> age;

}
