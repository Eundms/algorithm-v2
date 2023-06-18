import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] alpha;
    static int count;

    public static void main(String[] args) throws IOException { // 행운의 문자열

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        alpha = new int[26];
        N = str.length();
        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 'a'] += 1;
        }
        back(0, "");
        System.out.println(count);
    }

    private static void back(int cnt, String str) {
        if (cnt == N) {
            count += 1;
            return;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] == 0) {
                continue;
            }
            if (isValid(str, i)) {
                alpha[i] -= 1;
                back(cnt + 1, str + (char)('a' + i));
                alpha[i] += 1;
            }
        }
    }

    private static boolean isValid(String str, int next) {
        if (str.equals("")) {
            return true;
        }
        if (str.charAt(str.length() - 1) == (char) (next + 'a')) {
            return false;
        }
        return true;
    }

}
