package com.studentapp2.junit.studentsIdInfo;

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
public class FirstSerenityIdTest {
	
	@BeforeClass
	public static void ini(){
		RestAssured.baseURI="http://localhost:8080/student";
	}
	
	@Title("FirstSerenityIdTest.getAllStudents!")
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
	
	@Title("FirstSerenityIdTest.thisIsaFailingTest!")
	@Test
	public void thisIsaFailingTest(){
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.statusCode(500);
	}
	
	@Title("FirstSerenityIdTest.thisIsaSkippedTest!")
	@Pending
	@Test
	public void thisIsaSkippedTest(){
		
	}
	
	@Title("FirstSerenityIdTest.thisIsaPendingTest!")
	@Ignore
	@Test
	public void thisIsaPendingTest(){
		
	}
	
	@Title("FirstSerenityIdTest.thisIsaTestWithError!")
	@Test
	public void thisIsaTestWithError(){
		System.out.println("This is an error"+(5/0));
		
	}
	
	@Title("FirstSerenityIdTest.fileDoesNotExist!")
	@Test
	public void fileDoesNotExist() throws FileNotFoundException{
		File file = new File("E://file.txt");
		FileReader fr = new FileReader(file);
		
	}
	
	@Title("FirstSerenityIdTest.thisIsaManualTest!")
	@Manual
	@Test
	public void thisIsaManualTest(){
		
	}

}
