import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    // 구간을 나눴을 때, 각 구간의 점수 차이가 maxScore 이하로 가능한지 확인하는 함수
    public static boolean canDivide(int[] arr, int N, int M, int maxScore) {
        int count = 1; // 구간 개수, 최소 1개의 구간은 존재해야 함
        int minVal = arr[0];
        int maxVal = arr[0];

        // 배열을 순차적으로 돌면서 구간을 나누는 로직
        for (int i = 1; i < N; i++) {
            int currentMin = Math.min(minVal, arr[i]);
            int currentMax = Math.max(maxVal, arr[i]);

            // 구간의 점수 차이가 maxScore를 넘는다면 새로운 구간을 만들어야 함
            if (currentMax - currentMin > maxScore) {
                count++;
                minVal = arr[i];
                maxVal = arr[i];
            } else {
                minVal = currentMin;
                maxVal = currentMax;
            }
        }
        // 구간 개수가 M개 이하이면 가능한 경우
        return count <= M;
    }
    
    // 이진 탐색을 통해 최솟값을 찾는 함수
    public static int findMinScore(int[] arr, int N, int M) {
        int left = 0;
        int right = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();  // 점수 차이의 최솟값 ~ 최댓값 구간 설정
        int answer = right;
        
        while (left <= right) {
            int mid = (left + right) / 2;

            // mid 값으로 구간을 나눌 수 있다면, 더 작은 값으로 탐색
            if (canDivide(arr, N, M, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());  // 배열 크기 N
        int M = Integer.parseInt(stk.nextToken());  // 구간 개수 M
        int[] arr = new int[N];
        
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        System.out.println(findMinScore(arr, N, M));
    }
}
