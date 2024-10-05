
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] val;
	static int[] arr;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken()); // 정수의 개수
	    M = Integer.parseInt(st.nextToken()); // 수열의 원소를 다 더한 값
	    visited = new boolean[N];
	    val =  new int[N];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++) {
	    	val[i] = Integer.parseInt(st.nextToken());
	    }
	    Arrays.sort(val);
	    arr = new int[M]; 
	    sb = new StringBuilder();
	    back(0, 0);
	    System.out.println(sb);
	 
	}
	static void back(int cnt, int idx) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = idx; i < N; i++) { // 선택지인덱스
			arr[cnt] = val[i];
			back(cnt + 1, i);
			
		}
		
	}
	

}