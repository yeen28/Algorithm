import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static void main(String args[]) throws IOException {
		Main main = new Main();
		main.input();
	} //main

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		
		int K = Integer.parseInt(stk.nextToken());
		int N = Integer.parseInt(stk.nextToken());
		long max = -1;
		int[] arr = new int[K];
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			if(max < arr[i]) {
				max = arr[i];
			}
		} //end for
		
		proc(N, arr, max+1);
	} //input
	
	private void proc(int N, int[] arr, long max) {
		long min=0, mid=0, cnt=0;
		
		while(min < max) {
			mid = (min+max)/2;
			cnt = 0;
			
			for(int i=0; i<arr.length; i++) {
				cnt += arr[i]/mid;
			} //end for
			
			if(cnt < N) {
				max = mid;
			} else {
				min = mid+1;
			} //end else
		} //end while
		
		System.out.println(min-1);
	} //proc
}
