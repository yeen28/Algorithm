import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int N, M, max = 0;
	private int[] tree;

	public void proc() {
		int min = 0, H = 0;
		long size = 0;

		while (min < max) {
			size = 0;
			H = (min + max) / 2;

			for (int remain : tree) {
				if (remain - H > 0)
					size += remain - H;
			}

			if(size < M)
				max = H;
			
			else
				min = H+1;
		} // end while

		System.out.println(min-1);
	} // proc

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());
		tree = new int[N];

		stk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(stk.nextToken());
			max = Math.max(tree[i], max);
		}
	} // input

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	} // main

}
