
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int T;
	static int[] A;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			A = new int[10]; // 배열 A가 주어졌을 떄 N번쨰 큰 값
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 10; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);
			System.out.println(A[7]);
		}
	
	}

}
