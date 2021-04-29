package it.interview.interviewcgm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.interview.interviewcgm.entity.Exam;
import it.interview.interviewcgm.entity.ExamInfo;
import it.interview.interviewcgm.entity.Patient;
import it.interview.interviewcgm.entity.ResultSubmit;
import it.interview.interviewcgm.services.ServiceExams;
import it.interview.interviewcgm.services.ServicePatient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

	@Autowired
	ServicePatient servicePatient;

	@Autowired
	ServiceExams serviceExams;

	@GetMapping("/getPatients")
	@ResponseBody
	public List<Patient> getPatients(@RequestParam String name, @RequestParam String surname) {
		log.info("GET method getPatients with params - name {} - surname {}", name, surname);
		List<Patient> response = servicePatient.getPatients(name, surname);
		log.info("GET method getPatients with response {}", response);
		return response;
	}

	@GetMapping("/getExams")
	@ResponseBody
	public List<Exam> getExams(@RequestParam String idpatient) {
		log.info("GET method getExams with params - idpatient {}", idpatient);
		List<Exam> response = serviceExams.getExamsForPatient(idpatient);
		log.info("GET method getExams with response {}", response);
		return response;
	}

	@PostMapping("/saveExam")
	public ResultSubmit saveExam(@RequestBody ExamInfo exam) {
		log.info("POST method saveExam with body - exam {}", exam);
		if(serviceExams.saveExam(exam)) {
			return new ResultSubmit("OK");
		}
		return new ResultSubmit("KO");
	}

	@PostMapping("/updateExam")
	public ResultSubmit updateExam(@RequestParam String idexam, @RequestBody ExamInfo exam) {
		log.info("POST method updateExam with body - exam {}", exam);
		if(serviceExams.updateExam(exam, idexam)) {
			return new ResultSubmit("OK");
		}
		return new ResultSubmit("KO");
	}
	
	@DeleteMapping("/deleteExam")
	public ResultSubmit deleteExam(@RequestParam String idexam) {
		log.info("DELETE method deleteExam with idexam {}", idexam);
		if(serviceExams.deleteExam(idexam)) {
			return new ResultSubmit("OK");
		}
		return new ResultSubmit("KO");
	}
}
