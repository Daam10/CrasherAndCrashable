
import java.util.*;

import Interfaces.Crashable;

public class Main {

	public static void main(String[] args) {
		List<Crashable<?, Integer>> things = new ArrayList<Crashable<?, Integer>>(4);
		
		things.add(new Thing("Vase", 5));
		things.add(new Thing("Phone", 40));
		things.add(new Thing("Bread", 8));
		things.add(new Thing("Table", 50));
		things.add(new ThingIntInput("Returns integer as input", 20));
		ManWithHammer hammer = new ManWithHammer(30);
		MyApartaments appartaments = new MyApartaments(things, hammer);
		
		for(int i = 0; i < things.size(); i++) {
			appartaments.crashNext();
		}
		appartaments.pullToUserOutputs();
	}

}