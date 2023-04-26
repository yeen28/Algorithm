import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private long[] distance;
	private long[] cost;
	private long result;

	public static void main(String[] args) {
		Main main = new Main();
		main.input();
		main.proc();
		main.print();
	}

	private void print() {
		System.out.println(result);
	}

	private void proc() {
		long minCost = cost[0];

		for (int i = 0; i < cost.length - 1; i++) {
			if (cost[i] < minCost) {
				minCost = cost[i];
			}

			result += minCost * distance[i];
		}
	}

	private void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			distance = new long[N - 1];
			cost = new long[N];

			// save distance
			StringTokenizer stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < distance.length; i++) {
				distance[i] = Long.parseLong(stk.nextToken());
			}

			// save cost
			stk = new StringTokenizer(br.readLine());
			for (int i = 0; i < cost.length; i++) {
				cost[i] = Long.parseLong(stk.nextToken());
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
