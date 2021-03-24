package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.IOException;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.RequestAPI;
import resources.TestData;
import resources.Utils;

public class StepDefinition extends Utils {
	
	
	RequestSpecification res;
	static Response response;
	String resp;
	TestData data= new TestData();
	String Place_id;
	
	@Given("Create a valid endpoint and a valid payload with {string} ,{string} and {string}")
	public RequestSpecification create_a_valid_endpoint_and_a_valid_payload_with_and(String name, String address, String language) throws IOException {
	
		 res=given().spec(RequestSpecification())
				 .body(data.Placedetail(name,address,language));
		  return res;
	}
	
	@When("we hit the {string} using {string} method")
	public void we_hit_the_using_method(String resource, String method) {
		 
		RequestAPI resourceapi=RequestAPI.valueOf(resource);
		
		if(method.equalsIgnoreCase("POST"))
		response =res.when().post(resourceapi.getresource());
		
		else if  (method.equalsIgnoreCase("GET"))
		response =res.when().get(resourceapi.getresource());
				
		
		
	}
	@And ("Return the response")
	public Response Return_the_response() {
		return response;
	}
	@Then("Validate the response {string} is {string}")
	public void validate_the_response_is(String string, String string2) {
	    resp=response.asString();
	   JsonPath js =new JsonPath(resp);
	   assertEquals(js.getString(string).toString(),string2);
		 
	}
	@And("Print the {string} in the logs")
	public String print_the_in_the_logs(String string) {
	          resp=response.asString();
		      JsonPath js =new JsonPath(resp);
		      System.out.println(js.getString(string).toString());
		       Place_id=js.getString("place_id").toString();
		      return Place_id;
	    
		 
	}
	@And("Validate the response is {int}")
	public void validate_the_response_is(Integer int1) {
		 resp=response.asString();
		 assertEquals(response.getStatusCode(),200);
	
	}
	@Given("Please enter the delete Place Payload")
	public RequestSpecification please_enter_the_delete_place_payload() throws IOException {
		 resp=response.asString();
		   JsonPath js =new JsonPath(resp);
		String Place_id= js.getString("place_id");
		res=given().spec(RequestSpecification())
				 .body(data.DeletePlace(Place_id));
		  return res;
	    
	}

}
