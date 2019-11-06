import java.lang.Math;
public class Exercise12 {
	public static void main(String[] args) {
		for(int i=10; i <= 100; i+=10) {
			System.out.println("Polynomial: " + Math.pow(i, 4));
			System.out.println("Exponential: " + Math.pow(2, i));
			System.out.println("Ratio: " + Math.pow(2, i) / Math.pow(i, 4));
			System.out.println();
		}
	}
}