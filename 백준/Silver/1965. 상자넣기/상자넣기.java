import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {//1965 상자 넣기
	static int N;
	static int[] cost;
	static int[] dp;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine()); // 
        cost = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N ; i++) {
        	cost[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new int[N+1];
        int max = 0;
        // 증가하는 부분 순열
        for(int i = 1; i <= N; i++) {
        	dp[i] = 1;
        	for(int j = 1; j < i ; j++) {
        		if(cost[j]<cost[i]&&dp[i]<dp[j]+1) {
        			dp[i] = dp[j]+1;
        		}
        	}
        	if(max<dp[i])max = dp[i];
        }
        System.out.println(max);
   
    }
}

 