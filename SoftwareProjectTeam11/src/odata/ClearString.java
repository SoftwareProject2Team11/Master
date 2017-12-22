package odata;

public class ClearString {
	public String clearGivenString(String name) {
		
		name = name.substring(103);
		name = name.substring(0, name.length()-2);
		return name;
	}
}
