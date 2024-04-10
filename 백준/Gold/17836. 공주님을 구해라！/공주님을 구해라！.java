import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int N, M, T; 
	static int[][] box; // N x M
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); // 저주 제한 시간
		
		box = new int[N][M];
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M ; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int res = bfs(0,0);
		if(res == -1) {
			System.out.println("Fail");
		}else {
			System.out.println(res);
		}
	}
	static int[][] way = {{-1,0},{1,0},{0,1},{0,-1}};
	static int bfs(int x, int y) {
		
		boolean[][][] visited = new boolean[N][M][2];
		Queue<Item> queue = new ArrayDeque<>();
		queue.add(new Item (x,y,0,false));
		visited[x][y][0] = true;
		
		while(!queue.isEmpty()) {
			Item now = queue.poll();
			if(now.time > T) return -1;
			if(now.x == N-1 && now.y == M-1) {
				return now.time ;
			}

			for(int w = 0; w < 4; w++) {
				int nx = now.x + way[w][0];
				int ny = now.y + way[w][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M)continue;
				if(now.getGram) { // 이미 그램 찾은 경우
					if(visited[nx][ny][1] == false) { // 0: 그램x , 1: 그램 O 
						visited[nx][ny][1] = true;
						queue.add(new Item(nx, ny, now.time+1, now.getGram));
					}
				} else {
					if(visited[nx][ny][0] == false && box[nx][ny] == 0) {
						visited[nx][ny][0] = true;
						queue.add(new Item(nx, ny, now.time+1, now.getGram));
					} else if (visited[nx][ny][0] == false && box[nx][ny] == 2) { // 그램 찾은 경우
						visited[nx][ny][0] = true;
						queue.add(new Item(nx, ny, now.time+1, true));
					}
				}
			}
		}
		return -1;
	}
	static class Item {
		int x, y, time;
		boolean getGram;
		Item(int x, int y, int time, boolean getGram){
			this.x = x;
			this.y = y;
			this.time= time;
			this.getGram = getGram;  
		}
	}


}