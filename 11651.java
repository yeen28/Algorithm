import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public Point[] points;

	public class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void proc() {
		StringBuilder ans = new StringBuilder();
		
		Arrays.sort(points, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.y == o2.y) {
					return o1.x - o2.x;
				}

				return o1.y - o2.y;
			}
		});
		
		for(Point p : points) {
			ans.append(p.x).append(" ").append(p.y).append('\n');
		}
		
		System.out.println(ans);
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		int n = Integer.parseInt(br.readLine());

		points = new Point[n];
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());
			points[i] = new Point(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
		}
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	} // main
}
