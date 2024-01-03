import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main { 
	static int N, M;
	static Set<Integer> set;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수
		set = new HashSet<>(); // 숫자 카드에 적혀있는 정수
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i++) {
			set.add(Integer.parseInt(st.nextToken()));			
		}
		
		StringBuilder sb = new StringBuilder();
		M = Integer.parseInt(br.readLine()); //숫자카드인지 아닌지 구해야할 M개의 정수
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		System.out.println(sb);
	}
}