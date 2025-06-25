import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private int[] arrMemo;
    private Deque<Balloon> balloons = new ArrayDeque<>();

    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = (Integer.parseInt(br.readLine()));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N && stk.hasMoreTokens(); i++) {
            balloons.add(new Balloon(i, Integer.parseInt(stk.nextToken())));
        }
    }

    class Balloon {
        int idx, memo;

        protected Balloon(int idx, int memo) {
            this.idx = idx;
            this.memo = memo;
        }
    }

    public void proc() {
        StringBuilder sb = new StringBuilder();

        while (!balloons.isEmpty()) {
            Balloon balloon = balloons.poll();

            sb.append(balloon.idx + " ");
            if (balloons.isEmpty()) {
                break;
            }

            if (balloon.memo > 0) {
                for (int i = 0; i < balloon.memo - 1; i++) {
                    balloons.add(balloons.poll());
                }
            } else {
                for (int i = 0; i < Math.abs(balloon.memo); i++) {
                    balloons.addFirst(balloons.pollLast());
                }
            }
        }

        System.out.println(sb);
    }
}