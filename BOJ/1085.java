import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        
        main.input();
    }
    
    private void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());
        
        proc(x, y, w, h);
    } //input
    
    private void proc(int x, int y, int w, int h){
        int minStart = Math.min(x, y);
        int minEnd = Math.min(w-x, h-y);
        int answer = Math.min(minStart, minEnd);
        
        System.out.println(answer);
    } //proc
}
