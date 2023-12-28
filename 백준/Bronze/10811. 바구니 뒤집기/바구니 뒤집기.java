import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static int N, M; // 바구니 총 N개, M번 swap 시도
	static int[] box;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		box = new int[N+1];
		for(int i= 0; i < N+1; i++) {
			box[i] = i;
		}
		for(int m = 0; m < M; m++) { // 바구니의 순서를 역순으로 만드는 방법
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int[] temp = new int[j-i+1];
			for(int x = i; x <= j; x++) {
				temp[x-i] = box[x];
			}
			int idx = 0;
			for(int x = j; x >= i; x--) {
				box[x] = temp[idx++];
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(box[i]+" ");
		}
		System.out.println();
		
		
	} 

}

 