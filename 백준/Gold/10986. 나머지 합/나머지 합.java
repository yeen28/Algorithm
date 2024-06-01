import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private final List<Long> modArr = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
	}

	private void proc(int m, long[] C) {
		// modArr에서 0의 개수
		long answer = modArr.stream().filter(arr -> arr == 0).count();

		for (int k = 0; k < m; k++) {
			if (C[k] > 1) {
				answer += (C[k] * (C[k] - 1) /2);
			}
		}

		System.out.println(answer);
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		List<Long> sumArr = new ArrayList<>();
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());
		long[] arr = new long[n];
		long[] C = new long[m];

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
		}

		// 누적합 구하기
		sumArr.add(arr[0]);
		for (int i = 1; i < n; i++) {
			sumArr.add(sumArr.get(i - 1) + arr[i]);
		}

		// mod 구하기
		sumArr.forEach(val -> {
			modArr.add(val % m);
			C[(int)(val % m)]++;
		});

		proc(m, C);
	}
}