/*
 * @author Weijie Zeng
 * 		StonyBrook ID: 113452510
 * 		Recitation 01
 */

/*
 * The comparator class for averageDiameter
 */
public class DiameterComparator implements java.util.Comparator<NearEarthObject>{
	/*
	 * The compare method for averageDiameter
	 */
	public int compare(NearEarthObject o1, NearEarthObject o2) {
		if(o1.getAverageDiameter() == o2.getAverageDiameter()) {
			return 0;
		}else if(o1.getAverageDiameter() < o2.getAverageDiameter()) {
			return -1;
		}else {
			return 1;
		}
	}
}