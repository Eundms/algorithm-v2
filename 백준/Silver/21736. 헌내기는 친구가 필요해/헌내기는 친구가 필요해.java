import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static char[][] box;
	static char EMPTY = 'O';
	static char WALL = 'X';
	static char PERSON = 'P';
	static int sx,sy;
	static int[][] way = {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		box = new char[N][M];
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < M; j++) {
				box[i][j] = line.charAt(j);
				if(box[i][j] == 'I') {
					sx = i; sy = j;
				}
			}
		}
		
		int cnt = 0;
		boolean[][] visited = new boolean[N][M];
		Queue<int[]>queue = new ArrayDeque<>();
		queue.add(new int[] {sx,sy});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			if(visited[now[0]][now[1]])continue;
			visited[now[0]][now[1]] = true;
			if(box[now[0]][now[1]] == PERSON) {cnt+=1;}

			for(int w = 0; w < 4; w++) {
				int nx = now[0] + way[w][0];
				int ny = now[1] + way[w][1];
				if(nx < 0 || nx >= N || ny < 0 || ny >= M)continue;
				if(visited[nx][ny])continue;
				if(box[nx][ny] == WALL)continue;
				queue.add(new int[] {nx, ny});
			}
		}

		
		if(cnt == 0) {
			System.out.println("TT");
		}else {
			System.out.println(cnt);
		}
	}

}
