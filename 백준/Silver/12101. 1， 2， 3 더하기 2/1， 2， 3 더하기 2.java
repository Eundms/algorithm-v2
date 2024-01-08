
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String answer = "";
	static int N,K;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		// n을 1,2,3의 합으로 나타내는 방법 중에서 사전 순으로 k번째 오는 것을 출력
		back("", 0);
		System.out.println(answer == "" ? -1 : answer);
	}
	static int cnt;
	static void back(String str, int sum) {
		if(sum == N) {
			//System.out.println(str);
			cnt += 1;
			if(cnt == K) {
				answer = str;
			}
			return;
		}
		for(int i = 1; i <= 3; i++) {
			if(sum + i <= N) {
				if(str.equals("")) {
					back(""+i, sum + i);
				}else {
					back(str+"+"+i, sum + i);
				}
				
			}
		}
		
	}

}
