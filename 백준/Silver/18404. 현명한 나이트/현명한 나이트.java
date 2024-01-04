import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main { 
	static int N,M;
	static int[][] box;
	static int[][] way = {{-2,-1},{-2,1},{-1,-2},{-1,2},{1,-2},{1,2},{2,-1},{2,1}};
	static boolean[][] visited;
	static int[][] horse;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(st.nextToken())-1;
		int Y = Integer.parseInt(st.nextToken())-1;
		
		box = new int[N][N]; // N x N 크기 체스판
		horse = new int[M][2];
		for(int m = 0; m < M; m++) { // 말들의 위치 
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			box[A][B] = 1;
			horse[m][0] = A;
			horse[m][1] = B;
		}
		
		Map<String,Integer> map = new HashMap<>();
		int cnt = 0;
		// 현재 나이트의 위치.. 8가지 위치 중 하나의 위치로 이동..
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {X,Y,0});
		visited = new boolean[N][N];
		visited[X][Y] = true;

		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(box[now[0]][now[1]] == 1) {
				cnt = now[2];
				map.put(""+now[0]+","+now[1], cnt);
			}
			for(int w = 0; w < 8; w++) {
				int nx = now[0] + way[w][0];
				int ny = now[1] + way[w][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N)continue;
				if(visited[nx][ny])continue;
				visited[nx][ny] = true;
				queue.add(new int[] {nx,ny,now[2]+1});
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < M; i++) {
			sb.append(map.get(horse[i][0]+","+horse[i][1])).append(" ");
		}
		System.out.println(sb);
	}


}