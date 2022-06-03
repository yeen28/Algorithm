import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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
	} //input
	
	private void proc(int N) {
		if(N == 1) {
			System.out.println(1);
			return;
		}
		
		Queue<Integer> que = new LinkedList<Integer>();
		
		if(N%2 == 0) {
			for(int i=2; i<N+1; i+=2) {
				que.add(i);
			} //end for
		} else {
			for(int i=4; i<N; i+=2) {
				que.add(i);
			} //end for
			
			que.add(2);
		} //end else
		
		int peek;
		while(que.size() != 1) {
			que.remove();
			peek = que.peek();
			que.remove();
			que.add(peek);
		} //end while
		
		System.out.println(que.peek());
	} //proc
}
