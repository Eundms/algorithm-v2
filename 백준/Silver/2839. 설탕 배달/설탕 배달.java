import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {//dp or greedy
    /**
     * 3 * X + 5 * Y = N
     * min( X + Y )
     * **/
    static int N; // N 킬로그램

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 정확하게 N킬로그램 배달
        // 3킬로그램 봉지, 5킬로그램 봉지
        // 더 적은 개수의 봉지
        int cnt=0;
        while(N>=0){
            if(N%5==0){
                cnt += N/5;
                System.out.println(cnt);
                return;
            }
            N-=3;
            cnt+=1;
        }
        System.out.println(-1);
    }

}
