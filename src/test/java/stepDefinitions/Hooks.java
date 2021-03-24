package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;


public class Hooks {
	
	
	
	  @Before("") public void beforeScenario() throws IOException { 
		  StepDefinition m= new StepDefinition();
		  if (m.Place_id==null) {
	  m.create_a_valid_endpoint_and_a_valid_payload_with_and(
	  "shakespear","London UK", "ENGLISH");
	  m.we_hit_the_using_method("addPlaceAPI", "POST");
	  m.print_the_in_the_logs("place_id");
	  
	  }
	 }
}
