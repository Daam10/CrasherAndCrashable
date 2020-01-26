import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;

import Interfaces.*;

public abstract class AbstractApartaments<OutputType, InputType, ToBreakDeterminator> implements ApartamentUI{
	private Stack<Crashable<InputType, ToBreakDeterminator>> things;
	
	private CrasherUI<ToBreakDeterminator> crasher;
	
	private ConcurrentLinkedQueue<OutputType> toUserOutputs;
	private ToUserOutputUI<OutputType> out;
	
	{
		things = new Stack();
		toUserOutputs = new ConcurrentLinkedQueue();
	}
	
	public AbstractApartaments(Collection<? extends Crashable<InputType, ToBreakDeterminator>> toCrush, CrasherUI<ToBreakDeterminator> crasher, ToUserOutputUI<OutputType> out){
		things.addAll(toCrush);
		this.crasher = crasher;
		this.out = out;
	}
	
	
	@Override
	public boolean hasThingsToCrash() {
		return things.isEmpty();
	}

	@Override
	public boolean crashNext() {
		if(!things.isEmpty()) {
			Crashable<InputType, ToBreakDeterminator> toCrash = things.pop();
			if(crasher.canCrash(toCrash)) {
				Converter<InputType> converter = toCrash.getConverter();
				converter.setValueToConvert(toCrash.breakDown(crasher));
				toUserOutputs.add((OutputType) converter.convert());
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

}

