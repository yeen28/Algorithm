import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Collections;

public class Main {
    
    public static void main(String args[]) throws IOException {
        Main m = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        int T = Integer.parseInt(br.readLine());
        
        for(int i=0; i<T; i++) {
            int input = Integer.parseInt(br.readLine());
            
            if(input == 0) {
                if(q.isEmpty()){
                    sb.append(0).append("\n");
                    continue;
                }
                
                sb.append(q.poll()).append("\n");
            } else {
                q.add(input);
            }
        }
        
        System.out.println(sb);
    }
}
