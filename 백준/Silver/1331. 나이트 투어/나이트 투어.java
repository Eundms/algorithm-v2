import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main { 	
	
	static int N,M;
	static boolean[][] box = new boolean[6][6];
	static int sx,sy, ex,ey;
	static int prevX=-1, prevY=-1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 36; i++) {
			String str = br.readLine();
			int row = str.charAt(0)-'A';
			int col = str.charAt(1)-'1';
			if(i==0) {
				sx = row;
				sy = col;
			}else if(i==35) {
				ex = row;
				ey = col;
			}
			if(box[row][col]) {
				System.out.println("Invalid");
				return;
			}
			if(i>0 && !isNext(prevX, prevY,row,col)) {

				System.out.println("Invalid");
				return;
			}
			box[row][col] = true;
			prevX = row;
			prevY = col;
		}

		if(isNext(ex,ey,sx,sy)) {
			System.out.println("Valid");
			return;
		}
		System.out.println("Invalid");
	}
	static boolean isNext(int a,int b, int c, int d) {
		int[][] way = {{-2,1},{2,1},{-2,-1},{2,-1},{-1,2},{1,2},{-1,-2},{1,-2}};
		for(int w = 0; w < 8; w++) {
			int nx = a + way[w][0];
			int ny = b + way[w][1];
			if(nx == c && ny == d) {
				return true;
			}
		}
		return false;
	}


}


 