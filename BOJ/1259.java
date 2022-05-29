import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static void main(String args[]) throws IOException {
		Main main = new Main();
		main.proc();
	} //main

	public void proc() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		boolean TF;
		while(!(str=br.readLine()).equals("0")) {
			TF = true;
			for(int i=0, j=str.length()-1; i<j; i++, j--) {
				if(str.charAt(i) != str.charAt(j)) {
					TF = false;
					break;
				} //end if
			} //end for
			
			if(TF) System.out.println("yes");
			else System.out.println("no");
		} //end while
	}
}
