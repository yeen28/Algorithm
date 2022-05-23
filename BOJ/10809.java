import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		Main main = new Main();
		
		String s = main.input();
		int[] answer = main.proc(s);
		main.print(answer);
	}

	private String input() {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		return s;
	}
	
	private int[] proc(String s) {
		int[] alphabet = new int[26];
		Arrays.fill(alphabet, -1);
		
		for(int i=0; i<s.length(); i++) {
			if(alphabet[(int)s.charAt(i)-97] == -1) {
				alphabet[(int)s.charAt(i)-97] = i;
			}
		} //end for
		
		return alphabet;
	}
	
	private void print(int[] answer) {
		for(int val : answer) {
			System.out.print(val + " ");
		}
	}
}
