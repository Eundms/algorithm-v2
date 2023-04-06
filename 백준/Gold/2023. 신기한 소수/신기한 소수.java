import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); //4자리수
        int[] prime = {2, 3, 5, 7};
        for (int p : prime) {
            back(1, p);
        }
    }


    private static void back(int cnt, int num) {
        if (cnt == N) {
            System.out.println(num);
            return;
        }
        for (int next = 0; next <= 9; next++) {
            if (isPrime(num * 10 + next)) {
                back(cnt + 1, num * 10 + next);
            }
        }
    }
    
    private static boolean isPrime(int num) {
        // 소수 - 1이외의 약수가 없어야 함
        for(int i = 2; i<num;i++){
            if(num%i==0)return false;
        }
        return true;
    }
}
