import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { //평범한 배낭
    static int N, K;
    static int[][] dp; // 가방무게 K까지 고려했을 때, 최대가치
    static int[][] items;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 물품의 수
        K = Integer.parseInt(st.nextToken()); // 가방 무게 K

        items = new int[N + 1][2];// 무게 W, 가치 V ; 1 ~ N까지 넣음
        for (int n = 1; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            items[n][0] = Integer.parseInt(st.nextToken());
            items[n][1] = Integer.parseInt(st.nextToken());
        }

        // dp[n][k] : 가방무게를 k만큼 고려했을 때, n번째 아이템을 선택/비선택했을 때 최대가치
        dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) { // 아이템 i번째 선택
            for (int k = 1; k <= K; k++) { //가방 무게가 1 ~ K 까지 고려
                dp[i][k] = dp[i - 1][k];
                if(k - items[i][0]>=0)
                    dp[i][k] = Math.max(dp[i - 1][k - items[i][0]] + items[i][1], dp[i - 1][k]);
                // Math.max(i번째 item을 선택할 경우 최대 가치, 선택하지 않을 경우 최대 가치)
                // i번쨰 item을 선택 : i-1번째 item, (k - i번째 item의 무게)가방 무게까지 고려했을 때 최대가치 + i번째 item의 무게

            }
        }
        System.out.println(dp[N][K]);
    }
}
