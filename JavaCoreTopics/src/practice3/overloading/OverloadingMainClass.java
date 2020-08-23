package practice3.overloading;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Test {
    public int field;
}

public class OverloadingMainClass {
	
	
	
	public static void main(String[] args) {
		
		System.out.println(matches("a01JAVA"));
		
	}
	
	public Set getSet(int a) {
		return new HashSet();
	}
	
	
	public static boolean matches(String str){
		  Pattern p = Pattern.compile("[01]*aJAVA");
		  Matcher m = p.matcher(str);
		  return m.matches();
		}
	
	public static void add() {
		System.out.println("in no parameter add method");
	}
	
	public static void add(int a) {
		System.out.println("in int a add method");
	}
	
	public static void add(String a) {
		System.out.println("in String a add method");
	}
	
	int sum(int x, int y) {
		return 0;
	}
	double sum(int x, int y, int z) {
		return 0;
	}
	void sum (int y) {
		
	}
	
	public static void add(Object a) {
		System.out.println("in object a add method");
	}
}
