import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N, K;
	static Queue<Integer> queue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =  new StringTokenizer(br.readLine());
		// N명의 사람, K 번째 사람 제거
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		queue = new ArrayDeque<>();
		int i = 1;
		while(i<=N) {
			queue.add(i++); // i 증가 주의하기!
		}

		int delcnt = 0;
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		int cnt = 0;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			cnt += 1;
			if(cnt == K) {sb.append(now); if(delcnt!=N-1) {sb.append(", ");}delcnt+=1; cnt = 0; continue;}
			queue.add(now);
		}
		sb.append(">");
		
		System.out.println(sb);
	}

}