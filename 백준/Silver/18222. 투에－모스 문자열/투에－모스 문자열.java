import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {// 투에모스

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(br.readLine());

        System.out.println(toEmos(k-1));
    }

    private static int toEmos(long k) {
        if (k == 0) {
            return 0;
        }
        else if(k == 1){
            return 1;
        }
        if (k % 2 == 0) {
            return toEmos(k / 2);
        } 
        return 1 - toEmos((k - 1) / 2);

    }

}
