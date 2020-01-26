package Interfaces;

import java.util.function.*;

public interface Crashable<InputType, ToBreakDeterminator> {
	boolean hasCrushed();
	InputType breakDown(CrasherUI crasherUI) throws IllegalStateException, IllegalArgumentException;
	ToBreakDeterminator getToBreakDeterminator();
	Converter<InputType> getConverter();
}
