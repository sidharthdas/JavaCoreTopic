package practice3.immutableclass;

import java.util.ArrayList;
import java.util.List;

public final  class Immutable {
	
	private final String name;
	private final List<String> strList;
	
	public Immutable(String name, List<String> strList) {
		this.name = name;
		List<String> test = new ArrayList<>();
		for(String i : strList) {
			test.add(i);
		}
		this.strList = test;
	}

	public String getName() {
		return name;
	}

	public List<String> getStrList() {
		return strList;
	}
	
	
	

}
