package thisandsuperlevel;

public class Child extends Base{
	
	int a;
	int b;

	public Child(int a, int b) {
		super(a, b);

	}
	
	
	public void m1(){
		
		this.a = 20;
		super.a = 50;
	}
	
	
	

}
