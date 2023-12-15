import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
class Main { //2580 스도쿠 //3061 사다리 //1302  //16235 //17492
	static int T, N, M; // 테스트케이스의 수, 수첩 1에 적은 정수의 개수
	static Set<Integer> set;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			StringBuilder sb = new StringBuilder();

			N = Integer.parseInt(br.readLine());
			// 수첩1 : 연종이 본 정수들
			set = new HashSet<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N ; i++) {
				set.add(Integer.parseInt(st.nextToken()));
			}
			
			
			// 수첩2 에 적어 놓은 정수의 개수 M
			M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < M ; i++) {
				int val = Integer.parseInt(st.nextToken());
				if(set.contains(val)) {
					sb.append("1\n");
				}else {
					sb.append("0\n");
				}
			}
			System.out.print(sb);
		}

	}


}


 