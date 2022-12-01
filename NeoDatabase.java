/*
 * @author Weijie Zeng
 * 		StonyBrook ID: 113452510
 * 		Recitation 01
 * 
 * 
 * NeoDatabase will contain and manage the NearEarthObject records which have 
 * been downloaded from the online dataset. The specific data structure used to 
 * implement this database is up to you - any Java API class may be used or customized 
 * for this purpose. 
 * 
 */



import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import big.data.DataSource;



public class NeoDatabase{
	public static final String API_KEY = "uWQ7SDCsT8fhg466AMTiNqFcsrrOyPBno4WjVTzK";
	public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";
	ArrayList<NearEarthObject> myDatas = new ArrayList<NearEarthObject>();
	
	
	/*
	 * default constructor
	 * <dd>Postconditions:
	 * 		<dt>The database has been constructed and is empty.
	 */
	public NeoDatabase() {
	}
	
	/*
	 * Builds a query URL given a page number. This should be a simple method which 
	 * returns (API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY)
	 * @param pageNumber
	 * 		0 ≤ page ≤ 715.
	 * @exception IllegalArgumentException
	 * 		throws if pageNumber is not in the valid range
	 */
	public String buildQueryURL(int pageNumber) throws IllegalArgumentException{
		if (pageNumber < 0 || pageNumber>715) {
			throw new IllegalArgumentException("page number out of bound.");
		}
		return API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY;
	}
	
	/*
	 * Opens a connection to the data source indicated by queryURL and adds all 
	 * NearEarthObjects found in the dataset.
	 * @param queryURL
	 * 		String containing the URL requesting a dataset from the NASA NeoW service.
	 * <dd>Preconditions:
	 * 		<dt>queryURL is a non-null string representing a valid API request to 
	 * 		the NASA NeoW service.
	 * <dd>Postconditions:
	 * 		<dt>All NearEarthObject records returned have been added to the database, 
	 * 		or else a IllegalArgumentException has been thrown.
	 * @exception IllegalArgumentException
	 * 		throws if queryURL is null or could not be resolved by the server.
	 */
	public void addAll(String queryURL) throws IllegalArgumentException{
		if(queryURL == null) {
			throw new IllegalArgumentException("url is null.");
		}
		DataSource ds = DataSource.connectJSON(queryURL);
		ds.load();
		NearEarthObject[] objects = ds.fetchArray("NearEarthObject", "near_earth_objects/neo_reference_id",
				"near_earth_objects/name", "near_earth_objects/absolute_magnitude_h",
				"near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min",
				"near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max",
				"near_earth_objects/is_potentially_hazardous_asteroid",
				"near_earth_objects/close_approach_data/epoch_date_close_approach",
				"near_earth_objects/close_approach_data/miss_distance/kilometers",
				"near_earth_objects/close_approach_data/orbiting_body");	
		for(int i = 0; i < objects.length; i++) {
			myDatas.add(objects[i]);
		}
	}
	
	/*
	 * Sorts the database using the specified Comparator of NearEarthObjects.
	 * @param comp
	 * 		Comparator of NearEarthObjects which will be used to sort the database.
	 * <dd>Preconditions:
	 * 		<dt>comp is not null.
	 * <dd>Postconditions:
	 * 		<dt>The database has been sorted based on the order specified by the 
	 * 		inidcated Comparator of NearEarthObjects.
	 * @exception IllegalArgumentException
	 * 		throws if comp is null.
	 */
	public void sort(Comparator<NearEarthObject> comp) throws IllegalArgumentException {
		if (comp == null) {
			throw new IllegalArgumentException("comp is null.");
		}
		Collections.sort(myDatas, comp);
	}
	
	/*
	 * Displays the database in a neat, tabular form, listing all member variables 
	 * for each NearEarthObject. 
	 * <dt>Preconditions:
	 * 		<dd>This NeoDatabase is initialized and not null.
	 * <dt>Postconditions:
	 * 		<dt>The table has been printed to the console but remains unchanged.
	 */
	public void printTable() {
		System.out.printf("%7s%4s%10s%5s%5s%2s%9s%2s%7s%2s%11s%2s%"
				+ "10s%2s%8s", "ID", "|", "Name", "|", "Mag.", "|", "Diameter", 
				"|", "Danger", "|", "Close Date", "|", "Miss Dist", "|", "Orbits\n");
		System.out.println("===================================================="
				+ "==================================");
		
	}
}