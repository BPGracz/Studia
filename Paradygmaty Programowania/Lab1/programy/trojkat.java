public class Trojkat {
    int a, b, c;
    public Trojkat (int x, int y, int z) {
      a= x; b=y; c=z;
    }
    public Boolean czy_trojkat() {
        return (a +b > c) && (b +c >a) && (c + a > b);

    }
    public double pole() {
        double pol_obw =(a+b+c)/2;
        return Math.sqrt(pol_obw*(pol_obw-a)*(pol_obw-b)*(pol_obw-c));
    }
    public Integer obwod() {return a+b+c;}
    public String toString() {
        return "(" + a + ", " + b + ", "+ c+ ")";
    }
    public static void main(String[] args) {
        Trojkat tr1 = new Trojkat(2,4,5);
        System.out.println("podałeś trójkat"+ tr1);
        if (tr1.czy_trojkat()) {
        System.out.println("on jest trójkątem");
        System.out.println("pole="+tr1.pole());
        System.out.println("obwód="+tr1.obwod());}
        else {System.out.println("on nie jest trójkątem");}

    }
}