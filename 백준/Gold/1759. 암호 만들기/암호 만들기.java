import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] alphabet;
    static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken()); // C개의 문자들이 공백으로 주어짐

        numbers = new int[L];
        alphabet = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            alphabet[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alphabet);
        //C개중, L개 = 한개의 모음 + 두개의 자음 뽑기
        comb(0, 0);
    }

    private static void comb(int cnt, int start) {
        if (cnt == L) {
            int moCnt = 0, jaCnt = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < L; i++) {
                char now = alphabet[numbers[i]];
                sb.append(now);
                if (now == 'a' || now == 'e' || now == 'i' || now == 'o' || now == 'u') {
                    moCnt += 1;
                } else {
                    jaCnt += 1;
                }
            }
            if (moCnt >= 1 && jaCnt >= 2) {
                System.out.println(sb);
            }
            return;
        }
        for (int i = start; i < C; i++) {
            numbers[cnt] = i;
            comb(cnt + 1, i + 1);
        }
    }

}
