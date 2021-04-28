package it.interview.interviewcgm.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "exams")
@Data
@NoArgsConstructor
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idexams;

	private Date dateexam;

	private String hourexam;

	private String examtype;

	private String justification;

	private String anamnesis;

	private String idpatients;

	public Exam(Date dateexam, String hourexam, String examtype, String justification, String anamnesis,
			String idpatients) {
		super();
		this.dateexam = dateexam;
		this.hourexam = hourexam;
		this.examtype = examtype;
		this.justification = justification;
		this.anamnesis = anamnesis;
		this.idpatients = idpatients;
	}

	public Exam(ExamInfo examinfo) {
		super();
		this.dateexam = examinfo.getDateexam();
		this.hourexam = examinfo.getHourexam();
		this.examtype = examinfo.getExamtype();
		this.justification = examinfo.getJustification();
		this.anamnesis = examinfo.getAnamnesis();
		this.idpatients = examinfo.getIdPatient();

	}

}
