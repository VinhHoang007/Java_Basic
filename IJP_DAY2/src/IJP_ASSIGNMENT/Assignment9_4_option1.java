package IJP_ASSIGNMENT;
//TINH GIA TRI BIEN:
//    boolean a = true&&false;
//    boolean b = (3 > 100) || (25%5 == 0)
//    boolean c = a && b;
//    boolean d = !a || b;	

public class Assignment9_4_option1 {
	
	public static void main(String[] args) {
	    boolean a = true&&false;
	    boolean b = (3 > 100) || (25 % 5 == 0);
	    boolean c = a && b;
	    boolean d = !a || b;	
	    
	    System.out.println(a); // true&&false = false
	    System.out.println(b); // (3 > 100) || (25%5 == 0) false || true = true
	    System.out.println(c); // a && b = false && true = false
	    System.out.println(d); // !a || b = true || true = true
	}
}
