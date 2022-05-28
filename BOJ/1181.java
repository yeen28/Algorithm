import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
	
	public String[] input() {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		String[] str = new String[n];
		sc.nextLine();
		for(int i = 0; i < n; i++) {
			str[i] = sc.nextLine();
		} //end for
		
		return str;
	} //input
	
	private void proc(String[] str) {
		Arrays.sort(str, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} //end if
				
				return o1.length() - o2.length();
			} //compare
		}); //sort
		
		print(str);
	} //proc
	
	private void print(String[] str) {
		String tmp = "";
		for(String val : str) {
			if(!val.equals(tmp))
				System.out.println(val);
			tmp = val;
		} //end for
	} //print
	
	public static void main(String args[]) {
		Main main = new Main();
		
		String[] str;
		str = main.input();
		main.proc(str);
	}
}
