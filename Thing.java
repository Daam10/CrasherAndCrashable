import Interfaces.*;

public class Thing implements Crashable<String, Integer>{
	private Integer rigidity;
	private String name;
	
	private CrasherUI crushedBy;
	
	public final static Integer DEFAULT_RIGIDITY = 50;
	public final static String DEFAULT_NAME = "unnamed";
	
	{
		crushedBy = null;
	}
	
	public Thing(String name, Integer rigidity) {
		this.rigidity = rigidity;
		this.name = name;
	}
	
	public Thing(String name) {
		this.name = name;
		this.rigidity = DEFAULT_RIGIDITY;
	}
	
	public Thing(Integer rigidity) {
		this.name = DEFAULT_NAME;
		this.rigidity = rigidity;
	}
	
	public Thing() {
		this.name = DEFAULT_NAME;
		this.rigidity = DEFAULT_RIGIDITY;
	}

	@Override
	public String breakDown(CrasherUI crasher) throws IllegalStateException {
		if(hasCrushed()) {
			throw new IllegalStateException("It is already crushed by " + crushedBy);
		}
		crushedBy = crasher;
		return "u broke " + name + " with " + rigidity + " by " + crasher + ", dude"; // нужно вернуть String.
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