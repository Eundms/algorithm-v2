import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] money;
    static int[] dp ; // N원 만드는데 사용되는 경우의 수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 거스름돈 n
        K = Integer.parseInt(st.nextToken()); // 가치의 합이 K원?

        money = new int[N+1]; // 거스름돈 종류

        dp = new int[K+1];

        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = money[i]; j <= K; j++) {
                dp[j] += dp[j - money[i]];
            }
        }
        System.out.println(dp[K]);
    }
}