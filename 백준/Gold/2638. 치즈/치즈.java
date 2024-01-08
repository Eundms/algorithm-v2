import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int N,M; // 세로 격자의 수, 가로 격자의 수
	static int[][] box;
	static int cheeseCnt,delCheeseCnt;
	static Queue<int[]>air;
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		box = new int[N][M];
		for(int n = 0 ; n < N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				box[n][m] = Integer.parseInt(st.nextToken());
				cheeseCnt += box[n][m];
			}
		}
		
		

		int time = 0;
		int[][] temp = copy(box);
		air = new ArrayDeque<>();
		air.add(new int[] {0,0});
		
		while(true) {
			// 외부 공기 표시	
			temp = checkOutSide(temp);
			//print(temp);
			// 외부 공기와 2변 이상이 접촉해있는 치즈 확인 & 녹임
			checkCheeseNearAir(temp);
			box = copy(temp);
			time += 1;
			if(delCheeseCnt==cheeseCnt)break;
					
		}
		System.out.println(time);
		
	}
	static void print(int[][] temp) {
		for(int i = 0; i < N ; i++) {
			for(int j  = 0; j < N ; j++) {
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static int CHEESE = 1, AIR = 5;
	static int[][] way = {{-1,0},{1,0},{0,1},{0,-1}};
	static void checkCheeseNearAir(int[][] temp) {
		for(int i = 0; i < N ; i++) {
			for(int j = 0; j < M; j++) {
				if(temp[i][j] == CHEESE) {
					int cnt = 0;
					for(int w = 0; w < 4; w++) {
						int nx = i + way[w][0];
						int ny = j + way[w][1];
						if(nx < 0 || nx >= N || ny < 0 || ny >= M)continue;
						if(temp[nx][ny] == AIR) {
							cnt+=1;
						}
					}
					if(cnt >= 2) {
						air.add(new int[] {i,j});
						delCheeseCnt += 1;
					}
					
				}
				
			}
		}
	}
	static int[][] checkOutSide(int[][] temp) {
		while(!air.isEmpty()) {
			int[] now = air.poll();
			if(temp[now[0]][now[1]]==AIR)continue;
			//System.out.println(now[0]+","+now[1]);
			temp[now[0]][now[1]] = AIR;
			for(int w = 0;  w < 4 ; w++) {
				int nx = now[0] + way[w][0];
				int ny = now[1] + way[w][1];
				if(nx<0 || nx>=N|| ny <0 || ny>=M || temp[nx][ny]==AIR)continue;
				if(box[nx][ny] == 0) {
					air.add(new int[] {nx,ny});
				}
			}
		}
		return temp;
	}
	static int[][] copy(int[][] box){
		int[][] temp = new int[N][M];
		for(int n = 0; n < N ; n++) {
			for(int m = 0; m < M ; m++) {
				temp[n][m] = box[n][m];
			}
		}
		return temp;
	}

}
