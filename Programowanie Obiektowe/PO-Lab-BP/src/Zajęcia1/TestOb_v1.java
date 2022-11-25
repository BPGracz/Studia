package Zajêcia1;

public class TestOb_v1 extends Object {
	public int aaa;
	public boolean equals(TestOb_v1 obj) {
		return this.aaa==obj.aaa;
	}

	public static void main(String[] args) {
		
		TestOb_v1 o1 = new TestOb_v1();
		TestOb_v1 o2 = new TestOb_v1();
		TestOb_v1 o3 = new TestOb_v1();
		
		o1.aaa = 1;
		o2.aaa = 1;
		o3.aaa = 5;
		
		System.out.println("Porównanie (v1) o1 i o2");
		System.out.println(o1.equals(o2));
		System.out.println(o2.equals(o1));
		System.out.println(o3.equals(o1));
		System.out.println(o3.equals(o2));
		
	}//end of main

}//end of TestOb

