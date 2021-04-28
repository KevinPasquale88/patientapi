package it.interview.interviewcgm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.interview.interviewcgm.entity.Patient;

@Repository
public interface RepositoryPatient extends JpaRepository<Patient, String> {

	@Query("SELECT p FROM Patient p WHERE p.name LIKE %:name AND p.surname LIKE %:surname")
	public List<Patient> findByComplete(@Param("name") String name, @Param("surname") String surname);

}
