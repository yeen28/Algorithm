import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.io.IOException;

public class Main {
	
	public String[] input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		String[] str = new String[n];
		for(int i = 0; i < n; i++) {
			str[i] = br.readLine();
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
	
	public static void main(String args[]) throws IOException {
		Main main = new Main();
		
		String[] str;
		str = main.input();
		main.proc(str);
	}
}
