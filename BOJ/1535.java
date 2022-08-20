import java.io.*;
import java.util.*;

public class Main {
    public int N;
    public int[] energies, happiness;
    
    public int proc(int idx, int energy) {
        if(N == idx) return 0;
        
        int sayHi = 0, noHi = 0;
        
        // 인사한 경우
        if((energy - energies[idx]) > 0) {
            sayHi = proc(idx+1, energy - energies[idx]) + happiness[idx];
        }
        
        // 인사를 안 한 경우
        noHi = proc(idx+1, energy);
        
        return Math.max(sayHi, noHi);
    }
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        N = Integer.parseInt(br.readLine());
        energies = new int[N];
        happiness = new int[N];
        
        // 체력
        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            energies[i] = Integer.parseInt(stk.nextToken());
        }
        
        // 기쁨
        stk = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            happiness[i] = Integer.parseInt(stk.nextToken());
        }
    }
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        System.out.println( main.proc(0, 100) );
    }
}
