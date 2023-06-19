import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int T;
    static long[] p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // P[n] = P[n-2] + P[n-3]
        T = Integer.parseInt(br.readLine());
        p = new long[101];
        p[0] = p[1] = p[2] = p[3]= 1;
        for (int i = 4; i <= 100; i++) {
            p[i] = p[i - 2] + p[i - 3];
        }
        for (int test = 0; test < T; test++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(p[N]);
        }

    }


}
