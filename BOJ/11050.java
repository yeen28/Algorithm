import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main{
    
    private int n, k;

     public static void main(String []args) throws IOException {
         Main main = new Main();
         main.input();
         System.out.println(main.proc());
     }
     
     public void input() throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String[] input = br.readLine().split(" ");
         
         n = Integer.parseInt(input[0]);
         k = Integer.parseInt(input[1]);
     }
     
     public int proc() {
         int answer=0;
         answer = factorial(n) / (factorial(k) * factorial(n-k));
         
         return answer;
     }
     
     public int factorial(int n) {
         if(n < 2) {
             return 1;
         }
         
         return n*factorial(n-1);
     }
}
