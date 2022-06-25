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
        int mul = 1;
        for(int i=N; i>0; i--) {
            mul *= i;
        }
        
        return mul;
    } //proc
}
