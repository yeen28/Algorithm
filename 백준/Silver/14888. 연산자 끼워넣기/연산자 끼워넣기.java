import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[] numbers;
	private int[] operator;
	private int min = Integer.MAX_VALUE;
	private int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		dfs(numbers[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

	private void dfs(int number, int idx) {
		if (idx == numbers.length) {
			min = Math.min(number, min);
			max = Math.max(number, max);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;

				switch (i) {
					case 0 -> dfs(number + numbers[idx], idx + 1);
					case 1 -> dfs(number - numbers[idx], idx + 1);
					case 2 -> dfs(number * numbers[idx], idx + 1);
					case 3 -> dfs(number / numbers[idx], idx + 1);
				}

				operator[i]++;
			}
		}
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		numbers = new int[N];
		operator = new int[4];

		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(stk.nextToken());
		}

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(stk.nextToken());
		}
	}
}
