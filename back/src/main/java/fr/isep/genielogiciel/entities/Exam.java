package fr.isep.genielogiciel.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "exams")
public class Exam {

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
