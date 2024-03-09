import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N,M;
	static int[][] box;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int sx = 0, sy = 0;
		box = new int[N][M];
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j]==2) {
					sx = i; sy = j;
				}
			}
		}
		int[][] result = new int[N][M];
		boolean[][] visited = new boolean[N][M];
		Queue<int[]>queue = new ArrayDeque<>();	
		queue.add(new int[] {sx,sy,0});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(visited[now[0]][now[1]])continue;
			visited[now[0]][now[1]] = true;
			result[now[0]][now[1]] = now[2];
			for(int w = 0; w < 4; w++) {
				int nx = now[0] + way[w][0];
				int ny = now[1] + way[w][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M)continue;
				if(visited[nx][ny])continue;
				if(box[nx][ny]==0)continue;
				queue.add(new int[] {nx,ny,now[2]+1});				
			}
		}
		
		for(int i = 0; i < N ; i++) {
			for(int j = 0 ; j < M; j++) {
				if(result[i][j] != 0) {
					System.out.print(result[i][j]+" ");					
				}else {
					if(box[i][j] == 1){
						System.out.print(-1+" ");						
					}else {
						System.out.print(result[i][j]+" ");						
					}
				}

			}
			System.out.println();
		}		
		
	}
}
