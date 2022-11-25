package Zajêcia2;

public class MojaP extends MojaPB {
	int x=234;
	static int ile=0;
	public MojaP() {ile++;}
	public void okreœlXB(int a) {super.x=a;}
	public void okreœlX(int a) {this.x=a;}
	public int okreœlSumê() {return super.x+this.x;}
	public String toString() {
		return super.toString()+ "klasa pochodna "+
	this.getClass().getName();
	}

	public static void main(String[] args) {
		MojaP obiekt = new MojaP();
		obiekt.okreœlXB(125);
		System.out.println("Suma = "+ obiekt.okreœlSumê());
		System.out.println(obiekt);
		MojaPB ob1=new MojaPB();
		MojaP obiekt1=new MojaP();
		System.out.println(ob1 + "utworzono "+MojaP.ile);
	}

}
