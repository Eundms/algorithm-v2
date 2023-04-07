import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution { // 두 개의 숫자열
    static int T;
    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int test = 1; test <= T; test++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            B = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int n = 0; n < N; n++) {
                A[n] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < M; m++) {
                B[m] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;

            int minV = Math.min(N, M);
            int maxV = Math.max(N, M);
            for (int k = 0; k < maxV - minV + 1; k++) {
                int sum = 0;
                for (int i = 0; i < minV; i++) {
                    if (M < N) {
                        sum += A[i + k] * B[i];
                    } else {
                        sum += A[i] * B[i + k];
                    }
                }
                ans = Math.max(sum,ans);
            }
            System.out.println("#" + test + " " + ans);

        }
    }
}
