import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(divideConquer(B));
    }

    private static long divideConquer(int cnt) {
        if (cnt == 0) {
            return 1;
        }
        if (cnt % 2 == 1) {
            return A * divideConquer(cnt - 1) % C;
        }
        long n = divideConquer(cnt / 2) % C;
        return n * n % C;
    }

}
