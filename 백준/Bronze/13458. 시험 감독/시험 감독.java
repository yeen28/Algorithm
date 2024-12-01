import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[] a;
	private int b;
	private int c;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		long answer = 0;

		for (int i = 0; i < a.length; i++) {
			answer++;
			a[i] -= b;
			if (a[i] <= 0) {
				continue;
			}

			answer += a[i] / c;
			if (a[i] % c > 0) {
				answer++;
			}
		}

		System.out.println(answer);
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		a = new int[n];

		StringTokenizer stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(stk.nextToken());
		}

		stk = new StringTokenizer(br.readLine());
		b = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
	}
}