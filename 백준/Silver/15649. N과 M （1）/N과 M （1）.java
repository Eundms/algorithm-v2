
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int N,M;
	
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken()); // 1-N중
	    M = Integer.parseInt(st.nextToken()); // M, 중복x
	    arr = new int[M];
	    visited = new boolean[N];
	    back(0);
	    
	}
	static void back(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			if(visited[i-1])continue;
			visited[i-1] = true;
			arr[cnt] = i; 
			back(cnt + 1);
			visited[i-1] = false;
		}
	}
}