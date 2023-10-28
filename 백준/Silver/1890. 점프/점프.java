
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int[][] box;
	static long[][] memo;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		
		box = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j <  N ; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		memo = new long[N][N];
	    for(int i = 0; i < N; i++) {
	        Arrays.fill(memo[i], -1);
	    }
		
		System.out.println(dfs(0,0));
	}
	static int[][] way = {{0,1},{1,0}}; // 오른쪽, 아래
	static int cnt;
	static long dfs(int i, int j) {
		if(i<0 || i>=N || j <0 || j>=N)return 0;
		if(i==N-1 && j==N-1)return 1;
		if(memo[i][j]!=-1)return memo[i][j];
		memo[i][j] = 0;
		for(int w = 0; w < 2; w++) {
			int nx = i + box[i][j] * way[w][0];
			int ny = j + box[i][j] * way[w][1];
			memo[i][j] += dfs(nx,ny);
		}
		return memo[i][j];
	}
	/*
	static void dfs(int i, int j) {
		if(i==N-1 && j == N-1) {
			cnt+=1;
			return;
		}
		for(int w = 0; w < 2; w++) {
			int nx = i + box[i][j] * way[w][0];
			int ny = j + box[i][j] * way[w][1];
			if(nx<0 || nx>=N || ny<0 || ny>=N)continue;
			dfs(nx,ny);
		}
	}
	*/

}
