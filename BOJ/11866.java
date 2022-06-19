import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuilder;

public class Main {
    
    private int K;
    private Queue<Integer> que;
    private StringBuilder answer;
    
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    } //main
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        
        que = new LinkedList<Integer>();
        for(int i=1; i<=N; i++) {
            que.add(i);
        }
    } //input
    
    public void proc() {
        answer = new StringBuilder();
        answer.append("<");
        
        int peek = 0;
        while(!que.isEmpty()) {
            for(int i=0; i<K-1; i++) {
                peek = que.peek();
                que.remove();
                que.add(peek);
            }
            
            answer.append(que.peek());
            que.remove();
            
            if(!que.isEmpty()) {
                answer.append(", ");
            } else {
                answer.append(">");
            }
        } //end while
        
        System.out.println(answer);
    }
}
