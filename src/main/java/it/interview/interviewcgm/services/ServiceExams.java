package it.interview.interviewcgm.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.interview.interviewcgm.entity.Exam;
import it.interview.interviewcgm.entity.ExamInfo;
import it.interview.interviewcgm.repository.RepositoryExams;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServiceExams {

	@Autowired
	private RepositoryExams repositoryExams;

	public int saveExam(ExamInfo examInfo) {
		log.info("ServiceExams - call query save Exam For Patient - patient {} - exam{}", examInfo.getIdPatient(),
				examInfo);
		try {
			Exam exam = repositoryExams.save(new Exam(examInfo));
			log.info("Exam saved {} ", exam);
		} catch (Exception ex) {
			log.error(ExceptionUtils.getFullStackTrace(ex));
			return -1;
		}
		return 0;
	}

	public List<Exam> getExamsForPatient(String idPatient) {
		log.info("ServiceExams - call query examsForPatient - idPatient {}", idPatient);
		try {
			return repositoryExams.findByIdPatient(idPatient);
		} catch (Exception ex) {
			log.error(ExceptionUtils.getFullStackTrace(ex));
		}
		return Collections.emptyList();
	}

	public Exam getExam(String idExam) {
		log.info("ServiceExams - call query getExam - idExam {}", idExam);
		try {
			Optional<Exam> exam = repositoryExams.findById(Long.valueOf(idExam));
			if (exam.isPresent())
				return exam.get();
		} catch (Exception ex) {
			log.error(ExceptionUtils.getFullStackTrace(ex));
		}
		return null;
	}

	public int updateExam(ExamInfo examInfo, String idExam) {
		log.info("ServiceExams - call query update idexam {} Exam For Patient - patient {} - exam{}", idExam,
				examInfo.getIdPatient(), examInfo);
		try {
			repositoryExams.deleteById(Long.valueOf(idExam));
			return saveExam(examInfo);
		} catch (Exception ex) {
			log.error(ExceptionUtils.getFullStackTrace(ex));
			return -1;
		}
	}
}
