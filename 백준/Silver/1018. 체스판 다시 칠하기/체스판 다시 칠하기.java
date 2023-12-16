import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Main { 	
	// 1018 //https://www.acmicpc.net/problem/1417
	static int M, N;
	static char[][] box;
	static char[][][] ans = {
		{
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
		},
		{
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
		}
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		box = new char[M][N];
		for(int i = 0; i < M; i++) {
			String str = br.readLine();
			for(int j = 0; j < N ; j++) {
				box[i][j] = str.charAt(j);
			}
		}
		int minDiff = Integer.MAX_VALUE;
		for(int i = 0; i < M - 7; i++) {
			for(int j = 0; j < N - 7; j++) {
				for(int w = 0; w < 2; w++) {
					
					char[][] compare = ans[w];
					int diff = 0;
					for(int r = i; r < i + 8; r++) {
						for(int c = j; c < j + 8; c++) {
							if(box[r][c]!=compare[r-i][c-j]) {
								diff+=1;
							}
						}
					}
					minDiff = Math.min(minDiff, diff);
				}
			}
		}
		System.out.println(minDiff);
	}

}


 