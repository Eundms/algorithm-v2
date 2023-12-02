import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class Main {
	static int N, M;
	static Set<String> set;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 키워드 개수
		M = Integer.parseInt(st.nextToken()); // 가희가 블로그에 쓴 글의 개수
		StringBuilder sb = new StringBuilder();
		set = new HashSet<>();
		for(int i = 0; i < N; i++) { // 메모장에 적은 키워드
			set.add(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			String sentence = br.readLine();
			st = new StringTokenizer(sentence,",");
			while(st.hasMoreTokens()) {
				String word = st.nextToken();
				if(set.contains(word)) {
					set.remove(word);
				}
			}
			sb.append(set.size()+"\n");
		}
		System.out.println(sb.toString());
		
		
	}


}