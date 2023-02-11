import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] box;
    static boolean[][] visited;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][M];

        //dfs depth=4
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 0, 0);

                visited[i][j] = false;
                other(i,j);
            }
        }
        System.out.println(max);
    }

    private static void other(int i, int j) {
        // (0,0), (1,0), (2,0), (1,1) ㅏ
        if (i >= 0 && i + 2 < N && j >= 0 && j + 1 < M) {
            max = Math.max(max, box[i][j] + box[i + 1][j] + box[i + 2][j] + box[i + 1][j + 1]);
        }

        // (0,0), (0,1), (0,2), (1,1) ㅜ
        // box[i][j] + box[i][j+1] + box[i][j+2] + box[i+1][j+1]
        if (i >= 0 && i + 1 < N && j >= 0 && j + 2 < M) {
            max = Math.max(max, box[i][j] + box[i][j + 1] + box[i][j + 2] + box[i + 1][j + 1]);
        }
        // (0,0) (0,1) (-1,1) (1,1) ㅓ
        // box[i][j] + box[i][j+1] + box[i-1][j+1] + box[i+1][j+1]
        if (i - 1 >= 0 && i + 1 < N && j >= 0 && j + 1 < M) {
            max = Math.max(max, box[i][j] + box[i][j + 1] + box[i - 1][j + 1] + box[i + 1][j + 1]);
        }
        // (0,0) (0,1) (0,2) (-1,1) ㅗ
        // box[i][j] + box[i][j+1] + box[i][j+2] + box[i-1][j+1]
        if (i - 1 >= 0 && i < N && j >= 0 && j + 2 < M) {
            max = Math.max(max, box[i][j] + box[i][j + 1] + box[i][j + 2] + box[i - 1][j + 1]);
        }

    }

    private static void dfs(int i, int j, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }
        int[][] way = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int w = 0; w < 4; w++) {
            int nx = i + way[w][0];
            int ny = j + way[w][1];
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                continue;
            }
            if (!visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, depth + 1, sum + box[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
}
