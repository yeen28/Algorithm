// https://y-e-un28.tistory.com/518

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private int[] position; // 물이 새는 위치
	private int L; // 테이프 길이

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	public void proc() {
		int result = 0; // 결과(사용한 테이프의 최소 개수)
		int range = (int) (position[0] - 0.5 + L); // index 0에 테이프 붙였을 때 막는 범위
		result++;

		for (int i = 1; i < position.length; i++) {
			if (range < (int) (position[i] + 0.5)) {
				range = (int) (position[i] - 0.5 + L);
				result++;
			}
		}

		System.out.println(result);
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken());
		position = new int[N];
		L = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			position[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(position); // 입력값이 오름차순으로 들어오지 않으므로 정렬
	}
}
