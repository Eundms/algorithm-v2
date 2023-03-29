import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //다리 놓기
    static int T;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("src/_0329/ws/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int t = 0; t < T; t++) { // 테스트 케이스 개수
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            System.out.println(binomialCoef(M, N));
        }
    }


    private static int binomialCoef(int n, int r) {
        dp = new int[n + 1][r + 1];
        // dp[n][r] = dp[n-1][r-1] + dp[n-1][r] // n == r or r = 0 : 1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) { // ※
                if (i == j || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[n][r];
    }
}
