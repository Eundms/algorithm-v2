
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;




class Main {
	static int R,C;
	static char[][] box;
	static Position start;
	static Queue<Item> fire;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int[][] fireTime = new int[R][C];
		
		box = new char[R][C];
		fire = new ArrayDeque<>();
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			for(int c = 0; c < C; c++) {
				box[r][c] = str.charAt(c);
				if(box[r][c] == 'J') {
					start = new Position(r,c);	
					box[r][c] = '.';
				} else if(box[r][c] == 'F') {
					fire.add(new Item(0,new Position(r,c)));
				} else if(box[r][c] == 'W') {
					fireTime[r][c] = -1;
				} else if(box[r][c] == '#') {
					fireTime[r][c] = -1;
				}
			}
		}
		
		
		boolean[][] visited = new boolean[R][C];
		while(!fire.isEmpty()) {
			Item now = fire.poll();
			if(visited[now.position.x][now.position.y])continue;
			visited[now.position.x][now.position.y] = true;
			fireTime[now.position.x][now.position.y] = now.time;
			for(int w = 0; w < 4; w++) {
				int nx = now.position.x + way[w][0];
				int ny = now.position.y + way[w][1];
				if(nx < 0 || nx >= R || ny < 0 || ny >= C)continue;
				if(visited[nx][ny])continue;
				if(box[nx][ny] == '.') {
					fire.add(new Item (now.time + 1, new Position(nx,ny)));	
				}
			}
		}
		
//		for(int i = 0; i < R ; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(fireTime[i][j]+" ");
//			}
//			System.out.println();
//		}
//		
		
		Queue<Item> queue = new ArrayDeque<>();
		visited = new boolean[R][C];
		queue.add(new Item(0,start));
		while(!queue.isEmpty()) {
			Item now = queue.poll();
			if(visited[now.position.x][now.position.y])continue;
			visited[now.position.x][now.position.y] = true;
			
			for(int w = 0; w < 4 ; w++) {
				int nx = now.position.x + way[w][0];
				int ny = now.position.y + way[w][1];
				if(nx<0 || nx>=R || ny<0 || ny>=C) {System.out.println(now.time+1);return;}
				if(visited[nx][ny])continue;
				if(box[nx][ny]=='.' && (fireTime[nx][ny] > now.time + 1 || fireTime[nx][ny] == 0)) {
					queue.add(new Item(now.time+1, new Position(nx,ny)));
				}
			}
		}
		System.out.println("IMPOSSIBLE");
		
		
	}
	static int[][] way = {{-1,0},{1,0},{0,1},{0,-1}};
	static class Position {
		int x, y;
		Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static class Item {
		int time;
		Position position;
		Item(int time, Position position){
			this.time = time;
			this.position = position;
		}	
	}
}
