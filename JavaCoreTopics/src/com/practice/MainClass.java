/**
 * 
 */
package com.practice;

/**
 * @author sidharthdas
 *
 */

class Employee{
	String s;

	public Employee(String s) {
		super();
		this.s = s;
	}

	@Override
	public String toString() {
		return s;
	}
	
	/*
	 * @Override public String toString() { // TODO Auto-generated method stub
	 * return super.toString(); }
	 */
	
	
	
	
}

public class MainClass {
	public static void main(String[] args) {
		
		String s = new String("Sidh");
		
		Employee e = new Employee("Sidh");
		
		System.out.println(e);
		
		
		

	}

}
