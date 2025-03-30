import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private final int[] dx = {-1, 0, 1, 0};
	private final int[] dy = {0, 1, 0, -1};
	private int N;
	private int M;
	private int[][] arr;
	private static int answer = 1;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		System.out.println(answer);
	}

	private void proc(int x, int y, int dir) {
		arr[x][y] = -1;

		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;

			int nx = x + dx[dir];
			int ny = y + dy[dir];

			if (isNotOOB(nx, ny)) {
				if (arr[nx][ny] == 0) {
					answer++;
					proc(nx, ny, dir);
					return;
				}
			}
		}

		int d = (dir + 2) % 4; // 반대 방향으로 후진
		int bx = x + dx[d];
		int by = y + dy[d];
		if (isNotOOB(bx, by) && arr[bx][by] != 1) {
			proc(bx, by, dir); // 후진이기 때문에 바라보는 방향은 유지
		}
	}

	private boolean isNotOOB(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		stk = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(stk.nextToken());
		int c = Integer.parseInt(stk.nextToken());
		int d = Integer.parseInt(stk.nextToken());

		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		proc(r, c, d);
	}
}