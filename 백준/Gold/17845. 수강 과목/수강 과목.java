
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int N, K;
	static Item[] box;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 최대 공부시간
		K = Integer.parseInt(st.nextToken()); // 과목 수
		
		box = new Item[K];
		for(int i = 0; i < K ; i++) { // 중요도 I, 필요한 공부시간 T
			st = new StringTokenizer(br.readLine());
			int importance = Integer.parseInt(st.nextToken()); //중요도
			int time = Integer.parseInt(st.nextToken()); //필요한 공부시간
			box[i] = new Item(importance, time);
		}
		
		Arrays.sort(box);
		// 최대 공부시간이 N인데, k번째 과목까지 고려했을 때 최대 중요도 
		// dp[K][N] = Math.max(dp[k-1][N], dp[k-1][N-box[k].time] + box[k].importance)
		int[][] dp  = new int[K+1][N+1];
		for(int k = 1; k <= K; k++) {
			for(int j = 1; j <= N; j++) {
				if(j-box[k-1].time>=0)
					dp[k][j] = Math.max(dp[k-1][j], dp[k-1][j-box[k-1].time] + box[k-1].importance);			
				else
					dp[k][j] = dp[k-1][j];
			}
		}
		System.out.println(dp[K][N]);
		
	}
	static class Item implements Comparable<Item>{
		int importance;
		int time;
		Item(int importance, int time){
			this.importance = importance;
			this.time = time;
		}
		@Override
		public int compareTo(Item o) {
			if(this.time == o.time) {
				return o.importance - this.importance;
			}
			return this.time - o.time;
		}
	}

}
