package Zajêcia1;

public class TestOb extends Object {
	public int aaa;
	@Override
	public boolean equals(Object obj) {
		return this.aaa==((TestOb)obj).aaa;}
	
	public static void main(String[] args) {
		
		TestOb o1 = new TestOb();
		TestOb o2 = new TestOb();
		
		o1.aaa = 1;
		o2.aaa = 1;
		
		System.out.println("Porównanie (v1) o1 i o2");
		System.out.println(o1.equals(o2));
		System.out.println(o2.equals(o1));
		
	}//end of main

}//end of TestOb