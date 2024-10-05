
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int N, S;
	static int[] box;
	static int ans;
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken()); // 정수의 개수
	    S = Integer.parseInt(st.nextToken()); // 수열의 원소를 다 더한 값

	    box = new int[N];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++) {
	    	box[i] = Integer.parseInt(st.nextToken());
	    }
	    dfs(0, 0, 0);
	    System.out.println(ans);
	}
	
	static void dfs(int n, int s, int cnt) {
		if(n == N) {
			if(s == S && cnt > 0) {
				ans += 1;
			}
			return;
		}
		dfs(n + 1, s + box[n], cnt + 1);
		dfs(n + 1, s, cnt);
	}
}