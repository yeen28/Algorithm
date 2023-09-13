// https://y-e-un28.tistory.com/517

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		Main main = new Main();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		sb.append((int) Math.pow(2, N) - 1).append('\n');
		main.hanoi(N, 1, 2, 3);

		System.out.println(sb);
	}

	public void hanoi(int N, int start, int mid, int target) {
		if (N == 1) {
			sb.append(start).append(" ").append(target).append('\n');
			return;
		}

		hanoi(N - 1, start, target, mid);

		sb.append(start).append(" ").append(target).append('\n');

		hanoi(N - 1, mid, start, target);
	}
}
