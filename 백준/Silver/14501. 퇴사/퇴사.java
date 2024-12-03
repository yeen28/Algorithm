import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[] t; // 상담을 완료하는데 걸리는 기간
	private int[] p; // 상담을 했을 때 받을 수 있는 금액

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		int n = t.length;
		int[] dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			if (i + t[i] <= n) {
				dp[i + t[i]] = Math.max(dp[i] + p[i], dp[i + t[i]]);
			}
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
		}

		System.out.println(dp[n]);
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 퇴사일까지 남은 기간
		t = new int[n];
		p = new int[n];

		StringTokenizer stk;
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(stk.nextToken());
			p[i] = Integer.parseInt(stk.nextToken());
		}
	}
}