// https://y-e-un28.tistory.com/512

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[][] nodes;
	private boolean[] visited;
	private int vertex;
	private int result;

	public static void main(String[] args) throws IOException {
		Main main = new Main();

		main.input();
		main.proc();
	}

	public void dfs(int i) {
		visited[i] = true;

		for (int j = 0; j <= vertex; j++) {
			if (visited[j] || nodes[i][j] == 0) {
				continue;
			}

			dfs(j);
		}
	}

	public void proc() {
		for (int i = 1; i <= vertex; i++) {
			if (!visited[i]) {
				result++;
			}

			dfs(i);
		}

		System.out.println(result);
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		vertex = Integer.parseInt(stk.nextToken());
		int edge = Integer.parseInt(stk.nextToken());

		nodes = new int[vertex + 1][vertex + 1];
		visited = new boolean[vertex + 1];

		for (int i = 0; i < edge; i++) {
			stk = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(stk.nextToken());
			int b = Integer.parseInt(stk.nextToken());
			nodes[a][b] = nodes[b][a] = 1;
		}
	}
}
