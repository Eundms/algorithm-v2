import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //내리막길
    static int M, N;
    static int[][] box;
    static int[][] dp;
    static int[][] way = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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


    private static int dfs(int i, int j) {
        if (i == M - 1 && j == N - 1) {
            return 1; //M-1, N-1까지 오는 방법의 수 +1
        }
        if (dp[i][j] != -1) { //이미 방문한 적이 있음
            return dp[i][j];
        }
        dp[i][j] = 0; // 방문처리
        for (int w = 0; w < 4; w++) {
            int nx = i + way[w][0];
            int ny = j + way[w][1];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }
            if (box[i][j] > box[nx][ny]) { 
                dp[i][j] += dfs(nx, ny); //...!
            }
        }
        return dp[i][j];
    }
}
