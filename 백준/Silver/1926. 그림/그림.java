import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] box;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 세로크기
        m = Integer.parseInt(st.nextToken()); // 가로크기
        box = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int diff = 0;
        int res = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && box[i][j] == 1) {
                    diff += 1;
                    res = Math.max(res, bfs(i, j));
                }

            }
        }
        System.out.println(diff + "\n" + res);

    }

    static int[][] way = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static int bfs(int i, int j) {
        int cnt = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (visited[now[0]][now[1]]) {
                continue;
            }
            visited[now[0]][now[1]] = true;
            if (box[now[0]][now[1]] == 1) {
                cnt += 1;
            }
            for (int w = 0; w < 4; w++) {
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m || box[nx][ny] == 0) {
                    continue;
                }
                queue.add(new int[]{nx, ny});
            }
        }
        return cnt;
    }
}
