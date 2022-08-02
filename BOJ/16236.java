import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	// 방문 여부
	static boolean[] visited = new boolean[400];
	// 물고기 위치 입력
	static int[][] map = new int[20][20];
	// 먹은 물고기
	static ArrayList<Item> fishes = new ArrayList<Item>();
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	// targetX,Y : 상어 위치
	// targetSize : 상어 크기
	static int N, cnt, targetX, targetY, targetSize = 2, time = 0;

	private boolean isOOB(int x, int y) {
		return x < 0 || x >= N || y < 0 || y >= N;
	} // isOOB

	private void solve() {
		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			String[] c = sc.readLine().split(" ");
			int size = c.length;

			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(c[j]);
				if (map[i][j] == 9) {
					targetX = j;
					targetY = i;
				} // end if
			} // end for
		} // end for

		while (true) {
			// 상어가 지나갈 수 있는 위치 저장
			Queue<Item> q = new LinkedList<Item>();
			// 상어가 먹은 물고기 위치 저장
			ArrayList<Item> fishes = new ArrayList<Item>();
			visited = new boolean[400];

			q.add(new Item(targetX, targetY, 0));
			visited[targetY * N + targetX] = true;

			int found = -1;
			while (!q.isEmpty()) {
				Item item = q.poll();
				int r = item.y;
				int c = item.x;
				int move = item.move;
				if (found == move) {
					break;
				} // end if

				for (int k = 0; k < 4; k++) {
					int nx = c + dx[k];
					int ny = r + dy[k];
					int next = ny * N + nx;

					if (!isOOB(nx, ny)) {
						if (visited[next])
							continue;
						visited[next] = true;
						if (targetSize >= map[ny][nx]) { // 상어가 지나갈 수 있는 경우
							if (map[ny][nx] > 0 && targetSize > map[ny][nx]) {
								// 물고기를 먹을 수 있는 곳을 찾음.
								// 현재 이동거리까지만 BFS 탐색하고 중단.
								found = move + 1;
								fishes.add(new Item(nx, ny, move + 1));
							} // end if
							q.add(new Item(nx, ny, move + 1));
						} // end if
					} // end if
				} // end for
			} // end while

			// 큐에 남은 것들은 먹을 수 있는 거리에 있는 영역들(크기가 동일하거나 작은 물고기 존재)
			if (found == -1) { // 먹을 물고기가 없다면 중단.
				break;
			} else { // 먹을 물고기 있다면, 상어 위치 이동 후, 다시 시작.
				if (fishes.size() > 1) {
					// 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기,
					// 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
					Collections.sort(fishes, new ySort());
				} // end if
			} // end else

			Item fish = fishes.get(0);
			if (found != -1) {
				time += found;

				// 상어 위치 이동
				map[targetY][targetX] = 0;
				targetX = fish.x;
				targetY = fish.y;
				map[targetY][targetX] = 9;

				// 상어 크기 update
				if (targetSize == ++cnt) {
					targetSize++;
					cnt = 0;
				} // end if
			} // end if

		} // end while
		System.out.println(time);
	} // solve

	static class ySort implements Comparator<Item> {
		// sort를 위한 class
		public int compare(Item i1, Item i2) {
			if (i1.y < i2.y) {
				return -1;
			} else if (i1.y == i2.y) {
				if (i1.x < i2.x) {
					return -1;
				} else if (i1.x == i2.x) {
					return 0;
				} // end else
				return 1;
			} else {
				return 1;
			} // end else
		} // compare
	} // class

	static class Item {
		int x; // 열 x축
		int y; // 행 y축
		int n; // visited를 위한 위치(1차원으로 나열했을 때 위치)
		int move; // 이동거리

		Item(int x, int y, int move) {
			this.x = x;
			this.y = y;
			this.n = this.y * N + this.x;
			this.move = move;
		} // Item
	} // class

	public static void main(String[] args) throws IOException {
		sc.init();
		new Main().solve();
	} // main

	static class sc {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		} // init

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		} // readLine

		static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", ""); //공백문자. 앞 문자가 하나 이상.
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			} //end while
			return st.nextToken();
		}

		static long nextLong() {
			return Long.parseLong(next());
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
