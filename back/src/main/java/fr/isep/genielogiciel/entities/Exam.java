package fr.isep.genielogiciel.entities;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "exams")
public class Exam {

    private String name;

}
