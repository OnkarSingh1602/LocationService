Feature: Use different to update a location
@addPlace @Regression
Scenario Outline: Add Place
  Given Create a valid endpoint and a valid payload with "<name>" ,"<address>" and "<language>"
  When we hit the "addPlaceAPI" using "post" method
  And Validate the response is 200
  Then Validate the response "status" is "OK"
  Then Validate the response "scope" is "APP"
  And Print the "place_id" in the logs
  
  Examples:
  |name   |address        |language|
  |onkar  |sikar          |sapnish |
  |Riona  |Rajasthan      |English |
  
  @deleteplace @Regression
  Scenario: Delete Place
  Given Please enter the delete Place Payload
  When we hit the "deletePlaceAPI" using "post" method
  And Validate the response is 200
  Then Validate the response "status" is "OK"