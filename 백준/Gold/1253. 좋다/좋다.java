import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] A;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 수의 개수
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            A[n] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        for (int w = 0; w < N; w++) {
            // 원하는 값 : want
            // 다른 수 두 개의 합으로 나타낼 수 있다 -> GOOD(좋다)
            if (isGood(A[w], w)) {
                cnt += 1;
            }
        }
        System.out.println(cnt); // 좋은 수의 개수
    }
    // 음수가 있다면?

    // 모두 양수일 때 해당됨
    private static boolean isGood(int want, int wIdx) { // wIdx수는 제외해야 함
        // 좋은 수인지 판단하기 위해
        int i = 0, j = A.length - 1;
        while (i < j) {
            int item = A[i] + A[j]; // 아이템
            if (item == want) { 
                if (i == wIdx) { // !!!
                    i++;
                } else if (j == wIdx) {// !!!
                    j--;
                } else {
                    return true;
                }
            }

            if (item > want) { // 원하는 값보다 크다면 뒷수 -1
                j -= 1;
            } else if (item < want) {// 원하는 값보다 작다면 앞수 +1
                i += 1;
            }

        }

        return false;
    }
}
