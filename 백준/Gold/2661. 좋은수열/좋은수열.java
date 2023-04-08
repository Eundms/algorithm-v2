import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        // 인접한 두 개의 부분 수열 -> 나쁜 수열
        System.out.println(dfs(""));
    }

    private static String dfs(String str) {
        if (N == str.length()) {
            return str;
        }
        for (int i = 1; i <= 3; i++) { // N자리 정수 중, 작은 수를 나타내는 수열
            if (!str.isEmpty() && str.charAt(str.length() - 1) == (i + '0')) {
                continue;
            }
            if (isValid(str + i)) {
                String res = dfs(str + i);
                if (!res.equals("")) {
                    return res;
                }
            }
        }
        return "";
    }

    private static boolean isValid(String str) {
        for (int cnt = 2; cnt < str.length(); cnt++) { // 2개짜리 부분수열 ~
            for (int start = 0; start < str.length(); start += 1) { // 시작 위치 ~ 끝 위치
                //System.out.println(start + "~" + (start + cnt)+"\t"+(start+cnt) + "~" + (start + 2* cnt));
                if (start + 2 * cnt <= str.length()) {
                    String prev = str.substring(start, start + cnt);
                    //System.out.println(prev + " " + str.substring(start + cnt, start + 2 * cnt));
                    if (prev.equals(str.substring(start + cnt, start + 2 * cnt))) {
                        return false;
                    }
                }

            }
        }

        return true;
    }


}
