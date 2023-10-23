// https://y-e-un28.tistory.com/537

import java.util.PriorityQueue;

class Solution {
	public int solution(int[] scoville, int K) {
		int answer = 0;
		PriorityQueue<Integer> que = new PriorityQueue<>();

		for (int num : scoville) {
			que.add(num);
		}

		while (que.peek() < K) {
			if (que.size() < 2) {
				return -1;
			}

			que.add(que.poll() + que.poll() * 2);
			answer++;
		}

		return answer;
	}
}
