import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int familyNum; // 전체 가족 수
	static int[] findAns = new int[2]; // 촌수를 계산하려는 가족 번호
	static int[][] relatives; // 촌수(부모-자식) 관계
	static int[] dist;

	public static void main(String[] args) throws IOException {
		input();
		dfs(findAns[0] - 1);  // 0-based index
		// dist[findAns[1] - 1] == -1이면 촌수를 찾지 못한 경우, -1 출력
		System.out.println(dist[findAns[1] - 1]);
	}

	// 깊이 우선 탐색 (DFS)
	static void dfs(int num) {
		for (int i = 0; i < familyNum; i++) {
			// 아직 방문하지 않았고, 두 사람 간에 관계가 있으면
			if (dist[i] == -1 && relatives[num][i] == 1) {
				dist[i] = dist[num] + 1; // 촌수 갱신
				dfs(i); // 다음 사람으로 깊이 우선 탐색
			}
		}
	}

	// 입력 받는 메서드
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		familyNum = Integer.parseInt(br.readLine());
		relatives = new int[familyNum][familyNum];
		dist = new int[familyNum];

		// dist 배열을 -1로 초기화
		for (int i = 0; i < familyNum; i++) {
			dist[i] = -1;
		}

		// 찾고자 하는 두 가족 번호 입력
		StringTokenizer stk = new StringTokenizer(br.readLine());
		findAns[0] = Integer.parseInt(stk.nextToken());
		findAns[1] = Integer.parseInt(stk.nextToken());

		// 관계의 개수 입력
		int relationNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < relationNum; i++) {
			stk = new StringTokenizer(br.readLine());
			int f1 = Integer.parseInt(stk.nextToken()) - 1; // 0-based index
			int f2 = Integer.parseInt(stk.nextToken()) - 1; // 0-based index

			// 관계 설정 (양방향)
			relatives[f1][f2] = 1;
			relatives[f2][f1] = 1;
		}

		// 시작 지점은 0 (findAns[0] - 1)
		dist[findAns[0] - 1] = 0;
	}
}
