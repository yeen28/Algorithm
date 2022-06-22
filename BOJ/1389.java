import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    
    private static final int INF = 987654321;
    private int[][] arr;
    
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    }
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        
        arr = new int[N+1][N+1];
        for(int i=0; i<N+1; i++){
            for(int j=0; j<N+1; j++){
                if(i == j) continue;
                
                arr[i][j] = INF;
            }
        } //end for i
        
        int a=0, b=0;
        for(int i=0; i<M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(stk.nextToken());
            b = Integer.parseInt(stk.nextToken());
            
            arr[a][b] = arr[b][a] = 1;
        } //end for
    } //input
    
    public void proc() {
        int N = arr.length-1;
        
        for(int k=1; k<N+1; k++) {
            for(int i=1; i<N+1; i++) {
                for(int j=1; j<N+1; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
        
        System.out.println(findAnswer());
    } //proc
    
    public int findAnswer() {
        int N = arr.length-1;
        int cnt = 0;
        int min = INF;
        int rtn = 0;
        
        for(int i=1; i<N+1; i++) {
            cnt = 0;
            
            for(int j=1; j<N+1; j++) {
                cnt += arr[i][j];
            }
            
            if(min > cnt) {
                min = cnt;
                rtn = i;
            }
        } //end for i
        
        return rtn;
    } //findAnswer
}
