import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 주어진 수의 순서 고정
    static int N; // 수의 개수
    static int[] A;
    static int[] operator;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        operator = new int[4];
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        // 덧셈(+), 뺄셈(-), 곱셈(x), 나눗셈(%)
        back(A[0], operator, 1);
        System.out.println(max);
        System.out.println(min);
    }

    static void back(int res, int[] operator, int cnt) {
        if (cnt == N) {
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (isValid(i, operator)) {
                if (i == 0) { // +
                    operator[0] -= 1;
                    back(res + A[cnt], operator, cnt + 1);
                    operator[0] += 1;

                } else if (i == 1) { // -
                    operator[1] -= 1;
                    back(res - A[cnt], operator, cnt + 1);
                    operator[1] += 1;

                } else if (i == 2) { // x
                    operator[2] -= 1;
                    back(res * A[cnt], operator, cnt + 1);
                    operator[2] += 1;

                } else {// /
                    operator[3] -= 1;
                    back(res / A[cnt], operator, cnt + 1);
                    operator[3] += 1;

                }
            }
        }
    }

    static boolean isValid(int i, int[] operator) {
        if (operator[i] > 0) {
            return true;
        }
        return false;
    }
}
