import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] board;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 집 N개
        board = new int[N+1][3];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 옆집이랑 색 같으면 안됨
        // n번쨰까지 칠했을 때 최소 비용
        // dp[n][R] // i번째를 해당색으로 칠했을 때 최소 비용
        // dp[n][G]
        // dp[n][B]
        dp = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + board[i][0]; // R
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + board[i][1];// G
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + board[i][2];// B
        }
        System.out.println(Math.min(dp[N][2],Math.min(dp[N][0],dp[N][1])));
    }
}
