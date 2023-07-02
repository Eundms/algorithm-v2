import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 행의 수
        M = Integer.parseInt(st.nextToken()); // 열의 수
        K = Integer.parseInt(st.nextToken()); // O로 표시된 칸의 번호
        // K = (i - 1) * M + j
        // i  :  (K-j) / M + 1
        // j  :  K - (i-1) * M
        int x = 0, y = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if ((i - 1) * M + j == K) {
                    x = i;
                    y = j;
                }
            }
        }

        dp = new int[N + 1][M + 1]; // N,M // dp[i][j] = dp[i][j-1] + dp[i-1][j]
        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if ((i > x && j < y) || (i < x && j > y)) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][M]);
    }
}
