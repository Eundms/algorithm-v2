import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k; // 문자의 개수를 나타내는 정수
    static char[] items;
    static boolean[] visited; // 0 - 9 중 선택한 숫자

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("src/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine()); // 부등호 문자의 개수를 나타내는 정수 k

        StringTokenizer st = new StringTokenizer(br.readLine());
        items = new char[k];
        for (int i = 0; i < k; i++) {
            items[i] = st.nextToken().charAt(0);
        }

        visited = new boolean[10]; // 0 ~ 9 선택 여부
        max = Long.MIN_VALUE;
        maxItem = "";
        min = Long.MAX_VALUE;
        minItem = "";
        find(0, "");
        System.out.println(maxItem);
        System.out.println(minItem);
    }

    static char[] arr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static long min, max;
    static String maxItem, minItem;

    static void find(int cnt, String numstr) {
        if (cnt == k + 1) {
            long cur = Long.parseLong(numstr);
            if (max < cur) {
                max = cur;
                maxItem = numstr;
            }
            if (min > cur) {
                min = cur;
                minItem = numstr;
            }
            return;
        }
        for (int num = 0; num <= 9; num++) {
            if(!visited[num] && isValid(numstr, arr[num], cnt)){
                visited[num] = true;
                find(cnt + 1, numstr + arr[num]);
                visited[num] = false;
            }

        }
    }

    private static boolean isValid(String str, char num, int cnt) {
        if (!str.equals("")) {
            char left = str.charAt(str.length() - 1);
            if (items[cnt - 1] == '<' && left - '0' < num-'0' || items[cnt - 1] == '>' && left - '0' > num-'0') {
                return true;
            }
            return false;
        }
        return true;
    }
}
