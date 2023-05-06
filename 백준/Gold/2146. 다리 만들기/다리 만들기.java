import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[][] box;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int SEA = 0, ISLAND = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 크기 N x N 격자

        // 여러 섬, 동서남북 육지가 붙어있는 덩어리
        StringTokenizer st;
        box = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // dfs로 섬을 번호로 구분하기
        visited = new boolean[N][N];
        int cntIsland = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (box[i][j] >= ISLAND && !visited[i][j]) {
                    dfs(i, j, ++cntIsland); // 2 ~ 섬개수+1
                }
            }
        }
        // printMatrix(box);
        int minLenOfBridge = Integer.MAX_VALUE;

        for (int cnt = 2; cnt <= cntIsland; cnt++) {
            // 1번섬의 모든 경계 -> 다른 섬이 나올 때까지 bfs 진행 & 제일 처음 만나는 길이
            // 섬의 경계 == 자신은 번호인데 옆이 0
            // 위 과정을 N번만큼 반복
            queue = new ArrayDeque<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    //System.out.println("[ " + i + "," + j+" ]");
                    if (box[i][j] == cnt) {
                        for (int w = 0; w < 4; w++) {
                            int nx = i + way[w][0];
                            int ny = j + way[w][1];
                            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                                continue;
                            }
                            if (box[nx][ny] == SEA) { // 1번 섬의 경계
                                queue.add(new int[]{nx, ny, 0});
                            }
                        }
                    }
                }
            }
            int res = bfs(cnt);
            //System.out.println(">>>\t" + res);
            minLenOfBridge = Math.min(minLenOfBridge, res); // 다리가 격자에서 차지하는 칸의 수가 가장 작은 다리
        }
        System.out.println(minLenOfBridge);
    }

    private static int bfs(int islandNumber) {
        visited = new boolean[N][N];
        int lenOfBridge = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            //System.out.println(">> " + now[0] + ", " + now[1]);
            if (visited[now[0]][now[1]]) {
                continue;
            }
            visited[now[0]][now[1]] = true;
            lenOfBridge = now[2];
            for (int w = 0; w < 4; w++) {
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                    continue;
                }
                if (box[nx][ny] == SEA) { // 바다
                    queue.add(new int[]{nx, ny, now[2] + 1});
                }
                if (box[nx][ny] != SEA && box[nx][ny] != islandNumber) {
                    return now[2] + 1;
                }
            }
        }
        return lenOfBridge;
    }

    private static void printMatrix(int[][] box) {
        for (int n = 0; n < box.length; n++) {
            for (int m = 0; m < box[0].length; m++) {
                System.out.print(box[n][m] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] way = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static void dfs(int i, int j, int islandNumber) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        box[i][j] = islandNumber;

        for (int w = 0; w < 4; w++) {
            int nx = i + way[w][0];
            int ny = j + way[w][1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                continue;
            }
            if (box[nx][ny] == 1) {
                dfs(nx, ny, islandNumber);
            }
        }
    }

}
