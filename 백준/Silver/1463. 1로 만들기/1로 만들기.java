import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        dp = new int[X + 1]; // 1 ... X
        for (int i = 2; i < X + 1; i++) {
            dp[i] = dp[i - 1] + 1; // 1을 뺌
            if (i % 2 == 0) { // 2로 나누어떨어지면, 2로 나누기
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
            if (i % 3 == 0) { // 3로 나누어떨어지면, 3으로 나누기
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
        }
        System.out.println(dp[X]);
    }
}
