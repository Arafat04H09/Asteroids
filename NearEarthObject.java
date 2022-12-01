import java.util.Date;

/*
 * This class represents a record in the database of asteroids currently tracked
 * by NASA. It should be noted that this class will always be constructed by the 
 * BigData library, and serves as a data container for the information that is 
 * already hosted by the NeoW API.
 */
public class NearEarthObject {
	private int referenceID;
	private	String name;
	private double absoluteMagnitude;
	private double averageDiameter;
	private boolean isDangerous;
	private Date closestApproachDate;
	private double missDistance;
	private String orbitingBody;
	
	/*
	 * default constructor
	 * @param referenceID
	 * 		Unique the ID of the NEO.
	 *		Fetched using the "near_earth_objects/neo_reference_id" identifier.
	 * @param name
	 * 		Unique name of the asteroid or orbital body.
	 * 		Fetched using the "near_earth_objects/name" identifier.
	 * @param absoluteMagnitude
	 * 		Absolute brightness of the asteroid or orbital body in the sky.
	 * 		Fetched using the "near_earth_objects/absolute_magnitude_h" identifier.
	 * @param minDiameter
	 * 		Estimated minimum diameter of the asteroid or orbital body in 
	 * 		kilometers. This parameter should be used in conjunction with the 
	 * 		maxDiameter parameter to calculate and initialize the averageDiameter 
	 * 		member variable. 
	 * 		Fetched using the "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min" 
	 * 		identifier.
	 * @param maxDiameter
	 * 		Estimated maximum diameter of the asteroid or orbital body in kilometers. 
	 * 		This parameter should be used in conjunction with the minDiameter parameter 
	 * 		to calculate and initialize the averageDiameter member variable.
	 * 		Fetched using the "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max" 
	 * 		identifier.
	 * @param isDangerous
	 * 		Boolean value indicating whether the astroid or orbital body is a 
	 * 		potential impact threat.
	 * 		Fetched using the "near_earth_objects/is_potentially_hazardous_asteroid" 
	 * 		identifier.
	 * @param closestTimestamp
	 * 		Unix timestamp representing the date of closest approach. Note that 
	 * 		this can be used to directly construct the closestApproachDate member 
	 * 		variable, as the Date class provides a constructor taking a timestamp 
	 * 		as a parameter.
	 * 		Fetched using the "near_earth_objects/close_approach_data/epoch_date_close_approach" 
	 * 		identifier.
	 * @param missDistance
	 * 		Distance in kilometers at which the asteroid or orbital body will 
	 * 		pass by the Earth on the date of it's closest approach.
	 * 		Fetched using the "near_earth_objects/close_approach_data/miss_distance/kilometers" 
	 * 		identifier.
	 * @param orbitingBody
	 * 		Planet or other orbital body which this NEO orbits.
	 * 		Fetched using the "near_earth_objects/close_approach_data/orbiting_body" 
	 * 		identifier.
	 * 
	 */
	public NearEarthObject(int referenceID, String name, double absoluteMagnitude,
			double minDiameter, double maxDiameter, boolean isDangerous, 
			long closestDateTimestamp, double missDistance, String orbitingBody) {
		this.referenceID = referenceID;
		this.name = name;
		this.absoluteMagnitude = absoluteMagnitude;
		this.averageDiameter = (minDiameter + maxDiameter)/2;
		this.isDangerous = isDangerous;
		Date d = new Date(closestDateTimestamp);
		closestApproachDate = d;
		this.missDistance = missDistance;
		this.orbitingBody = orbitingBody;
	}
	
	public int getReferenceID() {
		return referenceID;
	}
	
	public String getName() {
		return name;
	}
	
	public double getAbsoluteMagnitude() {
		return absoluteMagnitude;
	}
	
	public double getAverageDiameter() {
		return averageDiameter;
	}
	
	public boolean getIsDangerous() {
		return isDangerous;
	}
	
	public Date getClosestApproachDate() {
		return closestApproachDate;
	}
	
	public double getMissDistance() {
		return missDistance;
	}
	
	public String getOrbitingBody() {
		return orbitingBody;
	}
	
	public void setReferenceID(int r) {
		referenceID = r;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setAbsoluteMagnitude(double a) {
		absoluteMagnitude = a;
	}
	
	public void setAverageDiameter(double a) {
		averageDiameter = a;
	}
	
	public void setIsDangerous(boolean i) {
		isDangerous = i;
	}
	
	public void setClosestApproachDate(Date c) {
		closestApproachDate = c;
	}
	
	public void setMissDistance(double m) {
		missDistance = m;
	}
	
	public void setOrbitingBody(String o) {
		orbitingBody = o;
	}
}