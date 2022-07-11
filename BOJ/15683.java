import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private class Point {
		int x, y;

		private Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	} // class

	private int N, M;
	private int[][] board1;
	private int[][] board2;
	private int blindSpotCnt;
	private List<Point> cctv;
	private int[] dx = { -1, 0, 1, 0 }; // 상우하좌(북동남서)
	private int[] dy = { 0, 1, 0, -1 }; // 상우하좌(북동남서)
	private int monitorSpot;

	public boolean isOOB(int x, int y) { // Out Of Bound
		return x < 0 || x >= N || y < 0 || y >= M;
	} // isOOB

	public void monitor(int x, int y, int dir) {
		dir %= 4;
		
		while (true) {
			x = x + dx[dir];
			y = y + dy[dir];

			if (isOOB(x, y) || board2[x][y] == 6)
				return;

			if (board2[x][y] != 0)
				continue;

			board2[x][y] = 7;
			monitorSpot++;
		}
	} // monitor

	public void proc() {
		int answer = blindSpotCnt;
		int min = blindSpotCnt;
		board2 = new int[N][M];

		// 4진법
		for (int r = 0; r < (1 << (2 * cctv.size())); r++) {
			int tmp = r;
			monitorSpot = 0;
			
			// board2에 board1 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					board2[i][j] = board1[i][j];
				}
			} // end for i
			
			for (int c = 0; c < cctv.size(); c++) {
				int dir = tmp % 4;
				tmp /= 4;


				int x = cctv.get(c).x;
				int y = cctv.get(c).y;

				if (board1[x][y] == 1) { // 1번 CCTV
					monitor(x, y, dir);

				} else if (board1[x][y] == 2) { // 2번 CCTV
					monitor(x, y, dir);
					monitor(x, y, dir + 2);

				} else if (board1[x][y] == 3) { // 3번 CCTV
					monitor(x, y, dir);
					monitor(x, y, dir + 1);

				} else if (board1[x][y] == 4) { // 4번 CCTV
					monitor(x, y, dir);
					monitor(x, y, dir + 1);
					monitor(x, y, dir + 2);

				} else if (board1[x][y] == 5) { // 5번 CCTV
					monitor(x, y, dir);
					monitor(x, y, dir + 1);
					monitor(x, y, dir + 2);
					monitor(x, y, dir + 3);
				} // end if

			} //end for c

			min = blindSpotCnt - monitorSpot;
			answer = Math.min(min, answer);
		} // end for r
		
		// board2 출력
		for(int[] val : board2) {
			for(int v : val)
				System.out.print(v + " ");
			System.out.println();
		}

		System.out.println(answer);
	} // proc

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(stk.nextToken());
		M = Integer.parseInt(stk.nextToken());

		cctv = new ArrayList<Main.Point>();
		board1 = new int[N][M];
		blindSpotCnt = 0;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board1[i][j] = Integer.parseInt(stk.nextToken());

				if (board1[i][j] != 0 && board1[i][j] != 6)
					cctv.add(new Point(i, j));

				if (board1[i][j] == 0)
					blindSpotCnt++;
			}
		} // end for i
	} // input

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	} // main

}
