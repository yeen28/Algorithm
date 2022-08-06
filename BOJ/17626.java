import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String args[]) throws IOException {
        Main m = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;
        
        int min = Integer.MAX_VALUE;
        for(int i=2; i<=N; i++) {
            min = Integer.MAX_VALUE;
            
            for(int j=1; j<=i; j++) {
                if(i-j*j < 0) break;
                
                min = Math.min(min, dp[i-j*j]);
            }
            dp[i] = min + 1;
        }
        
        System.out.println(dp[N]);
        
        br.close();
    }
}
