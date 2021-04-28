package it.interview.interviewcgm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.interview.interviewcgm.entity.Exam;

@Repository
public interface RepositoryExams extends JpaRepository<Exam, Long> {

	@Query(value = "SELECT e FROM Exam e WHERE e.idpatients = :idpatients")
	public List<Exam> findByIdPatient(@Param("idpatients") String idpatients);

}
