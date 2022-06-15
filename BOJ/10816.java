import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br.readLine();
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		Map<Integer, Integer> mapN = new HashMap<Integer, Integer>();
		int key;
		while(stk.hasMoreTokens()) {
			key = Integer.parseInt(stk.nextToken());
			mapN.put(key, mapN.getOrDefault(key, 0)+1);
		}
		
		br.readLine();
		stk = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		while(stk.hasMoreTokens()) {
			key = Integer.parseInt(stk.nextToken());
			sb.append(mapN.getOrDefault(key, 0)).append(" ");
		}
		
		System.out.println(sb);
	} // main
}
