package TestCases;

import java.io.IOException;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ViewFarmCattle {
	
	@Test(groups= {"SmokeTest"})
	public void viewFarmCattle() throws IOException 
	{

		RestAssured.baseURI = "http://test.nitara.co.in";
		RequestSpecification request = RestAssured.given();

		Login user = new Login();
		String token = user.userLogin();

		JSONObject requestParams = new JSONObject();
		requestParams.put("farmId", "00e8b214-9776-4913-9c83-960c05d16aca"); // Cast 
		request.body(requestParams.toString());
		request.header("Content-Type", "application/json");
		request.header("Authorization","Bearer " + token);
		Response response = request.post("FM/ViewFarmCattleList");

		System.out.println("Response body: " + response.body().prettyPeek().asString());

		String jsonString = response.asString();				


		// Printing system response code
		System.out.println("Response code:" + response.getStatusCode());

		
		// Comparing expected result with actual result
		Assert.assertEquals(400, response.getStatusCode());
		
		

	}		

}
