package it.interview.interviewcgm.entity;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ExamInfo {

	private Date dateexam;

	private String hourexam;

	private String examtype;

	private String justification;

	private String anamnesis;
	
	private String idPatient;
}
