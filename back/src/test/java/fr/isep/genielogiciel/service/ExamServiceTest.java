package fr.isep.genielogiciel.service;

public class ExamServiceTest {

<<<<<<< Updated upstream
    public void listExamsTest() {

    }

=======
    @Mock
    private ExamRepository examRepository;

    @Mock
    private Pageable pageable;

    @Mock
    private Page pageMock;

    @InjectMocks
    private ExamService examService;

    /**
     * Tests {@link ExamService#listExams(MultiValueMap, Pageable)}
     */
    @Test
    public void listExams() {
        MultiValueMap<String, String> filters = new LinkedMultiValueMap<>();

        List<Exam> mockList = new ArrayList<>();
        mockList.add(Exam.builder().name("Examen prostate").build());
        mockList.add(Exam.builder().name("Examen vésicule biliaire").build());
        mockList.add(Exam.builder().name("Examen thyroïde").build());

        Mockito.when(pageMock.getContent()).thenReturn(mockList);

        Mockito.when(examRepository.filter(filters, pageable)).thenReturn(pageMock);

        List<Exam> examListTest = examService.listExams(filters, pageable);

        Assertions.assertThat(examListTest).hasSize(mockList.size());
        Assertions.assertThat(examListTest).allMatch(mockList::contains);

        Mockito.verify(examRepository).filter(filters, pageable);
        Mockito.verify(pageMock).getContent();
    }

    /**
     * Tests {@link ExamService#getAges()}
     */
    @Test
    public void getAges(){
        List<String> mock = List.of("12", "24", "32");

        Mockito.when(examRepository.findDistinctAge()).thenReturn(mock);

        List<String> test = examService.getAges();

        Assertions.assertThat(test).hasSize(mock.size());
        Assertions.assertThat(test).allMatch(mock::contains);

        Mockito.verify(examRepository).findDistinctAge();
    }

    /**
     * Tests {@link ExamService#getCountries()}
     */
    @Test
    public void getCountries(){
        List<String> mock = List.of("France", "Inde", "Canada");

        Mockito.when(examRepository.findDistinctCountryNames()).thenReturn(mock);

        List<String> test = examService.getCountries();

        Assertions.assertThat(test).hasSize(mock.size());
        Assertions.assertThat(test).allMatch(mock::contains);

        Mockito.verify(examRepository).findDistinctCountryNames();
    }

    /**
     * Tests {@link ExamService#getRecommendation()}
     */
    @Test
    public void getRecommendation(){
        List<String> mock = List.of("Enfant", "Grossesse");

        Mockito.when(examRepository.findDistinctRecommendation()).thenReturn(mock);

        List<String> test = examService.getRecommendation();

        Assertions.assertThat(test).hasSize(mock.size());
        Assertions.assertThat(test).allMatch(mock::contains);

        Mockito.verify(examRepository).findDistinctRecommendation();
    }
>>>>>>> Stashed changes
}
