import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private String[][] inputArrays = new String[5][15];

    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    }

    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String[] split = br.readLine().split("");
            // 길이가 15보다 작으면 자동으로 null이 채워지므로, 미리 빈 문자열 배열을 준비
            inputArrays[i] = Arrays.copyOf(split, 15);
            for (int j = 0; j < 15; j++) {
                inputArrays[i][j] = inputArrays[i][j] == null ? "" : inputArrays[i][j];
            }

            // copyOf는 항상 새 배열을 생성하므로 할당 비용이 듭니다. 또한, copyOf()는 길이가 짧으면 null로 채우므로 후처리(null → "") 작업이 추가로 필요합니다.
            // 그러므로, 고성능이 요구되는 시스템이면 아래와 같은 직접 처리(charAt)를 사용하는게 좋습니다.
        /*
            String line = br.readLine();
            // 빈 문자열로 초기화
            Arrays.fill(inputArrays[i], "");

            // 줄의 길이만큼만 채움
            for (int j = 0, len = Math.min(15, line.length()); j < len; j++) {
                inputArrays[i][j] = String.valueOf(line.charAt(j));
            }
        */
        }
    }

    public void proc() {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                result.append(inputArrays[j][i]);
            }
        }

        System.out.println(result.toString());
    }
}