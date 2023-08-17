// https://y-e-un28.tistory.com/511

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private int N;
	private int[] single;
	private int[] pack;

	public static void main(String[] args) throws IOException {
		Main main = new Main();

		main.input();
		main.proc();
	}

	public void proc() {
		Arrays.sort(single);
		Arrays.sort(pack);

		int quotient = N / 6;
		int remain = N % 6;

		int caseOne = pack[0] * (quotient + 1);
		int caseTwo = pack[0] * quotient + single[0] * remain;
		int caseThree = single[0] * N;

		int result = Math.min(caseOne, caseTwo);
		result = Math.min(result, caseThree);

		System.out.println(result);
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		pack = new int[M];
		single = new int[M];

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			pack[i] = Integer.parseInt(input[0]);
			single[i] = Integer.parseInt(input[1]);
		}
	}
}
