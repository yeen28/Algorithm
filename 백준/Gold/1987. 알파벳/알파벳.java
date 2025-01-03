import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private char[][] map;
	private final int[] dx = {0, 0, -1, 1};
	private final int[] dy = {1, -1, 0, 0};
	private final boolean[] visited = new boolean[26];
	private int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		visited[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(max);
	}

	private void dfs(int x, int y, int cnt) {
		if (max < cnt) {
			max = cnt;
		}

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isOOB(nx, ny) && !visited[map[ny][nx] - 'A']) {
				visited[map[ny][nx] - 'A'] = true;
				dfs(nx, ny, cnt + 1);
				visited[map[ny][nx] - 'A'] = false;
			}
		}
	}

	private boolean isOOB(int x, int y) {
		return x < 0 || y < 0 || x >= map[0].length || y >= map.length;
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(stk.nextToken());
		int C = Integer.parseInt(stk.nextToken());
		map = new char[R][C];

		String input;
		for (int i = 0; i < R; i++) {
			input = br.readLine();

			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
	}
}