import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
class Main { 
	static int N,M;
	static int[][] A,B;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		B = new int[N][M];
		
		for(int i = 0; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i = 0; i < N ; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j)-'0';
			}
		}
		
		
		int cnt = 0;
		// 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값
		for(int i = 0; i < N-2; i++) {
			for(int j = 0; j < M-2; j++) {
				if(A[i][j]==B[i][j])continue;
				reverse(i,j);
				cnt +=1;
			}
		}
		
		
		for(int i = 0; i <  N; i++) {
			for(int j = 0 ; j <M; j++) {
				if(A[i][j]==B[i][j])continue;
				System.out.println(-1);
				return;
			}
		}
		
		System.out.println(cnt);
	}
	static void reverse(int sx, int sy) {
		for(int i = sx ; i < sx+3; i++) {
			for(int j = sy; j < sy+3; j++) {
				if(A[i][j]==1) {
					A[i][j] = 0;
				}else {
					A[i][j] = 1;
				}
			}
		}
	}
	
}


 