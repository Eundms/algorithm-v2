
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken()); // 정수의 개수
	    M = Integer.parseInt(st.nextToken()); // 수열의 원소를 다 더한 값

	    arr = new int[M]; // 중복없이, 오름차순
	    back(0, 1);
	 
	}
	static void back(int cnt, int val) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i = val; i <= N; i++) { // 선택지
			arr[cnt] = i;
			back(cnt + 1, i+1);
		}
		
	}
	

}