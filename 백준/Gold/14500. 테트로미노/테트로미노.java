import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private int[] dx = {0, 0, -1, 1};
	private int[] dy = {1, -1, 0, 0};
	private int[][] map;
	private boolean[][] visited;
	private int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				visited[i][j] = true;
				dfs(j, i, map[i][j], 1);
				visited[i][j] = false;
			}
		}

		System.out.println(max);
	}

	private void dfs(int x, int y, int sum, int depth) {
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isOOB(nx, ny) && !visited[ny][nx]) {
				if (depth == 2) {
					visited[ny][nx] = true;
					dfs(x, y, sum + map[ny][nx], depth + 1);
					visited[ny][nx] = false;
				}

				visited[ny][nx] = true;
				dfs(nx, ny, sum + map[ny][nx], depth + 1);
				visited[ny][nx] = false;
			}
		}
	}

	private boolean isOOB(int x, int y) {
		return x < 0 || y < 0 || y >= map.length || x >= map[0].length;
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
	}
}