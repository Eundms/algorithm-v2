import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long sum = 0;
        int res = 0;
        
        for (int i = 1; ; i++) {
            if (sum > N) {
                break;
            }
            sum += i;
            res += 1;
        }
        System.out.println(res -1);
    }
}
