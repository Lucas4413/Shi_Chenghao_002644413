package Model;

public class HelloWorld {
	int a = 5;
	double b  = 2.0d;
	float c = 3.0f;
	String d = "Hello";
	Boolean e = false;
	int[] intArr = new int[5];
	
	public static void main(String[] args) {
		HelloWorld hw = new HelloWorld();
		System.out.println("a: " + hw.a);
		System.out.println("b: " + hw.b);
		System.out.println("c: " + hw.c);
		System.out.println("d: " + hw.d);
		System.out.println("e: " + hw.e);
	}
}
