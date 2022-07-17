import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.List;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Main {
	public final static int MAX = 0xf7f7f7;
	public int K, X;
	public List<Edge>[] listEdge;
	public int[] arrCost; // 비용

	public class Edge {
		int v, c;

		public Edge(int vertex, int cost) {
			v = vertex;
			c = cost;
		}
	} // class

	public void proc() throws IOException {
		PriorityQueue<Integer> pque = new PriorityQueue<Integer>();
		pque.add(X);

		arrCost[X] = 0;

		int vertex = 0;
		while (!pque.isEmpty()) {
			vertex = pque.poll();

			for (Edge e : listEdge[vertex]) {
				if (arrCost[e.v] > e.c + arrCost[vertex]) {
					arrCost[e.v] = e.c + arrCost[vertex];
					pque.add(e.v);
				}
			}
		} // end for i

		findAnswer();
	} // proc

	/* 정답 찾기 */
	public void findAnswer() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean isExist = false;
		for (int i = 0; i < arrCost.length; i++) {
			if (arrCost[i] == K) {
				bw.write(i + "\n");
				isExist = true;
			} // end if
		} // end for i

		if (!isExist)
			bw.write(-1 + "\n");
		bw.flush();
	} // findAnswer

	/* 입력 */
	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		K = Integer.parseInt(stk.nextToken());
		X = Integer.parseInt(stk.nextToken());

		listEdge = new ArrayList[N + 1];
		arrCost = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			listEdge[i] = new ArrayList<Edge>();
			arrCost[i] = MAX;
		} // end for i

		int start = 0, end = 0;
		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine(), " ");
			start = Integer.parseInt(stk.nextToken());
			end = Integer.parseInt(stk.nextToken());
			listEdge[start].add(new Edge(end, 1));
		}
		
		br.close();
	} // input

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.input();
		main.proc();
	} // main
}
