import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		StringBuilder sb = new StringBuilder();

		main.input(sb);
		System.out.println(sb);
	}

	public void proc(int L, int P, int V, int i, StringBuilder sb) {
		int day = V / P;
		int remain = V % P;
		int result = L * day;
		if (L - remain >= 0) {
			result += remain;
		} else {
			result += L;
		}

		sb.append(String.format("Case %d: %d\n", i, result));
	}

	public void input(StringBuilder sb) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;

		String in;
		int L, P, V;
		int i = 0;
		while (!"0 0 0".equals((in = br.readLine()))) {
			i++;
			stk = new StringTokenizer(in);
			L = Integer.parseInt(stk.nextToken());
			P = Integer.parseInt(stk.nextToken());
			V = Integer.parseInt(stk.nextToken());

			proc(L, P, V, i, sb);
		}
	}
}
