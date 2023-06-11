import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N = 1000000;
    static int num;
    static boolean[] isPrime;

    public static void main(String[] args) throws Exception {
        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= N; i++) {
            for (int j = i * i; j <= N; j += i) {
                isPrime[j] = false;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                break;
            }
            boolean isTrue = false;
            for (int n = 1; n < num; n++) {
                if (isPrime[n] && isPrime[num - n]) {
                    System.out.println(num + " = " + n + " + " + (num - n));
                    isTrue = true;
                    break;
                }
            }
            if (!isTrue) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }

    }
}