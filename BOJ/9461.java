import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public long[] dp = new long[999];
    
    public void proc(int N) {
        if(dp[N-1] > 0) {
            sb.append(dp[N-1]).append('\n');
            return;
        } //end if
        
        for(int i=3; i<N; i++){
            dp[i] = dp[i-2] + dp[i-3];
        }
        
        sb.append(dp[N-1]).append('\n');
    } //proc
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
        int T = Integer.parseInt(br.readLine());
		
        int N;
        dp[0] = dp[1] = dp[2] = 1;
		
        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            proc(N);
        } //end for

        br.close();
    } // input
	
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println(sb);
    } // main
}
