import java.text.MessageFormat;

import Interfaces.*;

public class Thing implements Crashable<String, Integer>{
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
	
	public Thing(String name) {
		this(name, DEFAULT_RIGIDITY);
	}

	public Thing(Integer rigidity) {
		this(DEFAULT_NAME, rigidity);
	}

	public Thing() {
	    this(DEFAULT_NAME, DEFAULT_RIGIDITY);
	}

	public Thing(String name, Integer rigidity) {
		this.rigidity = rigidity;
		this.name = name;
	}

	@Override
	public String breakDown(CrasherUI crasher) throws IllegalStateException {
		if(hasCrushed()) {
			throw new IllegalStateException(MessageFormat.format(msgTemplateOfAlreadyCrushedMessage, crushedBy));
		}
		crushedBy = crasher;
		return MessageFormat.format(msgTemplateOfBreakMessage, name, rigidity, crasher); // нужно вернуть String.
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
	public Converter<String> getConverter() {
		return new ThingToOutputConverter();
	}
}