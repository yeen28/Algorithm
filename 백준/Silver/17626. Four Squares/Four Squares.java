import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int N;
    private int[] dp;

    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];
        dp[0] = 0;
        if (N >= 1) {
            dp[1] = 1;
        }
    }

    public void proc() {
        for (int i = 2; i <= N; i++) {
            int minCount = Integer.MAX_VALUE;

            // i보다 작거나 같은 제곱수를 모두 시도
            for (int j = 1; j * j <= i; j++) {
                minCount = Math.min(minCount, dp[i - j * j]);
            }

            dp[i] = minCount + 1;
        }

        System.out.println(dp[N]);
    }
}