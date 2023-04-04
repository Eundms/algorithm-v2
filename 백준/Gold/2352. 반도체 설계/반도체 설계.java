import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 반도체 설계
    static int N;
    static int[] port; // 왼쪽 포트, 오른쪽 포트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        port = new int[N];
        for (int i = 0; i < N; i++) { // 
            port[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 최장 증가 수열
        int[] dp = new int[N]; // 최장 증가 부분수열의 길이 (i번째 수로 끝나는)
        for (int i = 0; i < N; i++) {
            int max = 1;
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (port[i] > port[j]) {
                    max = Math.max(dp[j] + 1, max);
                }
            }
            dp[i] = max;
        }

        int res = 0;
        for (int i = 0; i < N; i++) {
            res = Math.max(res, dp[i]);
        }
        System.out.println(res);
    }
}
