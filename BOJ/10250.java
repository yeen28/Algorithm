import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        
        main.input();
	}
	
	public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        StringBuilder sb = new StringBuilder();
        int H, W, N, answer;
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++){
            stk = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(stk.nextToken());
            W = Integer.parseInt(stk.nextToken());
            N = Integer.parseInt(stk.nextToken());
            
            answer = proc(H, W, N);
            sb.append(answer).append('\n');
        }
        
        System.out.println(sb);
	} //input
    
    public int proc(int H, int W, int N) {
        if(N%H == 0) {
            return (N-H*(N/H-1))*100 + (N/H);
        }
        
        return (N-H*(N/H))*100 + ((N/H)+1);
    } //proc
}
