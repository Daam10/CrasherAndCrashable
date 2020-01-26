import Interfaces.Converter;

public class ThingToOutputConverter implements Converter<String>{
	String in;
	
	@Override
	public Object convert(Class to) {
		if(in == null){
			throw new IllegalStateException("In is empty");
		}
		if(to == String.class) {
			return in;
		} else {
			throw new Error("This parser cannot parse to " + to);
		}
	}

	@Override
	public void setValueToConvert(String in) {
		this.in = in;
	}
}
