package it.interview.interviewcgm.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import it.interview.interviewcgm.entity.Exam;
import it.interview.interviewcgm.entity.ExamInfo;
import it.interview.interviewcgm.entity.Patient;
import it.interview.interviewcgm.entity.ResultSubmit;

@Ignore
public class PatientControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}

	@Test
	public void should_test_getPatients() throws Exception {
		String uri = "/getPatients";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri).param("name", "roberto")
				.param("surname", "pasquale").accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Patient[] productlist = super.mapFromJson(content, Patient[].class);
		assertTrue(productlist.length > 0);
	}

	@Test
	public void should_test_getExams() throws Exception {
		String uri = "/getExams";
		MvcResult mvcResult = mvc
				.perform(MockMvcRequestBuilders.get(uri).param("name", "123").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = mvcResult.getResponse().getContentAsString();
		Exam[] examlist = super.mapFromJson(content, Exam[].class);
		assertTrue(examlist.length > 0);
	}

	@Test
	public void should_test_save_exam() throws Exception {
		String uri = "/saveExam";
		ExamInfo examInfo = new ExamInfo();
		examInfo.setDateexam(Date.valueOf(LocalDate.now()));
		examInfo.setAnamnesis("test");
		examInfo.setExamtype("Domiciliare");
		examInfo.setJustification("Prima Visita");
		examInfo.setIdPatient("123");
		String inputJson = super.mapToJson(examInfo);
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String resultSubmit = mvcResult.getResponse().getContentAsString();
		ResultSubmit submit = super.mapFromJson(resultSubmit, ResultSubmit.class);
		assertEquals(submit.getResult(), "OK");
	}

	@Test
	public void should_test_update_exam() throws Exception {
		String uri = "/updateExam";
		ExamInfo examInfo = new ExamInfo();
		examInfo.setDateexam(Date.valueOf(LocalDate.now()));
		examInfo.setAnamnesis("test");
		examInfo.setExamtype("Domiciliare");
		examInfo.setJustification("Prima Visita");
		examInfo.setIdPatient("123");

		String inputJson = super.mapToJson(examInfo);
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri).param("idexam", "2")
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String resultSubmit = mvcResult.getResponse().getContentAsString();
		ResultSubmit submit = super.mapFromJson(resultSubmit, ResultSubmit.class);
		assertEquals(submit.getResult(), "OK");
	}

	@Test
	public void should_test_delete_exam() throws Exception {
		String uri = "/deleteExam";
		MvcResult mvcResult = mvc.perform(
				MockMvcRequestBuilders.delete(uri).param("idexam", "2").accept(MediaType.APPLICATION_JSON_VALUE))
				.andReturn();

		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String resultSubmit = mvcResult.getResponse().getContentAsString();
		ResultSubmit submit = super.mapFromJson(resultSubmit, ResultSubmit.class);
		assertEquals(submit.getResult(), "OK");
	}
}
