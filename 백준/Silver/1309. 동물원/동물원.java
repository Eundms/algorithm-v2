import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N; // 우리의 크기
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][3]; // i번째 줄: 왼쪽, 오른쪽, 배치x
        // i번째줄까지
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        for (int i = 2; i <= N; i++) {
            // n번째 자리에 사자가 없는 경우, 사자가 왼쪽에 있는 경우, 사자가 오른쪽에 있는 경우
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }
        System.out.println((dp[N][0] + dp[N][1] + dp[N][2])%9901);
    }


}
