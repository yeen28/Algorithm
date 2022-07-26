import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private int L, M, N;
    private int[] dl = {0, 0, 0, 0, -1, 1}; //상하좌우위아래
    private int[] dy = {-1, 1, 0, 0, 0, 0}; 
    private int[] dx = {0, 0, -1, 1, 0, 0};
    private int[][][] tomato;
    private static int answer = 0;
    
    public class Point {
		int l, x, y, cnt;

		public Point(int l, int x, int y, int cnt) {
			this.l = l;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	} // class
	
	public boolean isOOB(int l, int x, int y) {
		return l < 0 || l >= L || x < 0 || x >= N || y < 0 || y >= M;
	}
    
    public void BFS() {
		Queue<Point> que = new LinkedList<Point>();
		Point p = null;
		int nl = 0, nx = 0, ny = 0;
		
		for(int layer=0; layer<L; layer++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(tomato[layer][i][j] == 1) {
                        que.add(new Point(layer, i, j, 0));
                    }
                }
            }
        }
        
		while (!que.isEmpty()) {
			p = que.poll();

			for (int i = 0; i < 6; i++) {
				nl = p.l + dl[i];
				nx = p.x + dx[i];
				ny = p.y + dy[i];

				if (!isOOB(nl, nx, ny) && tomato[nl][nx][ny] == 0) {
					que.add(new Point(nl, nx, ny, p.cnt+1));
					tomato[nl][nx][ny] = 1;
				} //end if
			} //end for i
		} // end while
		
		if(p != null) answer = p.cnt;
	} // BFS
	
	public void result() {
	    for(int layer=0; layer<L; layer++) {
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(tomato[layer][i][j] == 0) {
                        answer = -1;
                        return;
                    }
                }
            }
        }
	}
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        // M : 가로길이, N : 세로길이, l : 층
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());
        L = Integer.parseInt(stk.nextToken());
        tomato = new int[L][N][M];
        
        for(int layer=0; layer<L; layer++) {
            for(int i=0; i<N; i++) {
                stk = new StringTokenizer(br.readLine(), " ");
                for(int j=0; j<M; j++) {
                    tomato[layer][i][j] = Integer.parseInt(stk.nextToken());
                }
            }
        }
        
        br.close();
    } //input
    
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.BFS();
        main.result();
        System.out.println(answer);
    } //main
}
