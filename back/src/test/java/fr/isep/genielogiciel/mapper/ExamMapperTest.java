package fr.isep.genielogiciel.mapper;

<<<<<<< Updated upstream
public class ExamMapperTest {

=======
import fr.isep.genielogiciel.dto.ExamDTO;
import fr.isep.genielogiciel.entities.Exam;
import fr.isep.genielogiciel.service.ExamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class ExamMapperTest {
    private ExamMapper examMapper = new ExamMapper();

    private ExamDTO mock;

    @BeforeEach
    public void setData(){
        this.mock = ExamDTO.builder()
                .id(UUID.randomUUID().toString())
                .age(List.of("12", "13", "15", "17", "19", "21"))
                .bigDescription("Big description")
                .countryList(List.of("France", "Canada"))
                .description("Description")
                .familyBackground("Family background")
                .isVaccine(true)
                .name("Vaccin contre la rubéole ")
                .personalBackground("Personal background")
                .recommendation(List.of("Enfant", "Grossesse"))
                .sex(List.of("H", "F"))
                .build();
    }

    /**
     * Tests {@link ExamMapper#toDTO(Exam)}
     */
    @Test
    public void toDTO() {

    }
>>>>>>> Stashed changes
}
