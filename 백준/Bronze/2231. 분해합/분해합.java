import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // N과 N을 이루는 각 자리수의 합
        int M = 1;
        for (M = 1; M < N; M++) {
            int temp = M;
            int sum = 0;
            while (temp > 0) {
                //System.out.println(temp);
                sum += temp % 10;
                temp = temp / 10;
            }
            if(sum + M ==N){
                System.out.println(M);
                break;
            }
        }
        if(M==N){
            System.out.println(0);
        }
    }
}
