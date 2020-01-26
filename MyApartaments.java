import java.util.Collection;
import java.util.function.Function;

import Interfaces.*;

public class MyApartaments extends AbstractApartaments<String, String, Integer>{
	public MyApartaments(Collection<Thing> toCrush, CrasherUI<Integer> crasher) {
		super(toCrush, crasher, new ConsolePrinter());
	}
}
