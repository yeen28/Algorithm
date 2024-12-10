import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private final int[] dice = new int[7];
	private final int[] dx = {1, -1, 0, 0}; // 동서북남
	private final int[] dy = {0, 0, -1, 1};
	private int[][] map;
	private int[] arrMove; // 동:1, 서:2, 북:3, 남:4
	private int diceLocX;
	private int diceLocY;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		for (int i : arrMove) {
			int nx = diceLocX + dx[i - 1];
			int ny = diceLocY + dy[i - 1];

			if (isOOB(nx, ny)) {
				continue;
			}

			move(nx, ny, i);
			diceLocX = nx;
			diceLocY = ny;
		}
	}

	private void move(int x, int y, int i) {
		int temp = dice[3];
		switch (i) {
			case 1 -> { // 동
				dice[3] = dice[4];
				dice[4] = dice[6];
				dice[6] = dice[2];
				dice[2] = temp;
			}
			case 2 -> { // 서
				dice[3] = dice[2];
				dice[2] = dice[6];
				dice[6] = dice[4];
				dice[4] = temp;
			}
			case 3 -> { // 북
				dice[3] = dice[5];
				dice[5] = dice[6];
				dice[6] = dice[1];
				dice[1] = temp;
			}
			case 4 -> { // 남
				dice[3] = dice[1];
				dice[1] = dice[6];
				dice[6] = dice[5];
				dice[5] = temp;
			}
		}

		if (map[y][x] == 0) {
			map[y][x] = dice[6];
		} else {
			dice[6] = map[y][x];
			map[y][x] = 0;
		}

		System.out.println(dice[3]);
	}

	private boolean isOOB(int x, int y) {
		return x < 0 || y < 0 || map.length <= y || map[0].length <= x;
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		map = new int[Integer.parseInt(stk.nextToken())][Integer.parseInt(stk.nextToken())];

		diceLocY = Integer.parseInt(stk.nextToken());
		diceLocX = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());
		arrMove = new int[K];

		for (int i = 0; i < map.length; i++) {
			stk = new StringTokenizer(br.readLine());

			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(stk.nextToken());
			}
		}

		arrMove = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}
}