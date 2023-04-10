import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] box; // L : 육지, W : 바다
    static int maxTime = Integer.MIN_VALUE;
    static int[][] way = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new char[N][M];
        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                box[n][m] = str.charAt(m);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 'L') {
                    maxTime = Math.max(maxTime, bfs(i, j));
                }
            }
        }


        System.out.println(maxTime);

    }

    private static int bfs(int x, int y) {
        int minLen = 0;
        visited = new boolean[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            minLen = now[2];
            if(visited[now[0]][now[1]])continue;
            visited[now[0]][now[1]] = true;
            for (int w = 0; w < 4; w++) {
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) continue;
                if(box[nx][ny]=='L') {
                    queue.add(new int[]{nx, ny, now[2] + 1});
                }
            }
        }
        return minLen;
    }


}
