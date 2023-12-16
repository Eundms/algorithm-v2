import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class Main { 	
	static int M; // 컵의 위치를 바꾼 횟수
	static int[] pos = {0,1,2,3};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		M = Integer.parseInt(br.readLine());
		for(int m = 0; m < M; m++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int temp = pos[a];
			pos[a] = pos[b];
			pos[b] = temp;
		}
		for(int i = 1; i <= 3; i++) {
			if(pos[i]==1) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}


 