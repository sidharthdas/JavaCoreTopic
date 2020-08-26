package com.test;

import java.util.HashMap;
import java.util.Map;

public class TestMainClass {

	public static void main(String[] args) {

		Map<Object, Integer> map = new HashMap<>();
		
		Object o1 = new Object();
		o1 = 9;
		
		Object o2 = new Object();
		o2 = 9;
		
		
		map.put(o1, 1);
		map.put(o2, 3);
		map.put("sum", 3);
		
		System.out.println(map);
		
		
		
	}

}
