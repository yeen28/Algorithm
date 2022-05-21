import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		Main main = new Main();
		
		main.input();
	}

	private void input() {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		proc(num1, num2);
	}
	
	private void proc(int num1, int num2) {
		num1 = turn(num1);
		num2 = turn(num2);
		
		if(num1 < num2) System.out.println(num2);
		else System.out.println(num1);
	}
	
	private int turn(int num) {
		int n = 0, j = 0;
		
		for(int i = 2; i >= 0; i--) {
			n += ((num %= ((int)Math.pow(10, i+1))) / (int)Math.pow(10, i)) * (int)Math.pow(10, j++);
		} //end for
		
		return n;
	}
}
