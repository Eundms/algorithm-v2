
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int N, M;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken()); // 정수의 개수
	    M = Integer.parseInt(st.nextToken()); // 수열의 원소를 다 더한 값

	    arr = new int[M]; 
	    sb = new StringBuilder();
	    back(0, 1);
	    System.out.println(sb);
	 
	}
	static void back(int cnt, int val) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 1; i <= N; i++) { // 선택지
			arr[cnt] = i;
			back(cnt + 1, i+1);
		}
		
	}
	

}