import java.text.MessageFormat;

import Interfaces.Converter;
import Interfaces.Crashable;
import Interfaces.CrasherUI;

public class ThingIntInput implements Crashable<Integer, Integer>{
	private Integer rigidity;
	private String name;
	
	private CrasherUI crushedBy;
	
	public final static Integer DEFAULT_RIGIDITY = 50;
	public final static String DEFAULT_NAME = "unnamed";
	private static final String msgTemplateOfBreakMessage = "u broke {0} with {1} by {2}, dude";
	private static final String msgTemplateOfAlreadyCrushedMessage = "It is already crushed by {0}";
	
	{
		crushedBy = null;
	}
	
	public ThingIntInput(String name) {
		this(name, DEFAULT_RIGIDITY);
	}

	public ThingIntInput(Integer rigidity) {
		this(DEFAULT_NAME, rigidity);
	}

	public ThingIntInput() {
	    this(DEFAULT_NAME, DEFAULT_RIGIDITY);
	}

	public ThingIntInput(String name, Integer rigidity) {
		this.rigidity = rigidity;
		this.name = name;
	}

	@Override
	public Integer breakDown(CrasherUI crasher) throws IllegalStateException {
		if(hasCrushed()) {
			throw new IllegalStateException(MessageFormat.format(msgTemplateOfAlreadyCrushedMessage, crushedBy));
		}
		crushedBy = crasher;
		return 2;
	}
	
	@Override
	public boolean hasCrushed() {
		return crushedBy != null;
	}

	@Override
	public Integer getToBreakDeterminator() {
		return rigidity;
	}

	@Override
	public Converter<Integer> getConverter() {
		return new ThingIntInputToOutputConverter();
	}
}
