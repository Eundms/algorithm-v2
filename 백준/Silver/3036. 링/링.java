import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 링의 개수

        // 링의 반지름이 상근이가 바닥에 놓은 순서대로 주어짐
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N - 1; i++) {
            int B = Integer.parseInt(st.nextToken()); // 링의 반지름
            int gcdAB = gcd(A, B);
            System.out.println((A/gcdAB)+"/"+(B/gcdAB));
        }

    }

    private static int gcd(int A, int B) {
        if (B == 0) {
            return A;
        }
        return gcd(B, A % B);
    }
}
