import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
class Main { //2580 스도쿠 //3061 사다리  //16235 //17492 //1302 //2776
	static int BOX_SIZE = 9;
	static int[][] box = new int[BOX_SIZE][BOX_SIZE];
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//값채우고 가로, 세로, 정사각형 확인
		for(int i = 0; i < BOX_SIZE; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < BOX_SIZE; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		back(0,0);
		
	}
	static void back(int row, int col) {
		if(col==9) {
			back(row+1,0);
			return;
		}
		if(row == 9) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(box[i][j]).append(' ');
				}
				sb.append('\n');
			}
			System.out.print(sb);
			System.exit(0);
		}
		
		if (box[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (possibility(row, col, i)) {
					box[row][col] = i;
					back(row, col + 1);
					box[row][col] = 0;
				}
			}
			
			return;
		}
 
		back(row, col + 1);
	}

	public static boolean possibility(int row, int col, int value) {

		for (int i = 0; i < 9; i++) {
			if (box[row][i] == value) {
				return false;
			}
		}
 
		for (int i = 0; i < 9; i++) {
			if (box[i][col] == value) {
				return false;
			}
		}
 
		int set_row = (row / 3) * 3;
		int set_col = (col / 3) * 3;
 
		for (int i = set_row; i < set_row + 3; i++) {
			for (int j = set_col; j < set_col + 3; j++) {
				if (box[i][j] == value) {
					return false;
				}
			}
		}
 
		return true;
	}
}


 