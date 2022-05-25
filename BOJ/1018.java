import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	private static boolean[][] board;
	private static int answer=64;
	
	public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        board = new boolean[N][M];
        
		String input;
		for (int i = 0; i < N; i++) {
			input = br.readLine();
			
			for (int j = 0; j < M; j++) {
				if (input.charAt(j) == 'W') { // W -> true
					board[i][j] = true;
				} // end if
			} // end for j
		} // end for i
        
		proc(N, M, board);
	}
	
	private void proc(int N, int M, boolean[][] board) {
		int NRow = N-7;
		int MCol = M-7;
		for(int i=0; i<NRow; i++) {
			for(int j=0; j<MCol; j++) {
				find(i, j);
			} //end for j
		} //end for i
		
		System.out.println(answer);
	} //proc
	
	private void find(int i, int j) {
		int endRow = j+8;
		int endCol = i+8;
		
		boolean TF = board[i][j];
		
		int cnt=0;
		for(int k=i; k<endCol; k++) {
			for(int l=j; l<endRow; l++) {
				if(board[k][l] != TF) {
					cnt++;
				} //end if
				
				TF = (!TF);
			} //end for l
			
			TF = (!TF); // 항상 8x8(짝수) 크기이므로 이전 행의 끝 색은 다음 행의 시작 색과 같다. 
		} //end for k
		
		cnt = Math.min(cnt, 64-cnt);
		answer = Math.min(answer, cnt);
	} //find

	public static void main(String args[]) throws IOException {
		Main main = new Main();
		
		main.input();
	}
}
