import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 팰린드롬
    static int N, M; // 자연수 N개, 질문 총 M번
    static int[] num;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) { // 2000
            num[n] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N][N]; // dp[s][e] : 펠린드롬 유무 , 오른쪽 위만 채워서 사용
        for (int s = 0; s < N; s++) { // 부분 숫자 길이 1 고려
            dp[s][s] = 1;
        }
        for (int s = 0; s < N - 1; s++) { // 부분 숫자 길이 2 고려
            if (num[s] == num[s + 1]) {
                dp[s][s + 1] = 1;
            }
        }
        // num[s] == num[e] && dp[s+1][e-1]==1
        for (int s = N-1; s >= 0; s--) {
            for (int e = s; e < N; e++) {
                if (num[s] == num[e] && s + 1 < N && e - 1 >= 0 &&
                        dp[s + 1][e - 1] == 1) {
                    dp[s][e] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine()); // 질문 개수 (1000000)
        for (int m = 0; m < M; m++) { // 질문의 개수
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()) - 1;
            int E = Integer.parseInt(st.nextToken()) - 1;
            sb.append(dp[S][E]).append("\n");
        }
        System.out.println(sb);

    }


}
