import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	private final int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	private final int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
	private final Queue<Position> queue = new LinkedList<>();
	private final List<Position> currentPos = new ArrayList<>();
	private final List<Position> targetPos = new ArrayList<>();
	private int[][] countArr;
	private final List<Integer> lengthOfOneSide = new ArrayList<>();

	public class Position {
		int x, y, count;
		public Position(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		for (int i = 0; i < currentPos.size(); i++) {
			countArr = new int[lengthOfOneSide.get(i)][lengthOfOneSide.get(i)];
			bfs(i);
			System.out.println(countArr[targetPos.get(i).x][targetPos.get(i).y]);
		}
	}

	private boolean OOB(int x, int y, int idx) {
		return x < 0 || y < 0 || x >= lengthOfOneSide.get(idx) || y >= lengthOfOneSide.get(idx);
	}

	private void bfs(int positionIdx) {
		boolean[][] visited = new boolean[lengthOfOneSide.get(positionIdx)][lengthOfOneSide.get(positionIdx)];
		Position position = currentPos.get(positionIdx);
		queue.add(position);
		countArr[position.x][position.y] = position.count;
		visited[position.x][position.y] = true;

		while(!queue.isEmpty()) {
			Position pos = queue.poll();
			int x = pos.x;
			int y = pos.y;
			int count = pos.count;

			for (int i = 0; i < 8; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (!OOB(nx, ny, positionIdx) && !visited[nx][ny]) {
					queue.add(new Position(nx, ny, count + 1));
					countArr[nx][ny] = count + 1;
					visited[nx][ny] = true;
				}
			}
		}
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());

		for (int i = 0; i < num; i++) {
			lengthOfOneSide.add(Integer.parseInt(br.readLine()));

			String[] loc = br.readLine().split(" ");
			currentPos.add(new Position(Integer.parseInt(loc[0]), Integer.parseInt(loc[1]), 0));
			String[] target = br.readLine().split(" ");
			targetPos.add(new Position(Integer.parseInt(target[0]), Integer.parseInt(target[1]), 0));
		}
	}
}