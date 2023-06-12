import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[10]; // 0 ~ 9
        String number = br.readLine();
        for (int i = 0; i < number.length(); i++) {
            count[number.charAt(i) - '0'] += 1;
        }
        int maxCnt = (count[6] + count[9]) / 2 + (count[6] + count[9]) % 2;
        for (int i = 0; i < 10; i++) {
            if (i != 6 && i != 9) {
                if (count[i] > 0) {
                    maxCnt = Math.max(maxCnt,count[i]);
                }
            }
        }
        System.out.println(maxCnt);
    }
}
