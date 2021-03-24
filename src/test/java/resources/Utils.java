package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	RequestSpecification req;
	ResponseSpecification resspec;
	
	public RequestSpecification RequestSpecification() throws IOException {
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		 req =new RequestSpecBuilder().setBaseUri(globalproperties("baseUrl")).addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .setContentType(ContentType.JSON).build();
		return req;
	}
   public ResponseSpecification ResponseSpecification() {
	   resspec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	   return resspec;
   }
   
   public String globalproperties(String key) throws IOException {
	  Properties prop= new Properties();
	  FileInputStream file = new FileInputStream("C:\\Users\\Onkar\\Desktop\\LocationServiceAutomation\\LocationService\\src\\test\\java\\resources\\global.properties");
      prop.load(file);
      return prop.getProperty(key);
      
   }
   
  
   
   
}
