import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    private String[][] arr;
    private int M, N;
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        M = Integer.parseInt(tmp[0]);
        N = Integer.parseInt(tmp[1]);
        
        arr = new String[N][M];
        for(int i=0; i<N; i++) {
            arr[i] = br.readLine().split(" ");
        } //end for i
    } //input
    
    public class Node {
        int x, y, cnt;
        
        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    } //class Node
    
    /* 너비우선탐색 */
    public void bfs() {
        int[] dy = {-1, 1, 0, 0};
        int[] dx = {0, 0, -1, 1};
        
        boolean[][] visited = new boolean[N][M];
        Queue<Node> que = new LinkedList<Node>();
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j].equals("1")) {
                    que.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        } //end for i
        
        Node node = new Node(0, 0, 0);
        int nextX, nextY;
        while(!que.isEmpty()) {
            node = que.poll();
            
            for(int i=0; i<4; i++) {
                nextX = node.y + dx[i];
                nextY = node.x + dy[i];
                
                if(nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && arr[nextY][nextX].equals("0")) {
                    que.add(new Node(nextY, nextX, node.cnt+1));
                    arr[nextY][nextX] = "1";
                    visited[nextY][nextX] = true;
                }
            } //end for
            
        } //end while
        
        for(String[] val : arr) {
            for(String v : val) {
                if(v.equals("0")) {
                    // 익을 수 없는 토마토가 있는 경우
                    System.out.println(-1);
                    return;
                }
            }
        } //end for
        
        System.out.println(node.cnt);
    }
    
    public void proc() {
        boolean chk = false;
        out : for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(!arr[i][j].equals("-1")) {
                    // 토마토가 한 개 이상 있음.
                    chk = true;
                    break out;
                }
            } 
        } //end for i
        
        if(!chk) {
            // 토마토가 없음.
            System.out.println(-1);
            return;
        }
        
        // 토마토가 한 개 이상 있음.
        chk = false;
        out : for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j].equals("0")) {
                    // 안 익은 토마토가 한 개 이상 있음.
                    chk = true;
                    break out;
                }
            }
        } //end for i
        
        if(!chk) {
            // 모두 익은 토마토
            System.out.println(0);
            return;
        }
        
        // 한 개라도 안 익은 토마토가 있음.
        bfs();
    } //proc
    
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    }
}
