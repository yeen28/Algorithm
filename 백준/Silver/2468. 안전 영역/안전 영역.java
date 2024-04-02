import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	private int[][] region;
	private final int[] dx = {0, 1, 0, -1};
	private final int[] dy = {1, 0, -1, 0};
	private final Queue<Position> queue = new LinkedList<>();
	private boolean[][] visited;
	private int maxHeight = 0;

	private static class Position {
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

	public void proc() {
		int result = 0;
		int safeArea = 0;

		int height = -1;
		while (height <= maxHeight) {
			result = Math.max(safeArea, result);
			safeArea = 0;
			height++;
			for (boolean[] v : visited) {
				Arrays.fill(v, false);
			}

			for (int i = 0; i < region.length; i++) {
				for (int j = 0; j < region[i].length; j++) {
					if (!visited[i][j] && region[i][j] > height) {
						safeArea++;
						bfs(i, j, height);
					}
				}
			}
		}

		System.out.println(result);
	}

	private boolean OOB(int x, int y) {
		return x < 0 || y < 0 || x >= region[0].length || y >= region.length;
	}

	private void bfs(int row, int col, int height) {
		queue.add(new Position(row, col));
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			Position pos = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];

				if (!OOB(nx, ny) && !visited[nx][ny] && region[nx][ny] > height) {
					queue.add(new Position(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		region = new int[num][num];
		visited = new boolean[num][num];

		for (int i = 0; i < num; i++) {
			int[] area = Arrays.stream(br.readLine().split(" "))
					.mapToInt(heightString -> {
						int height = Integer.parseInt(heightString);
						maxHeight = Math.max(maxHeight, height);
						return height;
					}).toArray();
			System.arraycopy(area, 0, region[i], 0, num);
		}
	}
}