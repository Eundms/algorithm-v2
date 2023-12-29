import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int R, C, N;
	static char[][] box;
	static int[][] bombTime;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		// 폭탄 -> 3초후에 폭발 & 인접한 네칸도 함께 폭발 & 연쇄 반응 없음
		// (i,j) -> (i+1,j), (i-1,j), (i,j+1), (i,j-1)
		// 0) 초기 폭탄 설치
		// 1) 아무것도 하지 않음
		// 2) 모든 칸에 폭탄을 설치함 -> 모든 칸은 폭탄을 가지고 있음
		// 3) 폭발 
		
		// 2과 3 반복함!
		bombTime = new int[R][C];
		box = new char[R][C];
		for(int r = 0; r < R; r++) {
			String line = br.readLine();
			for(int c = 0; c < C; c++) {
				box[r][c] = line.charAt(c);
				if(box[r][c]=='O') {
					bombTime[r][c] = 3; // 3초일때 터지게 된다
				}
			}
		}
		
		for(int time = 1; time <= N; time++) {
			// 폭탄이 터지는 시간  = 놓인시간 + 3
			if(time % 2 == 0) {// 반복하므로
				// 모든 칸에 폭탄을 설치함
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						if(bombTime[i][j]==0) {
							bombTime[i][j] = time + 3;
						}
					}
				}
			}else {
				int[][] temp = copy(bombTime);
				for(int i = 0; i < R; i++) {
					for(int j = 0; j < C; j++) {
						if(bombTime[i][j] == time) {
							temp[i][j] = 0;
							for(int w = 0; w < 4; w++) {
								int nx = i + way[w][0];
								int ny = j + way[w][1];
								if(nx < 0 || nx >= R || ny < 0 || ny >= C)continue;
								temp[nx][ny] = 0;
							}
						}
					}
				}
				bombTime = copy(temp);
			}
		}
		printBox();
	}
	static int[][] way = {{-1,0},{1,0},{0,1},{0,-1}};
	static int[][] copy(int[][] bombTime){
		int[][] temp = new int[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				temp[i][j] = bombTime[i][j];
			}
		}
		return temp;
	}
	static void printTime() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(bombTime[i][j]+" ");
			}
			System.out.println();
		}	
		System.out.println();
	}
	static void printBox() {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(bombTime[i][j]>0) {
					System.out.print("O");
				}else {
					System.out.print(".");
				}
			}
			System.out.println();
		}	
		System.out.println();
	}
}

 