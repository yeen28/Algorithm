import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String args[]) throws IOException {
        Main m = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        long cnt = 0, sum = 0;

        for(int i=1; ; i++) {
            if(sum > S) break;
            sum += i;
            cnt++;
        }
        
        System.out.println(cnt-1);
        
        br.close();
    }
}
