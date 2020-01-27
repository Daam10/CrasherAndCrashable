import java.util.Comparator;

import Interfaces.Crashable;
import Interfaces.CrasherAndCrashableComparator;
import Interfaces.CrasherUI;

public class ManWithHammerComparator implements CrasherAndCrashableComparator<ManWithHammer>{

	@Override
	public boolean canCrash(ManWithHammer crasher, Crashable crashable) throws Error {
		if(crashable.getClass() == Thing.class || crashable.getClass() == ThingIntInput.class) {
			return ((Integer) crasher.getToBreakDeterminator()) - ((Integer) crashable.getToBreakDeterminator()) >= 0;
		} else {
			throw new Error("Crashable: " + crashable.getClass() + " is not supported in " + this.getClass());
		}
	}
}
