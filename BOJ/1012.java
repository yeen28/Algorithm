import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Main {
    //상:(-1,0),하:(1,0),좌:(0,-1),우:(0,1)
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    private static StringBuilder sbAnswer = new StringBuilder();
    private int M, N;
    private int[][] arr;
    
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        
        main.input();
        System.out.println(sbAnswer);
    }
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int T = Integer.parseInt(br.readLine());
        
        for(int testcase = 0; testcase < T; testcase++) {
            stk = new StringTokenizer(br.readLine(), " ");
            // M : 가로길이, N : 세로길이
            M = Integer.parseInt(stk.nextToken());
            N = Integer.parseInt(stk.nextToken());
            int K = Integer.parseInt(stk.nextToken());
            arr = new int[N][M];
            
            int X = -1, Y = -1;
            for(int i = 0; i < K; i++) {
                stk = new StringTokenizer(br.readLine(), " ");
                X = Integer.parseInt(stk.nextToken());
                Y = Integer.parseInt(stk.nextToken());
                arr[Y][X] = 1;
            }
            
            proc(arr);
        } //end for testcase
    } //input
    
    public void proc(int[][] arr) {
        int cnt = 0;
        
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 1) {
                    cnt++;
                    arr[i][j] = 0;
                    chgZero(i, j);//재귀로 주변을 0으로 만들기
                }
            }
        }
        
        sbAnswer.append(cnt).append('\n');
    } //proc
    
    public void chgZero(int y, int x) {
        int nextX, nextY;
        
        for(int i=0; i<4; i++) {
            nextX = x+dx[i];
            nextY = y+dy[i];
            
            if(nextX>=0 && nextX<M && nextY>=0 && nextY<N && arr[nextY][nextX] == 1) {
                arr[nextY][nextX] = 0;
                chgZero(nextY, nextX);
            }
        }
    } //chgZero
}
