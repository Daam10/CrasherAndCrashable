package Interfaces;

public interface Converter<T>{
	Object convert(Class to);
	void setValueToConvert(T t);
}
