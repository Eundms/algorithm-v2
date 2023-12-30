import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int R, C;
	static char[][] box;
	static char[][] copyed;
	static int[][] way = {{-1,0},{1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		box = new char[R][C];
		copyed = new char[R][C];
		for(int r = 0; r < R; r++) {
			String str = br.readLine();
			for(int c = 0; c < C; c++) {
				box[r][c] = str.charAt(c);
				copyed[r][c] = box[r][c];
			}
		}
		
		for(int i = 0; i < R; i ++) {
			for(int j = 0; j < C; j++) {
				if(box[i][j] == 'X') {
					//상하좌우 확인
					int cnt = 0;
					for(int w = 0; w < 4; w++) {
						int nx = i + way[w][0];
						int ny = j + way[w][1];
						if(nx<0 || nx>=R || ny<0 || ny>=C) {cnt+=1; continue;}
						if(box[nx][ny]=='.') {
							cnt += 1;
						} 
					}
					if(cnt>=3) {
						copyed[i][j]='.';
					}
				}
			}
		}
		
		int minX = Integer.MAX_VALUE;
		int minY = Integer.MAX_VALUE;
		int maxX = Integer.MIN_VALUE;
		int maxY = Integer.MIN_VALUE;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(copyed[i][j]=='X') {
					minX = Math.min(minX, i);
					maxX = Math.max(maxX,i);

					minY = Math.min(minY, j);
					maxY = Math.max(maxY, j);
				}
			}
		}
		for(int x = minX; x <= maxX; x++) {
			for(int y = minY; y <= maxY; y++) {
				System.out.print(copyed[x][y]);
			}
			System.out.println();
		}
		
	}
}

 