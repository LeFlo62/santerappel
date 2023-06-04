package fr.isep.genielogiciel.mapper;

import fr.isep.genielogiciel.dto.ExamDTO;
import fr.isep.genielogiciel.entities.Exam;
import fr.isep.genielogiciel.service.ExamService;
import org.assertj.core.api.Assertions;
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

    private Exam mock;

    @BeforeEach
    public void setData(){
        this.mock = Exam.builder()
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
        ExamDTO test = examMapper.toDTO(this.mock);

        assertEquals(this.mock.getId(), test.getId());
        Assertions.assertThat(test.getAge()).hasSize(this.mock.getAge().size());
        Assertions.assertThat(test.getAge()).allMatch(this.mock.getAge()::contains);
        assertEquals(this.mock.getBigDescription(), test.getBigDescription());
        Assertions.assertThat(test.getCountryList()).hasSize(this.mock.getCountryList().size());
        Assertions.assertThat(test.getCountryList()).allMatch(this.mock.getCountryList()::contains);
        assertEquals(this.mock.getDescription(), test.getDescription());
        assertEquals(this.mock.getFamilyBackground(), test.getFamilyBackground());
        assertEquals(this.mock.isVaccine(), test.isVaccine());
        assertEquals(this.mock.getName(), test.getName());
        assertEquals(this.mock.getPersonalBackground(), test.getPersonalBackground());
        Assertions.assertThat(test.getRecommendation()).hasSize(this.mock.getRecommendation().size());
        Assertions.assertThat(test.getRecommendation()).allMatch(this.mock.getRecommendation()::contains);
        Assertions.assertThat(test.getSex()).hasSize(this.mock.getSex().size());
        Assertions.assertThat(test.getSex()).allMatch(this.mock.getSex()::contains);
    }

}
