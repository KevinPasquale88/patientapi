package it.interview.interviewcgm.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import it.interview.interviewcgm.entity.Exam;
import it.interview.interviewcgm.entity.ExamInfo;
import it.interview.interviewcgm.repository.RepositoryExams;

@RunWith(SpringRunner.class)
public class ServiceExamsTest {

	@TestConfiguration
	static class ServiceExamsImplTestContextConfiguration {
		@Bean
		public ServiceExams serviceExams() {
			return new ServiceExams();
		}
	}

	@Autowired
	private ServiceExams serviceExams;

	@MockBean
	private RepositoryExams repositoryExams;

	@Before
	public void setUp() {
		Mockito.when(repositoryExams.save(Mockito.any())).thenReturn(new Exam());
		Mockito.when(repositoryExams.findByIdPatient(Mockito.anyString())).thenReturn(Arrays.asList(new Exam()));
	}

	@Test
	public void should_test_save_exam() {
		ExamInfo examInfo = new ExamInfo();
		assertTrue(serviceExams.saveExam(examInfo));
	}

	@Test
	public void should_test_list_exams_for_idpatient() {
		List<Exam> list = serviceExams.getExamsForPatient("");
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}

	@Test
	public void should_test_update_exam() {
		ExamInfo examInfo = new ExamInfo();
		assertTrue(serviceExams.updateExam(examInfo, "123"));
	}
	
	@Test
	public void should_test_delete_exam() {
		assertTrue(serviceExams.deleteExam("123"));
	}
}
