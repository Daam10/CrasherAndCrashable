package Interfaces;

public interface CrasherUI<ToBreakDeterminator> {
	boolean canCrash(Crashable crashable) throws IllegalArgumentException; // вызывается CrasherUI.canBreakDown(), значит должен быть определен без этого метода!
	ToBreakDeterminator getToBreakDeterminator();
}
