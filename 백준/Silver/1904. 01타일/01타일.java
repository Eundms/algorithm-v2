
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	// 마지막 dp[i] -> 그전 dp[i-2]0 또는 dp[i-1]1
	  static int arr[];
	    static int cal(int N){
	        if(arr[N]==-1)
	            arr[N]=(cal(N-1)+cal(N-2))%15746;
	        return arr[N];
	    }
	    public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int N = Integer.parseInt(br.readLine());
	        arr =new int[1000001];
	        Arrays.fill(arr,-1);
	        arr[1]=1;
	        arr[2]=2;
	        
	        System.out.println(cal(N));
	    }
}