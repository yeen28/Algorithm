import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	PriorityQueue<Integer> priorityQueue;
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
		result = 0;
		while (priorityQueue.size() > 1) {
			int x = priorityQueue.poll();
			int y = priorityQueue.poll();
			result += x + y;
			priorityQueue.add(x + y);
		}
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		priorityQueue = new PriorityQueue<>();

		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			priorityQueue.add(Integer.parseInt(br.readLine()));
		}
	}
}
