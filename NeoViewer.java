/*
 * @author Weijie Zeng
 * 		StonyBrook ID: 113452510
 * 		Recitation 01
 */

import java.util.Scanner;
/*
 * NeoViewer allows a user to view datasets obtained from the NASA NeoW API.
 */
public class NeoViewer {
	/*
	 * The main method runs a menu driven application which creates a NeoDatabase 
	 * instance and then prompts the user for a menu command selecting the operation.
	 */
	public static void main(String[] args) {
		NeoDatabase n = new NeoDatabase();
		Scanner stdin = new Scanner(System.in);
		System.out.println("  Welcome to NEO Viewer!");
		String option;
		do {
			System.out.println("\n  Option Menu:");
			System.out.println("    A) Add a page to the database");
			System.out.println("    S) Sort the database");
			System.out.println("    P) Print the database as a table.");
			System.out.println("    Q) Quit\n");
			System.out.print("  Select a menu option: ");
			option = stdin.nextLine();
			switch(option) {
				case("a"):
				case("A"):
					System.out.print("\n  Enter the page to load: ");
					int page = stdin.nextInt();
					String url = n.buildQueryURL(page);
					n.addAll(url);
					System.out.println("\n  Page loaded successfully!");
					stdin.nextLine();
					break;
				case("s"):
				case("S"):
					System.out.println("\n  R) Sort by referenceID");
					System.out.println("  D) Sort by diameter");
					System.out.println("  A) Sort by approach date");
					System.out.println("  M) Sort by miss distance");
					System.out.println("\n  Select a menu option: ");
					String o = stdin.nextLine();
					switch (o) {
						case("r"):
						case("R"):
							ReferenceIDComparator r = new ReferenceIDComparator();
							n.sort(r);
							System.out.println("  Table sorted on referenceID");
							break;
						case("d"):
						case("D"):
							DiameterComparator d = new DiameterComparator();
							n.sort(d);
							System.out.println("    Table sorted on diameter");
							break;
						case("a"):
						case("A"):
							ApproachDateComparator a = new ApproachDateComparator();
							n.sort(a);
							System.out.println("    Table sorted on approach date");
							break;
						case("m"):
						case("M"):
							MissDistanceComparator m = new MissDistanceComparator();
							n.sort(m);
							System.out.println("    Table sorted on miss distance");
							break;
					}
					break;
				case("p"):
				case("P"):
					n.printTable();
					break;
				default:
					System.out.println("Please enter an option in the menu.");
					break;
			}
		}while (!option.equals("q") || !option.equals("Q"));
	}
}