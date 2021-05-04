package it.interview.interviewcgm.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

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

import it.interview.interviewcgm.entity.Patient;
import it.interview.interviewcgm.repository.RepositoryPatient;

@RunWith(SpringRunner.class)
public class ServicePatientTest {

	@TestConfiguration
	static class ServicePatientImplTestContextConfiguration {
		@Bean
		public ServicePatient servicePatient() {
			return new ServicePatient();
		}
	}

	@Autowired
	private ServicePatient servicePatient;

	@MockBean
	private RepositoryPatient repositoryPatient;

	@Before
	public void setUp() {
		Mockito.when(repositoryPatient.findByComplete(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(Arrays.asList(new Patient(), new Patient()));
	}
	
	@Test
	public void should_test_get_patients() {
		List<Patient> list = servicePatient.getPatients("", "");
		assertNotNull(list);
		assertFalse(list.isEmpty());
	}
}
