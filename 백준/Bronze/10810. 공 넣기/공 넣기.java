import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Main { 	
	static int N, M;
	static int[] basket;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 바구니 총 N개
		M = Integer.parseInt(st.nextToken()); //M번 공 넣기
		basket = new int[N+1];
		for(int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for(int a = i; a <= j; a++) {
				basket[a] = k;
			}
		}
		for(int i = 1; i <= N; i++) {
			System.out.print(basket[i]+" ");
		}
	
	}
}


 