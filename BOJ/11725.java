import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
	private int[] answer;
	private boolean[] visited;
	private ArrayList<Integer>[] inList;
	private int N;

	private void dfs(int parent) {
		visited[parent] = true;

		for (int val : inList[parent]) {
			if( !visited[val] ) {
				answer[val] = parent;
				dfs(val);
            }
        }
	} // dfs

	private void proc() {
		dfs(1);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			for (int i = 2; i < answer.length; i++)
				bw.append(String.valueOf(answer[i])).append("\n");

			bw.flush();
			bw.close();
		} catch (IOException e) {
		}
	}

	private void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			N = Integer.parseInt(br.readLine());

			answer = new int[N + 1];
			visited = new boolean[N + 1];
			inList = new ArrayList[N + 1];
            
			for(int i = 1; i <= N; i++) {
				inList[i] = new ArrayList<Integer>();
			}

			for (int i = 0; i < N - 1; i++) {
				String[] in = br.readLine().split(" ");
				inList[Integer.parseInt(in[0])].add(Integer.parseInt(in[1]));
				inList[Integer.parseInt(in[1])].add(Integer.parseInt(in[0]));
			} // end for

			br.close();
		} catch (NumberFormatException e) {
		} catch (IOException e) {
		}

	} // input

	public static void main(String[] args) {
		Main main = new Main();
		main.input();
		main.proc();
	}
}
