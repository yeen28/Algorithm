import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[][] W;
	private boolean[] visited;
	private int min = Integer.MAX_VALUE;
	private int startCity;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		for (int i = 0; i < W.length; i++) {
			startCity = i;
			dfs(i, 0, 1);
		}

		System.out.println(min);
	}

	private void dfs(int city, int cost, int idx) {
		if (W[city][startCity] != 0 && idx == W.length) {
			cost += W[city][startCity];
			min = Math.min(min, cost);
			return;
		}

		visited[city] = true;
		for (int i = 0; i < W.length; i++) {
			if (!visited[i] && W[city][i] != 0) {
				dfs(i, cost + W[city][i], idx + 1);
				visited[i] = false;
			}
		}
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		W = new int[N][N];
		visited = new boolean[N];

		StringTokenizer stk;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
	}
}