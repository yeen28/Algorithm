import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
		Main main = new Main();

		main.input();
	}

	private void input() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		proc(str);
	}
	
	private void proc(String str) {
		int[] inputNum = new int[5];
		int sum = 0;
		
		StringTokenizer stk = new StringTokenizer(str, " ");
		for(int i=0; i<inputNum.length; i++) {
			inputNum[i] = (int) Math.pow(Integer.parseInt(stk.nextToken()), 2);
		} //end for
		
		// 제곱의 합
		for(int i=0; i<inputNum.length; i++) {
			sum += inputNum[i];
		} //end for
		
		System.out.println(sum % 10);
	}
}
