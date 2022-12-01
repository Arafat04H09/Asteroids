/*
 * @author Weijie Zeng
 * 		StonyBrook ID: 113452510
 * 		Recitation 01
 */

/*
 * The comparator class for closestApproachDate
 */
public class ApproachDateComparator implements java.util.Comparator<NearEarthObject>{
	/*
	 * The compare method for closestApproachDate
	 */
	public int compare(NearEarthObject o1, NearEarthObject o2) {
		if (o1.getClosestApproachDate().compareTo(o2.getClosestApproachDate()) == 0) {
			return 0;
		}else if(o1.getClosestApproachDate().before(o2.getClosestApproachDate())) {
			return -1;
		}else {
			return 1;
		}
	}

}