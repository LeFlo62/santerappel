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
    private List<String> age;
    private String bigDescription;
    private List<String> countryList;
    private String description;
    private String familyBackground;
    private boolean isVaccine;
    private String name;
    private String personalBackground;
    private List<String> recommendation;
    private List<String> sex;

}
