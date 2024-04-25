import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private final List<Person> people = new ArrayList<>();

	public static class Person {
		private final int loc, weight, height;
		private int rank;

		public Person(int loc, int weight, int height) {
			this.loc = loc;
			this.weight = weight;
			this.height = height;
			this.rank = 1;
		}
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		int[] answer = new int[people.size()];

		people.sort(Comparator.comparingInt(o -> o.weight));

		for (int i = 0; i < people.size(); i++) {
			for (int j = i + 1; j < people.size(); j++) {
				if (people.get(i).weight < people.get(j).weight && people.get(i).height < people.get(j).height) {
					people.get(i).rank++;
				}
			}
		}

		people.forEach(person -> answer[person.loc - 1] = person.rank);
		StringJoiner joiner = new StringJoiner(" ");
		for (int num : answer) {
			joiner.add(String.valueOf(num));
		}
		System.out.println(joiner);
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= n; i++) {
			String[] input = br.readLine().split(" ");
			people.add(new Person(i, Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}
	}
}