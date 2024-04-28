import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int N, M; // 연구소의 크기, 놓을 수 있는 바이러스의 개수
	static int[][] box;
	static int EMPTY = 0, WALL = 1, CAN_VIRUS = 2, VIRUS = 3;
	static List<Item> canVirus;
	static Queue<Item> queue;
	
	static int CANDIDATE;
	static int[] picked;
	static boolean[] visited;
	static int minTime = Integer.MAX_VALUE;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		box = new int[N][N];
		canVirus = new ArrayList<>();
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N ; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == CAN_VIRUS) {
					canVirus.add(new Item(i,j));
					box[i][j] = 0;
				}
			}
		}
		CANDIDATE = canVirus.size();
		// 서로 다른 SIZE개 중에 M 개 뽑기
		visited = new boolean[CANDIDATE];
		picked = new int[M];
		pick(0,0);
		System.out.println(minTime == Integer.MAX_VALUE? -1 : minTime);
	
	}
	static void pick(int cnt, int curIdx) {
		if(cnt == M) {
			int[][] curBox = copy(box);
			List<Item> curVirus = new ArrayList<>();
			for(int i = 0; i < M; i++) {
				Item now = canVirus.get(picked[i]);
				curBox[now.x][now.y] = VIRUS;
				curVirus.add(now);
			}
			//WprintBox(curBox);
			int time = bfs(curBox, curVirus);
			//System.out.println(time);
			minTime = Math.min(time, minTime);
			return;
		}
		for(int i = curIdx; i < CANDIDATE; i++) {
			if(visited[i])continue;
			visited[i] = true;
			picked[cnt] = i; 
			pick(cnt + 1, i);
			visited[i] = false;
		}
	}
	static int[][] way = {{-1,0},{1,0},{0,1},{0,-1}};
	static int bfs(int[][] box, List<Item> curVirus) {
		boolean[][] visited = new boolean[N][N];
		
		Queue<Item> queue = new ArrayDeque<>();
		queue.addAll(curVirus);
		
		int time = -1;
		while(!queue.isEmpty()) {
			
			int cur = queue.size();
			
			for(int c = 0; c < cur; c++) {
				Item now = queue.poll();
				
				for(int w = 0; w < 4; w++) {
					int nx = now.x + way[w][0];
					int ny = now.y + way[w][1];
					if(nx < 0|| nx >= N || ny < 0 || ny >= N) {continue;}
					if(visited[nx][ny])continue;
					if(box[nx][ny] == EMPTY) {
						visited[nx][ny] = true;
						box[nx][ny] = VIRUS;
						queue.add(new Item(nx,ny));
					} 
				}				
			}
			time += 1;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(box[i][j] == 0) {
					time = Integer.MAX_VALUE;
					break;
				}
			}
		}
		
		return time;
	}
	static void printBox(int[][] box) {
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(box[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int[][] copy(int[][] box) {
		int[][] now = new int[N][N];
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < N; j++) {
				now[i][j] = box[i][j];
			}
		}
		return now;
	}
	static class Item {
		int x, y;
		Item(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
}