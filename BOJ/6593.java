import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public int L, R, C;
	public int[] dl = { 0, 0, 0, 0, -1, 1 }; // 상하좌우위아래
	public int[] dx = { -1, 1, 0, 0, 0, 0 }; // 상하좌우위아래
	public int[] dy = { 0, 0, -1, 1, 0, 0 }; // 상하좌우위아래
	public static StringBuilder sb = new StringBuilder();

	public class Point {
		int l, x, y, cnt;

		public Point(int l, int x, int y, int cnt) {
			this.l = l;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	} // class

	public boolean isOOB(int l, int x, int y) {
		return l < 0 || l >= L || x < 0 || x >= R || y < 0 || y >= C;
	}

	public void BFS(char[][][] building, Point start, Point end) {
		Queue<Point> que = new LinkedList<Point>();
		Point p = null;

		que.add(start);

		while (!que.isEmpty()) {
			p = que.poll();

			if (p.l == end.l && p.x == end.x && p.y == end.y) {
				sb.append("Escaped in ").append(p.cnt).append(" minute(s).").append("\n");
				return;
			}

			int nl = 0, nx = 0, ny = 0;
			for (int i = 0; i < 6; i++) {
				nl = p.l + dl[i];
				nx = p.x + dx[i];
				ny = p.y + dy[i];

				if (!isOOB(nl, nx, ny) && (building[nl][nx][ny] == '.' || building[nl][nx][ny] == 'E')) {
					que.add(new Point(nl, nx, ny, p.cnt+1));
					building[nl][nx][ny] = '#';
				} //end if
			} //end for i
		} // end while

		sb.append("Trapped!").append("\n");
	} // BFS

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		StringTokenizer stk;
		char[][][] building = null;
		Point start = null, end = null;

		while (!"0 0 0".equals((input = br.readLine()))) {
			stk = new StringTokenizer(input, " ");
			L = Integer.parseInt(stk.nextToken());
			R = Integer.parseInt(stk.nextToken());
			C = Integer.parseInt(stk.nextToken());

			building = new char[L][R][C];

			String str = "";
			char ch;
			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					str = br.readLine();
					for (int k = 0; k < C; k++) {
						ch = str.charAt(k);
						building[i][j][k] = ch;
						if (ch == 'S')
							start = new Point(i, j, k, 0);
						else if (ch == 'E')
							end = new Point(i, j, k, 0);
					}
				}

				br.readLine();
			} // end for i

			BFS(building, start, end);
		} // end while

		br.close();
	} // input

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		System.out.println(sb);
	} // main

}
