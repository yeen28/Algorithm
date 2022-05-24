import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T, R;
        String S;
        T = Integer.parseInt(br.readLine());
        for (int testcase = 0; testcase < T; testcase++) {
            String[] str = br.readLine().split(" ");
            R = Integer.parseInt(str[0]);
            S = str[1];
            proc(R, S);
            System.out.println();
        }
    }
    
    private void proc(int R, String S) {
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < R; j++)
                System.out.print(S.charAt(i));
        }
    }
    
    public static void main(String args[]) throws Exception {
        Main main = new Main();
        
        main.input();
    }
}
