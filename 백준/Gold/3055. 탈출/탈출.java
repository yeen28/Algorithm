import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private char[][] map;
	private int r;
	private int c;
	private int[] dy = {1,0,-1,0};
	private int[] dx = {0,-1,0, 1};

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		r = Integer.parseInt(stk.nextToken());
		c = Integer.parseInt(stk.nextToken());
		map = new char[r][c];

		int sX = 0;
		int sY = 0;
		for (int i = 0; i < r; i++) {
			String line = br.readLine();

			for (int j = 0; j < c; j++) {
				map[i][j] = line.toCharArray()[j];
				if (map[i][j] == 'S') {
					sY = i;
					sX = j;
				}
			}
		}

		int result = bfs(sY, sX);
		System.out.println(result == -1 ? "KAKTUS" : result);
	}

	private int bfs(int sY, int sX) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{sY, sX});
		int[][] dis = new int[r][c];
		dis[sY][sX] = 1;

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == '*') {
					q.add(new int[]{i, j});
				}
			}
		}

		while (!q.isEmpty()) {
			int[] move = q.poll();
			char now = map[move[0]][move[1]];

			for (int i = 0; i < 4; i++) {
				int ny = move[0] + dy[i];
				int nx = move[1] + dx[i];

				if (isOOB(ny, nx)) {
					continue;
				}

				if (now == 'S') { // 고슴도치
					if (map[ny][nx] == 'D') {
						return dis[move[0]][move[1]];
					}

					if (map[ny][nx] == '.') {
						map[ny][nx] = 'S';
						q.add(new int[]{ny, nx});
						dis[ny][nx] = dis[move[0]][move[1]] + 1;
					}
				}

				if (now == '*') { // 물
					if (map[ny][nx] == '.' || map[ny][nx] == 'S') {
						map[ny][nx] = '*';
						q.add(new int[]{ny, nx});
					}
				}
			}
		}

		return -1;
	}

	private boolean isOOB(int x, int y) {
		return x < 0 || y < 0 || x >= r || y >= c;
	}
}
