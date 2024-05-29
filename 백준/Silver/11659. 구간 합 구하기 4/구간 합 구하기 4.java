import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[] inputArr;
	private int[] sumArr;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
	}

	private void proc(int x, int y) {
		if (x == 1) {
			System.out.println(sumArr[y - 1]);
		} else {
			System.out.println(sumArr[y - 1] - sumArr[x - 2]);
		}
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(stk.nextToken());
		int m = Integer.parseInt(stk.nextToken());

		inputArr = new int[n];
		sumArr = new int[n];

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inputArr[i] = Integer.parseInt(stk.nextToken());

			if (i == 0) {
				sumArr[i] = inputArr[i];
			} else {
				sumArr[i] = sumArr[i - 1] + inputArr[i];
			}
		}

		for (int i = 0; i < m; i++) {
			stk = new StringTokenizer(br.readLine());
			proc(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
		}
	}
}