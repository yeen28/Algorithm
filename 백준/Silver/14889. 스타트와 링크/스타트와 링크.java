import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
	private int n;
	private int[][] ability;
	private boolean[] checked;
	private int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		combi(0, 0);
		System.out.println(min);
	}

	private void combi(int idx, int cnt) {
		if (cnt == n / 2) {
			int[] teamStart = IntStream.range(0, checked.length)
					.filter(i -> checked[i])
					.toArray();
			int[] teamLink = IntStream.range(0, checked.length)
					.filter(i -> !checked[i])
					.toArray();

			int teamStartScore = 0;
			int teamLinkScore = 0;
			for (int i = 0; i < cnt - 1; i++) {
				for (int j = i + 1; j < cnt; j++) {
					teamStartScore += ability[teamStart[i]][teamStart[j]] + ability[teamStart[j]][teamStart[i]];
					teamLinkScore += ability[teamLink[i]][teamLink[j]] + ability[teamLink[j]][teamLink[i]];
				}
			}

			int diffMin = Math.abs(teamStartScore - teamLinkScore);
			min = Math.min(min, diffMin);
			return;
		}

		for (int i = idx; i < n; i++) {
			if (min == 0) {
				return;
			}

			if (!checked[i]) {
				checked[i] = true;
				combi(i + 1, cnt + 1);
				checked[i] = false;
			}
		}
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ability = new int[n][n];
		checked = new boolean[n];

		StringTokenizer stk;
		for (int i = 0; i < n; i++) {
			stk = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++) {
				ability[i][j] = Integer.parseInt(stk.nextToken());
			}
		}
	}
}