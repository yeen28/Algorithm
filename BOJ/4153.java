import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] intArr = new int[3];
		StringTokenizer stk;
		StringBuilder sb = new StringBuilder();
		String input;
		
		while (!(input = br.readLine()).equals("0 0 0")) {
			stk = new StringTokenizer(input, " ");
			
			for(int i=0; i<3; i++)
				intArr[i] = Integer.parseInt(stk.nextToken());
			
			Arrays.sort(intArr);

			if ((Math.pow(intArr[0], 2) + Math.pow(intArr[1], 2)) == Math.pow(intArr[2], 2)) {
				sb.append("right");
			} else {
				sb.append("wrong");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
