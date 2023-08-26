import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private int[] dx = {0, 1, 0, -1}; // 상, 우, 하, 좌
	private int[] dy = {-1, 0, 1, 0}; // 상, 우, 하, 좌
	private boolean[][] visited;
	private char[][] map;
	private char[][] mapColorWeakness;

	public static void main(String[] args) throws IOException {
		Main main = new Main();

		main.input();
		main.proc();
	}

	public void proc() {
		int result = 0;
		int resultColorWeakness = 0;

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				char target = map[i][j];

				if (!visited[i][j]) {
					result++;
				}

				dfs(i, j, target, map);
			}
		}
		System.out.print(result + " ");

		visited = new boolean[mapColorWeakness.length][mapColorWeakness.length];
		for (int i = 0; i < mapColorWeakness.length; i++) {
			for (int j = 0; j < mapColorWeakness.length; j++) {
				char target = mapColorWeakness[i][j];

				if (!visited[i][j]) {
					resultColorWeakness++;
				}

				dfs(i, j, target, mapColorWeakness);
			}
		}

		System.out.println(resultColorWeakness);
	}

	/**
	 * 범위를 벗어났는지 체크
	 * @param nx
	 * @param ny
	 * @param end
	 * @return
	 */
	public boolean isOOB(int nx, int ny, int end) {
		return nx < 0 || ny < 0 || nx >= end || ny >= end;
	}

	public void dfs(int x, int y, char target, char[][] sourceMap) {
		// 방문 여부 체크
		if (visited[x][y]) {
			return;
		}

		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (!isOOB(nx, ny, sourceMap.length) && sourceMap[nx][ny] == target) {
				dfs(nx, ny, target, sourceMap);
			}
		}
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N= Integer.parseInt(br.readLine());
		visited = new boolean[N][N];
		map = new char[N][N];
		mapColorWeakness = new char[N][N];

		for (int i = 0; i < N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = input[j];
				mapColorWeakness[i][j] = input[j];

				if (input[j] == 'R') {
					mapColorWeakness[i][j] = 'G';
				}
			}
		}
	}
}
