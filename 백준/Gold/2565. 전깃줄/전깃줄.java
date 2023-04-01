import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {//전깃줄
    static int[] maxLen;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][2];

        StringTokenizer st;
        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            arr[n][0] = Integer.parseInt(st.nextToken());
            arr[n][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));

        maxLen = new int[N];
        for (int k = 0; k < N; k++) {
            maxLen[k] = 1;
            for (int i = 0; i < k; i++) {
                if (arr[i][1] < arr[k][1]) {
                    maxLen[k] = Math.max(maxLen[k], maxLen[i] + 1);
                }
            }
        }

        int size = 0;
        for (int n = 0; n < N; n++) {
            size = Math.max(size,maxLen[n]);
        }
        System.out.println(N - size);

    }
}
