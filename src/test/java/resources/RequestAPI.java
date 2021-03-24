package resources;

public enum RequestAPI {
	addPlaceAPI("maps/api/place/add/json"),
	getPlaceAPI("maps/api/place/get/json"),
	deletePlaceAPI("maps/api/place/delete/json");
	
	private String resource;
	RequestAPI(String resource){
		this.resource=resource;
	
	}
	
 public String getresource() {
	 return resource;
 }
	
}
