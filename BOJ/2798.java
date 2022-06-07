import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        
        main.input();
    } //main
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk1 = new StringTokenizer(br.readLine(), " ");
        
        int N = Integer.parseInt(stk1.nextToken());
        int M = Integer.parseInt(stk1.nextToken());
        int[] inArr = new int[N];
        
        StringTokenizer stk2 = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            inArr[i] = Integer.parseInt(stk2.nextToken());
        } //end for
        
        proc(N, M, inArr);
    }
    
    private void proc(int N, int M, int[] inArr) {
        int max = -1, sum = 0;
        
        for(int i=0; i<inArr.length-2; i++) {
             for(int j=i+1; j<inArr.length-1; j++) {
                 for(int k=j+1; k<inArr.length; k++) {
                     sum = inArr[i] + inArr[j] + inArr[k];
                     
                     if(max < sum && sum <= M)
                         max = sum;
                 } //end for k
             } //end for j
         } //end for i
         
         System.out.println(max);
    } //proc
	
}
