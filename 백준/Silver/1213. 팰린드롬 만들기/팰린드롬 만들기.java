import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    static char[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        arr = new char[str.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = str.charAt(i);
        }

        Arrays.sort(arr);
        int[] cnt = new int[26];
        // System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            cnt[arr[i] - 'A'] += 1;
        }

        int oddCnt = 0;
        String mid = "";
        for (int i = 0; i < 26; i++) {
            if (cnt[i] % 2 != 0) {
                oddCnt += 1;
                mid += (char) ('A' + i);
            }
        }
        if (oddCnt >= 2) {
            bw.write("I'm Sorry Hansoo\n");
            bw.flush();
            bw.close();
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            int a = cnt[i] / 2;
            while (a > 0) {
                sb.append((char) ('A' + i));
                a -= 1;
            }
        }
        if (oddCnt == 1) {
            bw.write(sb.toString() + mid + sb.reverse().toString() + "\n");
        } else {
            bw.write(sb.toString() + sb.reverse().toString() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
