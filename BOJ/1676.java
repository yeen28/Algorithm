import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int N;
    
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println(main.proc());
    } //main
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
    } //input
    
    public int proc() {
        int cnt = 0;
        while(N >= 5) {
            cnt += N/5;
            N /= 5;
        }
        
        return cnt;
    } //proc
}
