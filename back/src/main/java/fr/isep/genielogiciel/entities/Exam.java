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
    private String name;
    private String description;
    private String recommendation;
    private boolean isVaccine;
    private List<String> countryList;
    private List<String> age;

}
