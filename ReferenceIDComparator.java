/*
 * @author Weijie Zeng
 * 		StonyBrook ID: 113452510
 * 		Recitation 01
 */

/*
 * THe comparator class for referenceID
 */
public class ReferenceIDComparator implements java.util.Comparator<NearEarthObject> {
	/*
	 * The compare method for referenceID
	 */
	public int compare(NearEarthObject o1, NearEarthObject o2) {
		if(o1.getReferenceID() == o2.getReferenceID()) {
			return 0;
		}else if(o1.getReferenceID() < o2.getReferenceID()) {
			return -1;
		}else{
			return 1;
		}
	}
	
	
}