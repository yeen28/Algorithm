import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	
	public static void main(String args[]) throws IOException {
		Main main = new Main();
		main.input();
	} //main

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		proc(N);
	}
	
	private void proc(int N) {
		int cnt=1;
		int num=666;
		
		while(cnt != N) {
			if(String.valueOf(++num).contains("666")) {
				cnt++;
			} //end if
		} //end while
		
		System.out.println(num);
	} //proc
}
