import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static final char OPEN_PARENTHESIS = '(';
	private static final char CLOSE_PARENTHESIS = ')';
	private static final char OPEN_SQUARE_BRACKET = '[';
	private static final char CLOSE_SQUARE_BRACKET = ']';

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String sentence = br.readLine();

		while (!".".equals(sentence)) { // 입력 끝 조건 : "."
			if (checkBracketPairs(sentence)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

			sentence = br.readLine();
		}
	}

	private static boolean checkBracketPairs(String sentence) {
		Deque<Character> leftBrackets = new ArrayDeque<>();

		for (int i = 0; i < sentence.length(); i++) { // 문장 안의 문자들을 돌면서
			char ch = sentence.charAt(i);

			if (ch == OPEN_PARENTHESIS || ch == OPEN_SQUARE_BRACKET) { // ch가 여는 괄호인 경우
				leftBrackets.push(ch); // leftBrackets에 여는 괄호만 push

			} else if (ch == CLOSE_PARENTHESIS) {
				if (leftBrackets.isEmpty() || leftBrackets.peek() != OPEN_PARENTHESIS) {
					return false; // ch가 )가 아니면 결과는 NO
				} else {
					// ch가 )인 경우 stack top은 (이어야 pop 가능
					leftBrackets.pop();
				}

			} else if (ch == CLOSE_SQUARE_BRACKET) {
				if (leftBrackets.isEmpty() || leftBrackets.peek() != OPEN_SQUARE_BRACKET) {
					return false; // ch가 ]가 아니면 결과는 NO
				} else {
					// ch가 ]인 경우 stack top은 [이어야 pop 가능
					leftBrackets.pop();
				}

			} else if (i == sentence.length() - 1) {
				return leftBrackets.isEmpty();
			}
		}

		return false;
	}
}
