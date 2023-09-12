import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	private List<Lecture> lectures = new ArrayList<>();
	private PriorityQueue<Integer> lecturesEnds = new PriorityQueue<>();

	class Lecture implements Comparable<Lecture> {
		private int start;
		private int end;

		public Lecture(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture lecture) {
			if (this.start == lecture.start) {
				return this.end - lecture.end;
			}

			return this.start - lecture.start;
		}
	}

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	}

	public void proc() {
		// lectures의 start를 기준으로 정렬
		lectures = lectures.stream().sorted().collect(Collectors.toList());

		// 정렬된 강의 시간 중 첫 번째 원소의 end를 우선순위 큐에 담기
		lecturesEnds.add(lectures.get(0).end);

		for (int i = 1; i < lectures.size(); i++) {
			if (lectures.get(i).start >= lecturesEnds.peek()) {
				lecturesEnds.poll();
			}
			lecturesEnds.add(lectures.get(i).end);
		}

		System.out.println(lecturesEnds.size());
	}

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer stk;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			lectures.add(new Lecture(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken())));
		}
	}
}
