import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] box;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        box = new int[N][M]; // 8방향 거리
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // N x M 크기의 공간에 아기 상어 여러 마리
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] != 1) { // 아기 상어
                    visited = new boolean[N][M];
                    bfs(i, j);
                }
            }
        }
        System.out.println(max);

    }

    static int[][] way = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        visited[i][j] = true;
        queue.add(new int[]{i, j, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int w = 0; w < 8; w++) {
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                    continue;
                }
                if (box[nx][ny] == 1) { // 아기 상어
                    max = Math.max(now[2]+1,max);
                    return;
                }
                visited[nx][ny] = true; // 방문 처리
                queue.add(new int[]{nx, ny, now[2] + 1});
            }
        }
    }
}
