import java.util.Stack;

class Solution {
	public int solution(int[] order) {
		int answer = 1;
		int nextOrder = order[0] + 1;
		Stack<Integer> stack = new Stack<>();
		for (int i = 1; i < order[0]; i++) {
			stack.push(i);
		}

		for (int i = 1; i < order.length; i++) {
			if (!stack.isEmpty() && stack.peek() == order[i]) {
				answer++;
				stack.pop();
			} else if (nextOrder == order[i]) {
				answer++;
				nextOrder++;
			} else if (nextOrder < order[i]) {
				for (int j = nextOrder; j < order[i]; j++) {
					stack.push(j);
				}
				nextOrder = order[i];
				i--;
			} else {
				return answer;
			}

			if (stack.isEmpty()) {
				stack.push(nextOrder);
			}
		}
		return answer;
	}
}