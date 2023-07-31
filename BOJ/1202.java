import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	class Jewel implements Comparable<Jewel> {
		private long weight;
		private long price;

		Jewel(long weight, long price) {
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Jewel jewel) {
			// weight 기준으로 오름차순 정렬.
			// weight가 같은 경우 price 내림차순 정렬
			return (int) (this.weight == jewel.weight ? jewel.price - this.price :
					this.weight - jewel.weight);
		}
	}

	List<Long> bags = new ArrayList<>();
	List<Jewel> jewels = new ArrayList<>();
	PriorityQueue<Long> jewelsPriceInBag = new PriorityQueue<>(Collections.reverseOrder());

	public static void main(String[] args) throws IOException {
		Main main = new Main();

		main.input();
		main.proc();
	}

	public void proc() {
		long result = 0;
		int idx = 0;

		for (int i = 0; i < bags.size(); i++) {
			for (int j = idx; j < jewels.size(); j++) {
				if (jewels.get(j).weight <= bags.get(i)) {
					idx++;
					jewelsPriceInBag.add(jewels.get(j).price);
				} else {
					break;
				}
			}
			if (jewelsPriceInBag.isEmpty()) continue;
			result += jewelsPriceInBag.poll();
		}

		System.out.println(result);
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			jewels.add(new Jewel(
					Long.parseLong(stk.nextToken()),
					Long.parseLong(stk.nextToken())
			));
		}

		for (int i = 0; i < K; i++) {
			bags.add(Long.parseLong(br.readLine()));
		}

		Collections.sort(bags);
		Collections.sort(jewels);
	}
}
