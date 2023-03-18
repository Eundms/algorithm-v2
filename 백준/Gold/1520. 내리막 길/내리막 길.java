
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 내리막길 + DFS + DP 근데 DP 어떻게 함-------------
    static int M, N;
    static int[][] box;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[M][N];
        dp = new int[M][N];
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                box[m][n] = Integer.parseInt(st.nextToken());
                dp[m][n] = -1;
            }
        }

        System.out.println(dfs(0, 0));

    }

    static int[][] way = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private static int dfs(int i, int j) {
        if (i == M - 1 && j == N - 1) { // 끝까지 도달
            return 1;
        }
        if (dp[i][j] != -1) { //이미 방문한 적이 있음
            return dp[i][j];
        }
        dp[i][j] = 0; // 방문 처리
        for (int w = 0; w < 4; w++) {
            int nx = i + way[w][0];
            int ny = j + way[w][1];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }
            if (box[i][j] > box[nx][ny]) {
                dp[i][j] += dfs(nx, ny);
            }
        }
        return dp[i][j];
    }

}
