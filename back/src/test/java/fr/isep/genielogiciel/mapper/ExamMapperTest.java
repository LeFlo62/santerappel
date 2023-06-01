package fr.isep.genielogiciel.mapper;

import fr.isep.genielogiciel.dto.ExamDTO;
import fr.isep.genielogiciel.entities.Exam;
import fr.isep.genielogiciel.service.ExamService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
    @ExtendWith(MockitoExtension.class)
    public class ExamMapperTest {
        @Mock
        private Exam exam;

    /**
     * Tests {@link ExamMapper#toDTO(Exam)}
     */
    @Test
    public void testToDTO() {
        ExamMapper examMapper = new ExamMapper();

        when(exam.getName()).thenReturn("Exam");

        ExamDTO examDTOTest = examMapper.toDTO(exam);

        assertEquals("Exam", examDTOTest.getName());
    }
}
