package Interfaces;

public interface CrasherAndCrashableComparator<T extends CrasherUI> {
	boolean canCrash(T crasher, Crashable crashable) throws IllegalStateException;
}
