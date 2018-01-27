package com.studentapp2.junit.studentsInfo;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp2.cucumber.serenity.StudentSerenitySteps;
import com.studentapp2.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;

//By default, Serenity will spin up 2 Thread per CPU Core!!!
//@Concurrent
//To define 2 Threads
@Concurrent(threads="2x")
//To tell where the test data from
//Just provide the folder under the resources folder and the file name
@UseTestDataFrom("testdata/studentinfo.csv")
//To tell Serenity the test is using data driven file and executed multiple times
@RunWith(SerenityParameterizedRunner.class)
public class CreateStudentsDataDrivenTest extends TestBase{
	
	//PLEASE NOTE: The column name in csv file must match to the private member variable!
	//Otherwise, it won't get recognized 
	
	private String firstName;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public StudentSerenitySteps getSteps() {
		return steps;
	}
	public void setSteps(StudentSerenitySteps steps) {
		this.steps = steps;
	}
	private String lastName;
	private String email;
	private String programme;
	private String course;
	
	@Steps
	StudentSerenitySteps steps;
	
	@Title("Data Driven Test for adding multiple students to the Student App.")
	@Test
	public void createMultipleStudents(){
		ArrayList<String> courses = new ArrayList<String>();
		courses.add(course);
		steps.createStudent(firstName, lastName, email, programme, courses)
		.statusCode(201);
	}

}
