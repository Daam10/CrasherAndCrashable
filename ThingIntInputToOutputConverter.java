import Interfaces.Converter;

public class ThingIntInputToOutputConverter implements Converter<Integer>{
	Integer in;
	
	@Override
	public Object convert(Class to) {
		if(in == null){
			throw new IllegalStateException("In is empty");
		}
		if(to == Integer.class) {
			return in;
		} else if(to == String.class){
			return Integer.toString(in);
		}else {
			throw new Error("This parser cannot parse to " + to);
		}
	}

	@Override
	public void setValueToConvert(Integer in) {
		this.in = in;
	}
}
