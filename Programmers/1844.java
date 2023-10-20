// https://y-e-un28.tistory.com/535

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	private final int[] dx = {0, 1, 0, -1}; // 상우하좌
	private final int[] dy = {-1, 0, 1, 0}; // 상우하좌

	private int[][] maps;
	private int[][] visited;
	private final Queue<Position> que = new LinkedList<>();

	static class Position {
		int x, y, dist;

		public Position(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public int solution(int[][] maps) {
		int answer = 0;
		this.maps = maps;
		this.visited = new int[maps.length][maps[0].length];

		bfs();

		answer = visited[maps.length - 1][maps[0].length - 1];
		return answer == 0 ? -1 : answer;
	}

	private boolean isOOB(int nx, int ny) {
		return nx < 0 || nx >= maps[0].length || ny < 0 || ny >= maps.length;
	}

	private void bfs() {
		que.add(new Position(0, 0, 1));
		visited[0][0] = 1;

		while (!que.isEmpty()) {
			Position pos = que.poll();

			for (int i = 0; i < 4; i++) {
				int nx = pos.x + dx[i];
				int ny = pos.y + dy[i];

				if (!isOOB(nx, ny) && visited[ny][nx] == 0 && maps[ny][nx] == 1) {
					que.add(new Position(nx, ny, ++pos.dist));
					visited[ny][nx] = visited[pos.y][pos.x] + 1;
				}
			}
		}
	}
}
