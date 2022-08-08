import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int N, cnt = 0;
    
    public void proc() {
        if(N <= 99) {
            System.out.println(N);
            return;
        }
        cnt += 99;
        
        int hundreds = 0, tens = 0, units = 0;
        for(int i = 100; i <= N; i++) {
            hundreds = i/100; // 백의 자리
            tens = (i/10)%10; // 십의 자리
            units = i%10; // 일의 자리
            if((hundreds - tens) == (tens - units)) cnt++;
        }
        
        System.out.println(cnt);
    } // proc
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        br.close();
    } // input
    
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    } // main
} // class
