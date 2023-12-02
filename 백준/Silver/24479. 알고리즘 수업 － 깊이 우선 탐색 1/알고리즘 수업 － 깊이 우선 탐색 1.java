
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	static int N, M, R;
	static List<Integer>[] adjList;
	static int[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[N+1]; // 정점 1 ~ N
		for(int i = 0; i <= N ; i++) {
			adjList[i] = new ArrayList<>();
		}
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		for(int i = 0; i <= N ; i++) {
			Collections.sort(adjList[i]);
		}
		visited = new int[N+1];
		dfs(R);
		for(int i = 1; i <= N ; i++) {
			System.out.println(visited[i]);
		}
	}
	static int cnt=1;
	static void dfs(int start) { // 시작 정점의 방문 순서 1 , 방문할 수 없는 경우 0
		if(visited[start]>0) {
			return;
		}
		visited[start] = cnt++;
		for(int next : adjList[start]) {
			dfs(next);
		}
	}

}
