import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15651
 */
public class Main {
	static int N, M, ans;
	static int[] selected;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		input();

		// 1번째 원소부터 M번째 원소를 조건에 맞는 모든 방법을 찾아줘
		rec_func(1);

		System.out.println(sb);
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		selected = new int[M + 1];
	}

	// 재귀함수
	// 만약 M개를 전부 고름 => 조건에 맞는 탐색을 한 가지 성공한 것
	// 아직 M개를 고르지 않음 => k번째부터 M번째 원소를 조건에 맞게 고르는 모든 방법을 시도
	static void rec_func(int k) {
		// 모두 탐색한 경우
		if (k == M + 1) {
			for (int i = 1; i <= M; i++) {
				sb.append(selected[i]).append(' ');
			}
			sb.append('\n');

		} else {
			for (int cand = 1; cand <= N; cand++) {
				selected[k] = cand;
				rec_func(k+1); // k+1번 ~ M번을 모두 탐색하는 일을 해야 하는 상황
				selected[k] = 0;
			}

		}
	}
}
