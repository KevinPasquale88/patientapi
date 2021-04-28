package it.interview.interviewcgm.services;

import java.util.Collections;
import java.util.List;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.interview.interviewcgm.entity.Patient;
import it.interview.interviewcgm.repository.RepositoryPatient;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServicePatient {

	@Autowired
	private RepositoryPatient repositoryPatient;

	public List<Patient> getPatients(String name, String surname) {
		log.info("ServicePatient - call query getPatients - name {} - surname {}", name, surname);
		try {
			return repositoryPatient.findByComplete(name, surname);
		} catch (Exception ex) {
			log.error(ExceptionUtils.getFullStackTrace(ex));
		}
		return Collections.emptyList();
	}
}
