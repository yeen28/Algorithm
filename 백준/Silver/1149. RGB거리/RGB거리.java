import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[][] roof;
	private int[][] dp;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		System.arraycopy(roof[0], 0, dp[0], 0, 3);
		for (int i = 1; i < roof.length; i++) {
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + roof[i][0];
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + roof[i][1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + roof[i][2];
		}
		int n = dp.length - 1;
		System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		roof = new int[n][3];
		dp = new int[n][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				roof[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
	}
}