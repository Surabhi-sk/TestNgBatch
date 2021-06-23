package TestCases;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Login {

@Test(groups= {"SmokeTest"})
public void login() {
		
		
		RestAssured.baseURI = "http://test.nitara.co.in";
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("countryCode", "+91"); // Cast
		requestParams.put("phone", "888888888");
		requestParams.put("Password", "Password@234");
		requestParams.put("deviceName", "DELL_PC"); 		 
		requestParams.put("deviceType",  "LAPTOP");

		request.body(requestParams.toString());

		request.header("Content-Type", "application/json");

		Response response = request.post("/AM/Login");

		int  statusCode = response.getStatusCode();

		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.body().prettyPeek().asString());


		String jsonString = response.asString();
		String token = JsonPath.from(jsonString).get("token");
		Assert.assertEquals(400, response.getStatusCode());
	
	}

public String userLogin() {
	
	
	RestAssured.baseURI = "http://test.nitara.co.in";
	RequestSpecification request = RestAssured.given();
	
	JSONObject requestParams = new JSONObject();
	requestParams.put("countryCode", "+91"); // Cast
	requestParams.put("phone", "888888888");
	requestParams.put("Password", "Password@234");
	requestParams.put("deviceName", "DELL_PC"); 		 
	requestParams.put("deviceType",  "LAPTOP");

	request.body(requestParams.toString());

	request.header("Content-Type", "application/json");

	Response response = request.post("/AM/Login");

	int  statusCode = response.getStatusCode();

	System.out.println("The status code recieved: " + statusCode);

	System.out.println("Response body: " + response.body().prettyPeek().asString());


	String jsonString = response.asString();
	String token = JsonPath.from(jsonString).get("token");
	
	return token;

}


}
