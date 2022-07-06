import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private int N; //이동하려고 하는 채널
    private boolean[] broken = new boolean[10];
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine()); //고장난 버튼의 개수
        
        if(M == 0) return;
        
        String[] tmp = br.readLine().split(" ");
        for(String val : tmp) {
            broken[Integer.parseInt(val)] = true; //고장난 버튼일 때, true
        }
    }
    
    /*
    0 : num에 고장난 버튼이 포함되어있음.
    그 외 : N에 가장 가까운 번호를 누를 수 있는 개수
    */
    public int pressNum(int num) {
        int cnt = 0;
        if(num == 0) {
            // 0번을 누르는 경우
            
            if(broken[num]) { 
                //고장난 버튼인 경우
                return 0;
            }
            
            return 1;
        } //end if
        
        while(num > 0) {
            if(broken[num % 10]) {
                //고장난 버튼인 경우
                return 0;
            } //end if
            
            cnt++;
            num /= 10;
        } //end while
        
        return cnt;
    }
    
    public void proc() {
        if(N == 100) {
            System.out.println(0);
            return;
        } //end if

        int answer = Math.abs(N - 100); //모든 번호가 고장난 경우. 시작하는 채널 : 100
        
        int cnt = 0, possible = 0;
        for(int i=0; i<999999; i++) { 
            //N (0 ≤ N ≤ 500,000)이므로 6자리를 누를 수 있는 최대(999,999)까지 반복
            
            possible = 0;
            if((possible = pressNum(i)) != 0) {
                cnt = possible + Math.abs(N-i); 
                //Math.abs(N-i) : +, -를 누르는 개수
                
                if(answer > cnt) {
                    answer = cnt;
                } //end if
                
            } //end if
        }
        
        System.out.println(answer);
    }
    
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    }
}
