import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;

import Interfaces.*;

public abstract class AbstractApartaments<OutputType, ToBreakDeterminator> implements ApartamentUI{
	private Stack<Crashable<?, ToBreakDeterminator>> things;
	
	private CrasherUI<ToBreakDeterminator> crasher;
	
	private ConcurrentLinkedQueue<OutputType> toUserOutputs;
	private ToUserOutputUI<OutputType> out;
	
	{
		things = new Stack();
		toUserOutputs = new ConcurrentLinkedQueue();
	}
	
	public AbstractApartaments(Collection<Crashable<?, ToBreakDeterminator>> toCrush, CrasherUI<ToBreakDeterminator> crasher, ToUserOutputUI<OutputType> out){
		things.addAll(toCrush);
		this.crasher = crasher;
		this.out = out;
	}
	
	
	@Override
	public boolean hasThingsToCrash() {
		return things.isEmpty();
	}
	
	@Override
	public <ToCrashInput>boolean crashNext() {
		if(!things.isEmpty()) {
			Crashable<ToCrashInput, ToBreakDeterminator> toCrash = (Crashable<ToCrashInput, ToBreakDeterminator>) things.pop();
			if(crasher.canCrash(toCrash)) {
				Converter<ToCrashInput> converter = toCrash.getConverter();
				converter.setValueToConvert(toCrash.breakDown(crasher));
				toUserOutputs.add((OutputType) converter.convert(getOutputObject().getClass()));
				return true;
			} else {
				return false;
			}
		} else {
			throw new NoSuchElementException();
		}
	}
	
	

	@Override
	public void pullToUserOutputs() {
		while(!toUserOutputs.isEmpty()) {
			out.toOutput(toUserOutputs.poll());
		}
	}
	
	abstract OutputType getOutputObject();
}

