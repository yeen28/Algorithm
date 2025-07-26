import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private int x, y; // 뛰는 거리
    private int startA, startB; // 출발점

    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        startA = Integer.parseInt(input[2]);
        startB = Integer.parseInt(input[3]);
    }

    public void proc() {
        int aPos = startA;

        for (int i = 0; i < 1000000; i++) {
            if (aPos >= startB && (aPos - startB) % y == 0) {
                System.out.println(aPos);
                return;
            }

            aPos += x;
        }

        System.out.println(-1);
    }
}