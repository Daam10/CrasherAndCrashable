import java.util.Collection;
import java.util.function.Function;

import Interfaces.*;

public class MyApartaments extends AbstractApartaments<String, Integer>{
	public MyApartaments(Collection<Crashable<?, Integer>> toCrush, CrasherUI<Integer> crasher) {
		super(toCrush, crasher, new ConsolePrinter());
	}

	@Override
	String getOutputObject() {
		return "";
	}
}
