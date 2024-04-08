import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private final int[] dx = {0, 1, 0, -1, -1, 1, -1, 1};
	private final int[] dy = {1, 0, -1, 0, 1, 1, -1, -1};
	private final Queue<Position> queue = new LinkedList<>();
	private final List<int[][]> inputList = new ArrayList<>();
	private boolean[][] visited;
	private final StringBuilder answer = new StringBuilder();

	public static class Position {
		int x, y;
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		for (int[][] ints : inputList) {
			visited = new boolean[ints.length][ints[0].length];

			int result = 0;
			for (int i = 0; i < ints.length; i++) {
				for (int j = 0; j < ints[i].length; j++) {
					if (!visited[i][j] && ints[i][j] == 1) {
						result++;
						bfs(ints, i, j);
					}
				}
			}
			answer.append(result).append("\n");
		}

		System.out.println(answer);
	}

	private boolean OOB(int x, int y, int[][] input) {
		return x < 0 || y < 0 || x >= input.length || y >= input[0].length;
	}

	private void bfs(int[][] input, int idxX, int idxY) {
		queue.add(new Position(idxX, idxY));
		visited[idxX][idxY] = true;

		while (!queue.isEmpty()) {
			Position position = queue.poll();
			int x = position.x;
			int y = position.y;

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (!OOB(nx, ny, input) && !visited[nx][ny] && input[nx][ny] == 1) {
					queue.add(new Position(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer stk = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(stk.nextToken());
			int h = Integer.parseInt(stk.nextToken());
			if (w == 0 && h == 0) {
				break;
			}

			int[][] input = new int[h][w];
			for (int i = 0, j = 0; i < h; i++, j = 0) {
				stk = new StringTokenizer(br.readLine());
				while (stk.hasMoreTokens()) {
					input[i][j++] = Integer.parseInt(stk.nextToken());
				}
			}
			inputList.add(input);
		}
	}
}