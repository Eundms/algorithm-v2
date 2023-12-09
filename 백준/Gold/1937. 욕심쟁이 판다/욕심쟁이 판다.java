import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int[][] box;
	static int maxCnt;
	//static boolean[][] visited;
	static int[][] dp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		box = new int[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =  0; j < N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp = new int[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				//visited = new boolean[N][N];
				//move(i,j, 1);
				
				maxCnt = Math.max(maxCnt,move(i,j));
			}
		}
		System.out.println(maxCnt);
		
	
	}
	static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	private static int move(int i , int j) {
		if(dp[i][j]!=0)return dp[i][j];
		dp[i][j] = 1;
		for(int w = 0; w < 4; w++) {
			int nx = i + way[w][0];
			int ny = j + way[w][1];
			if(nx<0 || nx>=N || ny<0 || ny>=N)continue;
			if(box[nx][ny]>box[i][j]) {
				dp[i][j] = Math.max(dp[i][j],move(nx,ny)+1);
			}
		}
		return dp[i][j];
	}
//	private static void move(int i, int j, int cnt) {
//		if(visited[i][j])return;
//		visited[i][j] = true;
//		maxCnt = Math.max(maxCnt, cnt);
//		for(int w = 0; w < 4; w++) {
//			int nx = i + way[w][0];
//			int ny = j + way[w][1];
//			if(nx<0 || nx>=N || ny<0 || ny>=N)continue;
//			if(box[nx][ny]>box[i][j]) {
//				move(nx,ny, cnt+1);
//			}
//		}
//		
//	}
	
}