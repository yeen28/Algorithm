import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static final int[] dx = {0, 0, -1, 1};
	private static final int[] dy = {1, -1, 0, 0};
	private int[][] map;
	private final Map<Integer, Integer[]> bestFriends = new HashMap<>();

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		int sum = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				int cnt = 0;

				Integer[] bfArray = bestFriends.get(map[i][j]);
				for (int k = 0; k < 4; k++) {
					int nx = j + dx[k];
					int ny = i + dy[k];

					if (isOOB(nx, ny)) {
						continue;
					}

					if (Arrays.stream(bfArray).anyMatch(bf -> bf == map[ny][nx])) {
						cnt++;
					}
				}

				sum += Math.pow(10, (cnt - 1));
			}
		}

		System.out.println(sum);
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		StringTokenizer stk;
		for (int i = 0; i < N * N; i++) {
			stk = new StringTokenizer(br.readLine());
			int current = Integer.parseInt(stk.nextToken());
			bestFriends.put(current, new Integer[]{Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())});

			seatStudent(current);
		}
	}

	private boolean isOOB(int x, int y) {
		return x < 0 || y < 0 || x >= map.length || y >= map.length;
	}

	/**
	 * 상하좌우에 좋아하는 친구가 있는지?
	 */
	private boolean isBF(int current, int friend) {
		return Arrays.stream(bestFriends.get(current))
				.anyMatch(integer -> integer == friend);
	}

	private void seatStudent(int current) {
		int N = map.length;

		List<Integer[]> list = new ArrayList<>(); // bf count, empty count, i, j
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int bfCnt = 0; // 주위에 좋아하는 친구 수
				int emptyCnt = 0; // 주위에 빈 자리

				for (int k = 0; k < 4; k++) {
					int nx = j + dx[k];
					int ny = i + dy[k];

					if (isOOB(nx, ny)) {
						continue;
					}

					if (isBF(current, map[ny][nx])) {
						bfCnt++;
					}

					if (map[ny][nx] == 0) {
						emptyCnt++;
					}
				}

				list.add(new Integer[]{bfCnt, emptyCnt, i, j});
			}
		}

		// 정렬. 기준 -> 좋아하는 학생 수, 빈 자리 수, 행, 열
		list.sort((o1, o2) -> {
			if (o1[0] < o2[0]) { // 좋아하는 학생 수
				return 1;
			} else if (o1[0].equals(o2[0])) {
				if (o1[1] < o2[1]) { // 빈 자리 수
					return 1;
				} else if (o1[1].equals(o2[1])) {
					if (o1[2] > o2[2]) { // 행
						return 1;
					} else if (o1[2].equals(o2[2])) {
						if (o1[3] > o2[3]) { // 열
							return 1;
						}
					}
				}
			}

			return -1;
		});

		for (Integer[] integers : list) {
			int y = integers[2]; // 행
			int x = integers[3]; // 열

			if (map[y][x] == 0) {
				map[y][x] = current;
				return;
			}
		}
	}
}