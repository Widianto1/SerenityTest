package com.studentapp2.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class ReusableSpecifications {
	public static RequestSpecBuilder rspec;
	public static RequestSpecification requestSpecification;
	
	public static ResponseSpecBuilder respSpec;
	public static ResponseSpecification responseSpecification;

	public static RequestSpecification getGenericRequestSpec(){
		rspec = new RequestSpecBuilder();
		rspec.setContentType(ContentType.JSON);
		requestSpecification = rspec.build();
		return requestSpecification;
	}
	
	public static ResponseSpecification getGenericResponseSpec(){
		respSpec = new ResponseSpecBuilder();
		respSpec.expectHeader("Content-Type", "application/json;charset=UTF-8");
		respSpec.expectHeader("Transfer-Encoding", "chunked");
		//To check if the response is coming back within certain time threshold otherwise it will FAIL
		//In this case, 5 SECONDS
		respSpec.expectResponseTime(lessThan(5L), TimeUnit.SECONDS);
		responseSpecification = respSpec.build();
		return responseSpecification;
	}
}
