import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            int[][] score = new int[n + 1][2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                score[i][0] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                score[i][1] = Integer.parseInt(st.nextToken());
            }
            // dp[i][0] : i까지 고려했을 때 위쪽 칸에 있을 때 점수의 최댓값
            // = Math.max(dp[i - 1][1] + score[i][0], dp[i - 1][0])
            // dp[i][1] : i까지 고려했을 때 아래쪽 칸에 있을 때 점수의 최댓값
            // = Math.max(dp[i - 1][0] + score[i][1], dp[i - 1][1])

            int[][] dp = new int[n + 1][2];
            for (int i = 1; i <= n; i++) {
                dp[i][0] = Math.max(dp[i - 1][1] + score[i][0], dp[i - 1][0]); // 혹은 아에 안뗄 수도 있음
                dp[i][1] = Math.max(dp[i - 1][0] + score[i][1], dp[i - 1][1]);
            }

            System.out.println(Math.max(dp[n][0], dp[n][1]));

        }
    }


}
