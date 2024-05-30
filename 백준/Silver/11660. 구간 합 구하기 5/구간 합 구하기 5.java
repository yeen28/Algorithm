import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[][] arr;
	private int[][] sumArr;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
	}

	private void proc(int x1, int y1, int x2, int y2) {
		System.out.println(sumArr[x2][y2] - sumArr[x2][y1 - 1] - sumArr[x1 - 1][y2] + sumArr[x1 - 1][y1 - 1]);
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		arr = new int[n][n];
		sumArr = new int[n + 1][n + 1];

		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		// arr를 sumArr에 깊은 복사
		for (int i = 0; i < n; i++) {
			System.arraycopy(arr[i], 0, sumArr[i + 1], 1, n);
		}

		// 누적합 구하기
		for (int i = 2; i <= n; i++) {
			sumArr[1][i] += sumArr[1][i - 1];
			sumArr[i][1] += sumArr[i - 1][1];
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 2; j <= n; j++) {
				sumArr[i][j] = sumArr[i][j - 1] + sumArr[i - 1][j] - sumArr[i - 1][j - 1] + sumArr[i][j];
			}
		}

		// 결과 구하기
		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(stk.nextToken());
			int y1 = Integer.parseInt(stk.nextToken());
			int x2 = Integer.parseInt(stk.nextToken());
			int y2 = Integer.parseInt(stk.nextToken());
			proc(x1, y1, x2, y2);
		}
	}
}