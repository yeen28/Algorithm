import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int sum = 0;

		for(int i=0; i<5; i++) {
			sum += (int) Math.pow(sc.nextInt(), 2);
		}
		
		System.out.println(sum % 10);
	}
}
