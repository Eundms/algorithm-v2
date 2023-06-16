import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N번째 영화
        int cnt = 0;
        int num = 1;
        while (true) {
            if (cnt == N) {
                break;
            }
            if (Integer.toString(num).contains("666")) {
                cnt += 1;
            }
            num += 1;

        }
        System.out.println(num-1);
    }


}
