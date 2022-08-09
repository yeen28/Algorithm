import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		Main main = new Main();
		
		main.input();
	}

	private void input() {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		str = str.toUpperCase();
		proc(str);
	}
	
	private void proc(String str) {
		int[] alphabet = new int[26];
		for(int i = 0; i < str.length(); i++) {
			alphabet[ (int)str.charAt(i) - 65 ]++;
		} //end for
		
		boolean isSame = false;
		int max = 0;
		for(int i = 1; i < alphabet.length; i++) {
			if(alphabet[max] < alphabet[i]) {
				max = i;
				isSame = false;
			} else if(alphabet[max] == alphabet[i]) isSame = true;
		} //end for
		
		if(isSame) {
			System.out.println("?");
			return;
		}
		
		System.out.println( (char)(max + 65) );
	}
}
