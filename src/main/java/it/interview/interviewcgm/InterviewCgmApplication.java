package it.interview.interviewcgm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InterviewCgmApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewCgmApplication.class, args);
	}

}
