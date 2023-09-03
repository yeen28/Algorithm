// https://y-e-un28.tistory.com/514

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private int[][] originMap;
	private int[] dx = {0, 1, 0, -1}; // 상우하좌
	private int[] dy = {-1, 0, 1, 0}; // 상우하좌
	private static int maxResult = Integer.MIN_VALUE;

	class Node {
		private int x;
		private int y;

		public Node(int y, int x) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();

		main.input();
		main.proc();

		System.out.println(maxResult);
	}

	public void proc() {
		dfs(0);
	}

	/**
	 * 벽을 세울 수 있는 모든 경우의 수
	 */
	public void dfs(int wallCnt) {
		// 3개의 벽을 모두 세웠을 때 bfs로 바이러스 퍼뜨리기
		if (wallCnt == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < originMap.length; i++) {
			for (int j = 0; j < originMap[i].length; j++) {
				if (originMap[i][j] == 0) {
					originMap[i][j] = 1; // 임시로 벽 세우기
					dfs(wallCnt + 1); // 재귀니깐 여기서 +1한 것은 이전 재귀로 돌아오면 -1로 줄어있습니다.
					originMap[i][j] = 0; // 모든 경우의 수를 위해 세웠던 벽을 원래대로 허물기
				}
			}
		}
	}

	/**
	 * 깊은 복사
	 * @return
	 */
	private int[][] cloneArray() {
		int[][] cloneMap = new int[originMap.length][originMap[0].length];
		for (int i = 0; i < originMap.length; i++) {
			// clone 메서드는 1차원 배열일 때 깊은 복사를 하지만 2차원 배열에서는 얕은 복사가 됩니다.
			// 따라서, 반복문 + clone 메서드를 사용하여서 2차원 배열을 깊은 복사 했습니다.
			cloneMap[i] = originMap[i].clone();
		}

		return cloneMap;
	}

	/**
	 * 바이러스 퍼뜨리기
	 */
	public void bfs() {
		Queue<Node> queue = new LinkedList<>();

		// 바이러스 위치를 Queue에 담기
		for (int i = 0; i < originMap.length; i++) {
			for (int j = 0; j < originMap[i].length; j++) {
				if (originMap[i][j] == 2) {
					queue.add(new Node(i, j));
				}
			}
		}

		int[][] cloneMap = cloneArray();

		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int x = node.x;
			int y = node.y;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (!oob(nx, ny) && cloneMap[ny][nx] == 0) {
					queue.add(new Node(ny, nx));
					cloneMap[ny][nx] = 2;
				}
			}
		}

		// 결과 구하기
		safeZone(cloneMap);
	}

	private void safeZone(int[][] cloneMap) {
		int result = 0;

		for (int i = 0; i < cloneMap.length; i++) {
			for (int j = 0; j < cloneMap[i].length; j++) {
				if (cloneMap[i][j] == 0) {
					result++;
				}
			}
		}

		if (maxResult < result) {
			maxResult = result;
		}
	}

	public boolean oob(int x, int y) {
		return x < 0 || y < 0 || x >= originMap[0].length || y >= originMap.length;
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());

		originMap = new int[N][M];

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				// 입력이 확실하니깐 stk에 대한 예외를 처리하지 않았습니다.
				originMap[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
	}
}
