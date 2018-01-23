package com.studentapp2.junit.studentsInfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {
	
	@BeforeClass
	public static void ini(){
		RestAssured.baseURI="http://localhost:8080/student";
	}
	
	@Test
	public void getAllStudents(){
		//RestAssured.given()
		SerenityRest.given()
			.when()
			.get("/list")
			.then()
			.log()
			.all()
			.statusCode(200);
		
	}
	
	@Test
	public void thisIsaFailingTest(){
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.statusCode(500);
	}
	
	@Pending
	@Test
	public void thisIsaPendingTest(){
		
	}
	
	@Ignore
	@Test
	public void thisIsaSkippedTest(){
		
	}
	
	@Test
	public void thisIsaTestWithError(){
		System.out.println("This is an error"+(5/0));
		
	}
	
	@Test
	public void fileDoesNotExist() throws FileNotFoundException{
		File file = new File("E://file.txt");
		FileReader fr = new FileReader(file);
		
	}
	
	@Manual
	@Test
	public void thisIsaManualTest(){
		
	}
	
	@Title("This test will get the information of all the sudents from the Student APP")
	@Test
	public void test01(){
		//RestAssured.given()
		SerenityRest.given()
			.when()
			.get("/list")
			.then()
			.log()
			.all()
			.statusCode(200);
		
	}

}
