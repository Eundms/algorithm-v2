import java.io.*;
import java.util.StringTokenizer;
// 수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램?
public class Main {
    static int N,M;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken()); //수의 개수
        M=Integer.parseInt(st.nextToken()); //합을 구해야 하는 횟수

        dp=new int[N+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            dp[i]=Integer.parseInt(st.nextToken())+dp[i-1];
        }

        //합을 구해야 하는 구간 i ~ j
        for(int i=1;i<=M;i++){
            st =new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(dp[b]-dp[a-1]);
        }

    }
}
