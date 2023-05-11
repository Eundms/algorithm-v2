import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main { //리그 오브 레전설 (Small)
    static int N, M; // N초 시간 동안 싸움진행, A 스킬 시전 시간(1초), B스킬 시전 시간(M초)
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // dp[N] = dp[N-M] + dp[N-1]: N초 시간동안 가능한 갯수
        // dfs ? 선택 가능 A 또는 B 인데, A
        dp = new long[N + 1]; // N초 고려했을 때 가능한 스킬 조합의 수
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i-1];
            if (i - M >= 0){
                dp[i] = (dp[i - M] + dp[i - 1])% 1_000_000_007;
            }
        }
        //System.out.println(Arrays.toString(dp));
        long result = dp[N];
        System.out.println(result % 1_000_000_007); // 가능한 조합 수를 1000000007로 나눈 나머지 값 출력
    }
}
