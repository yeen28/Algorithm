import java.util.Stack;

class Solution {
	public String solution(int n) {
		StringBuilder answer = new StringBuilder();

		Stack<String> stack = new Stack<>();
		long quotient = n;
		while (quotient != 0) {
			if (quotient % 3 == 0) {
				stack.push("4");
				quotient = quotient / 3 - 1;
				continue;
			} else if (quotient % 3 == 1) {
				stack.push("1");
			} else {
				stack.push("2");
			}

			quotient /= 3;
		}

		while (!stack.isEmpty()) {
			answer.append(stack.pop());
		}

		return answer.toString();
	}
}