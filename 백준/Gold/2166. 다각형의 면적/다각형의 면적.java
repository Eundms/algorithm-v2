import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        long[] x = new long[N + 1];
        long[] y = new long[N + 1];
        
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }
        
        x[N] = x[0];
        y[N] = y[0];

        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < N; i++) {
            sum1 += x[i] * y[i + 1];  // x_i * y_{i+1}
            sum2 += y[i] * x[i + 1];  // y_i * x_{i+1}
        }

        double area = Math.abs(sum1 - sum2) / 2.0;

        // 소수점 둘째 자리까지 출력
        System.out.printf("%.1f\n", area);
    }
}
