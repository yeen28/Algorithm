import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private int A,B,C,M;

    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        A = Integer.parseInt(stk.nextToken());
        B = Integer.parseInt(stk.nextToken());
        C = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
    }

    public void proc() {
        int fatigue = 0; // 현재 피로도
        int work = 0; // 일한 총 양

        for (int hour = 0; hour < 24; hour++) {
            if (fatigue + A <= M) {
                fatigue += A;
                work += B;
            } else {
                fatigue = Math.max(0, fatigue - C); // 피로도가 음수가 되지 않도록
            }
        }

        System.out.println(work);
    }
}