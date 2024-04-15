import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	private final List<Pair> resultKN = new ArrayList<>();
	public static class Pair {
		private final int k;
		private final int n;
		public Pair(int k, int n) {
			this.k = k;
			this.n = n;
		}
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		int[][] map = initMap();

		for (Pair pair : resultKN) {
			System.out.println(map[pair.k][pair.n]);
		}
	}

	private int[][] initMap() {
		int[][] map = new int[15][16];
		for (int i = 0; i < map.length; i++) {
			map[i][1] = 1;
			for (int j = 2; j < map[i].length; j++) {
				map[i][j] = (i > 0 ? map[i - 1][j] : 1) + map[i][j - 1];
			}
		}
		return map;
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			resultKN.add(new Pair(k, n));
		}
	}
}