/*
 * @author Weijie Zeng
 * 		StonyBrook ID: 113452510
 * 		Recitation 01
 */

/*
 * The comparator class for missDistance
 */
public class MissDistanceComparator implements java.util.Comparator<NearEarthObject>{
	public int compare(NearEarthObject o1, NearEarthObject o2) {
		if(o1.getMissDistance() == o2.getMissDistance()) {
			return 0;
		}else if(o1.getMissDistance() < o2.getMissDistance()) {
			return -1;
		}else {
			return 1;
		}
	}
}