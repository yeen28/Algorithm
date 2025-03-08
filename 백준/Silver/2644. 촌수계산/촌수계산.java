import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int familyNum; // 전체 가족 수
	static int[] findAns = new int[2]; // 촌수를 계산하려는 가족 번호
	static int[][] relatives; // 촌수(부모-자식)
	static int[] dist;

	public static void main(String[] args) throws IOException {
		input();
		dfs(findAns[0] - 1);
		System.out.println(dist[findAns[1] - 1]);
	}

	static void dfs(int num) {
		for (int i = 0; i < familyNum; i++) {
			if (dist[i] == -1 && relatives[num][i] == 1) {
				dist[i] = dist[num] + 1; // 촌수 갱신
				dfs(i);
			}
		}
	}

	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		familyNum = Integer.parseInt(br.readLine());
		relatives = new int[familyNum][familyNum];
		dist = new int[familyNum];

		for (int i = 0; i < familyNum; i++) {
			dist[i] = -1;
		}

		StringTokenizer stk = new StringTokenizer(br.readLine());
		findAns[0] = Integer.parseInt(stk.nextToken());
		findAns[1] = Integer.parseInt(stk.nextToken());

		int relationNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < relationNum; i++) {
			stk = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(stk.nextToken()) - 1;
			int f2 = Integer.parseInt(stk.nextToken()) - 1;
			relatives[f1][f2] = 1;
			relatives[f2][f1] = 1;
		}
		
		dist[findAns[0] - 1] = 0;
	}
}
