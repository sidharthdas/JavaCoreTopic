package practice10.interfacejava8;

public class Java8Impl implements Java8 {

	@Override
	public void add() {
		System.out.println("in java8impl");

	}
	
	@Override
	public void sub() {
		// TODO Auto-generated method stub
		Java8.super.sub();
		
		System.out.println("in java8impl");
	}
	


}
