import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String b = br.readLine();

		while (!".".equals(b)) {
			Stack<Character> leftBracket = new Stack<>();
			char[] ch = b.toCharArray();
			if ('.' != b.toCharArray()[b.length() - 1]) {
				System.out.println("no");
				continue;
			}
			for (int i = 0; i < b.length(); i++) { // 한 문장씩 돌면서
				if (ch[i] == '(' || ch[i] == '[') { // ch가 여는 괄호인 경우
					leftBracket.push(ch[i]); // leftBracket에 여는 괄호만 push
				} else if (ch[i] == ')') {
					if (leftBracket.isEmpty() || leftBracket.peek() != '(') {
						System.out.println("no"); // ch가 )가 아니면 결과는 NO
						break;
					} else {
						// ch가 )인 경우 stack top은 (이어야 pop 가능
						leftBracket.pop();
					}
				} else if (ch[i] == ']') {
					if (leftBracket.isEmpty() || leftBracket.peek() != '[') {
						System.out.println("no"); // ch가 ]가 아니면 결과는 NO
						break;
					} else {
						// ch가 ]인 경우 stack top은 [이어야 pop 가능
						leftBracket.pop();
					}
				} else if (i == b.length() - 1) {
					if (leftBracket.isEmpty()) {
						System.out.println("yes");
					} else {
						System.out.println("no");
					}
				}
			}
			b = br.readLine();
		}
	}
}
