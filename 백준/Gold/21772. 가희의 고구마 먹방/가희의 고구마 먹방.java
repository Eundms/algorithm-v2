import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main {
	static int R,C,T;
	static char[][] box;
	static int curX, curY;
	static int[][] way = {{1,0}, {0,1}, {0,-1}, {-1,0}, {0,0}};
	static int maxSweetPotato = Integer.MIN_VALUE;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken()); // 맵의 세로 크기
		C = Integer.parseInt(st.nextToken()); // 가로 크기
		T = Integer.parseInt(st.nextToken()); // 가희가 이동하는 시간
		
		box = new char[R][C];
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			for(int c = 0; c < C; c++) {
				box[r][c] = str.charAt(c);
				if(box[r][c] == 'G') { // 가희의 현재 위치 
					curX = r;
					curY = c;
				}
			}
		}
//		for(int i = 0; i < R ; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.print(box[i][j]);
//			}
//			System.out.println();
//		}
		// G : 가희의 현재 위치 
		back(0, curX, curY, 0);
		System.out.println(maxSweetPotato);
	}
	
	static void back(int time, int x, int y, int cnt) {
		if(time == T) {
			maxSweetPotato = Math.max(cnt, maxSweetPotato);
			return;
		}
		for(int w = 0; w < way.length; w++) {
			int nx = x + way[w][0];
			int ny = y + way[w][1];
			if(nx<0 || nx>= R || ny<0 || ny>= C) continue;
			if(box[nx][ny] == 'S') {
				box[nx][ny] = '.';
				back(time+1, nx, ny, cnt + 1);			
				box[nx][ny] = 'S';
			}else if(box[nx][ny]!='#'){
				back(time+1, nx, ny, cnt);
			}
		}
		
	}
	
}


 

 