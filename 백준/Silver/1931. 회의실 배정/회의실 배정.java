import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	private final List<Lecture> lectures = new ArrayList<>();
	public static class Lecture {
		private final long start;
		private final long end;
		public Lecture(long start, long end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	private void proc() {
		long answer = 1;

		lectures.sort((o1, o2) -> {
			if (o1.end == o2.end) {
				return (int)(o1.start - o2.start);
			}
			return (int)(o1.end - o2.end);
		});

		long beforeEnd = lectures.get(0).end;
		for (int i = 1; i < lectures.size(); i++) {
			if (lectures.get(i).start >= beforeEnd) {
				answer++;
				beforeEnd = lectures.get(i).end;
			}
		}

		System.out.println(answer);
	}

	private void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			List<Long> input = Arrays.stream(br.readLine().split(" ")).map(Long::parseLong).collect(Collectors.toCollection(ArrayList::new));
			lectures.add(new Lecture(input.get(0), input.get(1)));
		}
	}
}