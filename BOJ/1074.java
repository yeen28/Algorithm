import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int N, r, c;
    
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    }
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(stk.nextToken());
        // r행 c열
        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
    }
    
    public void proc() {
        int y = (int)Math.pow(2, N) / 2;
        int x = y;
        int answer = 0;
        
        while(N-- > 0) { //비교 후 감소
            int tmp = (int)Math.pow(2, N) / 2;
            int skip = (int)Math.pow(4, N);
            
            if(r < y && c < x) { 
                //1구역
                x -= tmp;
                y -= tmp;
            } else if(r < y && c >= x) { 
                //2구역
                x += tmp;
                y -= tmp;
                answer += skip;
            } else if(r >= y && c < x) { 
                //3구역
                x -= tmp;
                y += tmp;
                answer += skip*2;
            } else { 
                //4구역
                x += tmp;
                y += tmp;
                answer += skip*3;
            }
        } //end while
        
        System.out.println(answer);
    }
}
