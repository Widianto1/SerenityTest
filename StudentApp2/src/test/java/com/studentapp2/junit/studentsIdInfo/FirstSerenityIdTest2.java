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
public class FirstSerenityIdTest2 {
	
	@BeforeClass
	public static void ini(){
		RestAssured.baseURI="http://localhost:8080/student";
	}
	
	@Title("FirstSerenityIdTest2.getAllStdents!")
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
	
	@Title("FirstSerenityIdTest2.thisIsaFailingTest!")
	@Test
	public void thisIsaFailingTest(){
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.statusCode(500);
	}
	
	@Title("FirstSerenityIdTest2.thisIsaPendingTest!")
	@Pending
	@Test
	public void thisIsaPendingTest(){
		
	}
	
	@Title("FirstSerenityIdTest2.thisIsaSkippedTest!")
	@Ignore
	@Test
	public void thisIsaSkippedTest(){
		
	}
	
	@Title("FirstSerenityIdTest2.thisIsaTestWithError!")
	@Test
	public void thisIsaTestWithError(){
		System.out.println("This is an error"+(5/0));
		
	}
	
	@Title("FirstSerenityIdTest2.fileDoesNotExist!")
	@Test
	public void fileDoesNotExist() throws FileNotFoundException{
		File file = new File("E://file.txt");
		FileReader fr = new FileReader(file);
		
	}
	
	@Title("FirstSerenityIdTest2.thisIsaManualTest!")
	@Manual
	@Test
	public void thisIsaManualTest(){
		
	}

}
