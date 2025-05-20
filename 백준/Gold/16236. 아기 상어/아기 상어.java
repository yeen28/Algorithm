import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int[][] map;
    private int targetX, targetY;
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, -1, 0, 1};
    private boolean[] visited;

    class Item {
        int x, y, visitLoc, move;

        Item(int x, int y, int move) {
            this.x = x; // 열
            this.y = y; // 행
            this.visitLoc = this.y * N + this.x; // visited를 위한 위치(1차원으로 나열했을 때 위치)
            this.move = move; // 이동거리
        }
    }
    
    public static void main(String args[]) throws IOException {
        Main main = new Main();
        main.input();
        main.proc();
    }
    
    public void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());

            for (int j = 0; j < N && stk.hasMoreTokens(); j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());

                if (map[i][j] == 9) { // 아기 상어 위치
                    targetX = j;
                    targetY = i;
                }
            }
        }
    }

    public void proc() {
        int answer = 0; // 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지
        int targetSize = 2;
        int sharkSizeCnt = 0;

        List<Item> fishes;
        while (true) {
            // 상어가 먹은 물고기 위치
            fishes = new ArrayList<>();
            bfs(fishes, targetSize);
            if (fishes.isEmpty()) { // 먹을 물고기가 없는 경우 중단
                break;
            }

            // queue에 남은 것들은 먹을 수 있는 거리에 있는 영역들 (크키가 동일하거나 작은 물고기 존재)
            sortFishes(fishes);
            moveShark(fishes);
            answer += fishes.get(0).move;

            // 상어 크기 update
            if (targetSize == ++sharkSizeCnt) {
                targetSize++;
                sharkSizeCnt = 0;
            }
        }

        System.out.println(answer);
    }

    /**
     * BFS 탐색
     * @param fishes
     * @param targetSize
     */
    private void bfs(List<Item> fishes, int targetSize) {
        // 상어가 지나갈 수 있는 위치
        Queue<Item> q = new LinkedList<>();
        visited = new boolean[20 * 20];

        q.add(new Item(targetX, targetY, 0));
        visited[q.peek().visitLoc] = true;

        while (!q.isEmpty()) {
            Item item = q.poll();
            int x = item.x;
            int y = item.y;
            if (!fishes.isEmpty() && fishes.get(0).move == item.move) { // 거리가 가장 가까운 물고기 발견
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int next = ny * N + nx;

                if (isOOB(nx, ny) || visited[next]) {
                    continue;
                }

                visited[next] = true;
                if (targetSize >= map[ny][nx]) { // 상어가 지나갈 수 있는 경우
                    q.add(new Item(nx, ny, item.move + 1));

                    // 상어가 먹을 수 있는 물고기 발견 -> 현재 이동거리까지만 BFS 탐색하고 중단
                    if (map[ny][nx] > 0 && map[ny][nx] < targetSize) {
                        fishes.add(new Item(nx, ny, item.move + 1));
                    }
                }
            }
        }
    }

    /**
     * 상어 위치 이동 후 다시 시작
     * @param fishes 먹을 수 있는 물고기들
     */
    private void moveShark(List<Item> fishes) {
        Item fish = fishes.get(0);

        // 상어 위치 이동
        map[targetY][targetX] = 0;
        targetX = fish.x;
        targetY = fish.y;
        map[targetY][targetX] = 9;
    }

    /**
     * 거리가 가까운 물고기가 여러 마리라면,
     * 1) 가장 위, 2) 가장 왼쪽에 있는 물고기를 먹습니다.
     * @param fishes
     */
    private void sortFishes(List<Item> fishes) {
        if (fishes.size() > 1) {
            Collections.sort(fishes, new Comparator<Item>() {
                public int compare(Item i1, Item i2) {
                    if (i1.y < i2.y) {
                        return -1;
                    } else if (i1.y == i2.y) {
                        if (i1.x < i2.x) {
                            return -1;
                        } else if (i1.x == i2.x) {
                            return 0;
                        }

                        return 1;
                    } else {
                        return 1;
                    }
                }
            });
        }
    }

    private boolean isOOB(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= N;
    }
}
