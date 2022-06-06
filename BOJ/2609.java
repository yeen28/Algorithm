import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	private static StringBuilder sb;
	private int a, b;
	
	public static void main(String args[]) throws IOException {
		Main main = new Main();
		sb = new StringBuilder();
		
		main.input();
		
		// greatest common divisor
		main.GCD();
		
		// largest common multiple
		main.LCM();
		
		System.out.println(sb);
	} //main

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		a = Integer.parseInt(stk.nextToken());
		b = Integer.parseInt(stk.nextToken());
		
		if(a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
	} //input
	
	private void LCM() {
		if(a == b) {
			sb.append(a);
			return;
		}
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=1; b*i<=a*b ; i++) {
			list.add(b*i);
		}
		
		for(int i=1; ; i++) {
			int mulA = a*i;
			if(list.contains(mulA)) {
				sb.append(mulA);
				return;
			}
		}
	}

	private void GCD() {
		boolean[] arr = new boolean[a+1];
		for(int i=1; i<a+1; i++) {
			if(a % i == 0) {
				arr[i] = true;
			}
		}
		
		for(int i=a; i>0; i--) {
			if(b % i == 0 && arr[i]) {
				sb.append(i).append('\n');
				return;
			}
		}		
	}
}
