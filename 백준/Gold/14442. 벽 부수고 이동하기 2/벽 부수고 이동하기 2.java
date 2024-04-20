import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int N,M,K;
	static int[][] box;
	static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		box = new int[N][M];
		for(int n = 0; n < N; n++) {
			String line = br.readLine();
			for(int m = 0; m < M; m++) {
				box[n][m] = line.charAt(m)-'0';
			}
		}
		int shortRoute = bfs(0,0);
		System.out.println(shortRoute);
	}
	static int bfs(int sx, int sy) {
		boolean[][][] visited = new boolean[K+1][N][M];
		Queue<Item> queue = new ArrayDeque<>();	
		visited[0][sx][sy] = true;
		queue.add(new Item(sx,sy,1,0));
		
		while(!queue.isEmpty()) {
			Item now = queue.poll();
			if(now.x == N-1 && now.y == M-1) {
				return now.dist;
			}
			for(int w = 0; w < 4; w++) {
				int nx = now.x + way[w][0];
				int ny = now.y + way[w][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M)continue;
				if(!visited[now.crushCnt][nx][ny] && box[nx][ny] == 0) { // 방문한 적이 없고 갈 수 있다면
					visited[now.crushCnt][nx][ny] = true;
					queue.add(new Item(nx, ny, now.dist+1, now.crushCnt));		
				} else {
					if(now.crushCnt < K && !visited[now.crushCnt+1][nx][ny]) {
						visited[now.crushCnt+1][nx][ny] = true;
						queue.add(new Item(nx,ny,now.dist+1, now.crushCnt+1));
					}
				}
				
			}
		}
		return -1;
	}
	static class Item {
		int x, y, dist;
		int crushCnt;
		Item(int x, int y, int dist, int crushCnt) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.crushCnt = crushCnt;
		}
		@Override
		public String toString() {
			return ""+x+","+y+" => "+dist+" "+crushCnt;
		}
	}
	
}