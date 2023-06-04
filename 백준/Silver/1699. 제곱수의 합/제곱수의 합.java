import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] dp;

    // 1의 제곱, 2의 제곱,... N의 제곱 ; 32 = 16 + 16;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 어떤 자연수 N
        dp = new int[N + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            if (i == (int) Math.pow((int) Math.sqrt(i), 2)) {
                dp[i] = 1;
            }
        }
        for (int i = 1; i <= N; i++) {
            if (i != (int) Math.pow((int) Math.sqrt(i), 2)) {
                for (int j = 1; j * j <= i; j++) {
                    dp[i] = Math.min(dp[i - j * j ] + 1, dp[i]);
                }
            }
        }

        System.out.println(dp[N]);
    }
}
