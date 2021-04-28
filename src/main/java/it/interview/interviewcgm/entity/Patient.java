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
@Table(name = "patients")
@Data
@NoArgsConstructor
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String idpatients;
	private String name;
	private String surname;
	private String fiscalcode;
	private Date birthday;

	public Patient(String name, String surname, String fiscalcode, Date birthday) {
		super();
		this.name = name;
		this.surname = surname;
		this.fiscalcode = fiscalcode;
		this.birthday = birthday;
	}

}
