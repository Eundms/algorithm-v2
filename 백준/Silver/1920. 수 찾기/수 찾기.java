import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int n = 0; n < N; n++) {
            A[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
            int item = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(item));
        }
    }

    private static int binarySearch(int value) {
        int i = 0, j = N - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            if (A[mid] == value) {
                return 1;
            } else if (A[mid] < value) {//찾고자하는 값이 mid보다 오른쪽에 있음
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return 0;
    }
}
