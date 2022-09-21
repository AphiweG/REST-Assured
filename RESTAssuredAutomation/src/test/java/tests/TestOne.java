package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class TestOne {
	
	@Test
	public void test_1() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeaders());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		//Assert.assertEquals(statusCode, 201); negative test
	}
	
	@Test
	public void test_2() {
		
		baseURI = "https://reqres.in/api";
		given().
			get("users?page=2").
		then().
			statusCode(200).
			body("data.id[1]", equalTo(8)).and().log().all();
	}

}
