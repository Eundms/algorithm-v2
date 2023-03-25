import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int w, h;
    static int[][] box;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 지도의 너비
            h = Integer.parseInt(st.nextToken()); // 지도의 높이
            if (w == 0 && h == 0) {
                break;
            }
            box = new int[h][w]; // 너비, 높이
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    box[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) { // 너비
                for (int j = 0; j < w; j++) { // 높이
                    if (box[i][j] == 1 && visited[i][j] == false) {//땅
                        bfs(i, j);
                        cnt += 1;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static int[][] way = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}, {1, -1}, {-1, 1}, {-1, -1}, {1, 1}};

    private static void bfs(int i, int j) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int wi = 0; wi < 8; wi++) {
                int nx = now[0] + way[wi][0];
                int ny = now[1] + way[wi][1];
                if (nx < 0 || nx >= h || ny < 0 || ny >= w || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                if (box[nx][ny] == 0) { // 바다인 경우
                    continue;
                }
                queue.add(new int[]{nx, ny});
            }
        }

    }
}
