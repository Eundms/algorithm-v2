import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int N,M,K;
	static int[][] A, B;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // A의 크기
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M];
		for(int n = 0; n < N ; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0 ; m < M ; m++) {
				A[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		B = new int[M][K];
		for(int m = 0; m < M ; m++) {
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k < K ; k++) {
				B[m][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] ans = new int[N][K];
		for(int i = 0; i < N; i++) {
			for(int k = 0 ; k < K; k++) {
				int item = 0;
				for(int j = 0; j < M; j++) {
					item += A[i][j] * B[j][k];					
				}
				ans[i][k] = item;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int  k = 0; k < K ; k++) {
				System.out.print(ans[i][k]+" ");
			}
			System.out.println();
		}
	}
	

}
