import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    
    private boolean[] arrPrime;

	public static void main(String args[]) throws IOException {
		Main main = new Main();
		main.input();
	} //main

	public void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

		int M = Integer.parseInt(stk.nextToken());
		int N = Integer.parseInt(stk.nextToken());

		proc(M, N);
	} //input

    private void proc(int M, int N) {
        arrPrime = new boolean[N+1];
        get_prime();
        
        StringBuilder sb = new StringBuilder();
        for(int i = M; i < N+1; i++){
            if(!arrPrime[i]) 
                sb.append(i).append('\n');
        } //end for
        
        System.out.println(sb);
    } //proc
    
    private void get_prime() {
        arrPrime[0] = arrPrime[1] = true; // 소수 아님.
        
        for(int i = 2; i < Math.sqrt(arrPrime.length)+1; i++) {
            if(arrPrime[i]) continue;
            
            for(int j = i*i; j < arrPrime.length; j += i){
                arrPrime[j] = true;
            }
        }
    } //get_prime
}
