import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private int[] seconds = new int[100001];
	private int N, K;
	private int result;

	public static void main(String[] args) {
		Main main = new Main();

		try {
			main.input();
			main.proc();
			main.print();

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private void print() {
		System.out.println(result);
	}

	private void proc() {
		result = bfs(N);
	}

	private int bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);

		seconds[node] = 1;
		Integer nodePop;
		while(Objects.nonNull(nodePop = queue.poll())) {
			if (nodePop == K) {
				return seconds[K] - 1;
			}

			// n - 1로 이동
			if (nodePop - 1 >= 0 && seconds[nodePop - 1] == 0) {
				seconds[nodePop - 1] = seconds[nodePop] + 1;
				queue.add(nodePop - 1);
			}

			// n + 1로 이동
			if (nodePop + 1 < seconds.length && seconds[nodePop + 1] == 0) {
				seconds[nodePop + 1] = seconds[nodePop] + 1;
				queue.add(nodePop + 1);
			}

			// 2n로 이동
			if (nodePop * 2 < seconds.length && seconds[nodePop * 2] == 0) {
				seconds[nodePop * 2] = seconds[nodePop] + 1;
				queue.add(nodePop * 2);
			}
		}

		return -1;
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		N = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
	}
}
