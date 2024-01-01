import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Integer> dodo = new ArrayDeque<>();
		Deque<Integer> suyun = new ArrayDeque<>();
		Deque<Integer> gD = new ArrayDeque<>();
		Deque<Integer> gS = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			dodo.offerFirst(d);
			suyun.offerFirst(s);
		}
		System.out.println(getWinner(dodo,suyun,gD,gS,M));
	}

	private static String getWinner(Deque<Integer> dodo, Deque<Integer> suyun, Deque<Integer> gD, Deque<Integer> gS, int M) {
		while(M>0) {
			// 1. 도도 턴
			if(!dodo.isEmpty()) {
				gD.offerFirst(dodo.pollFirst());
				M--;
				if(dodo.isEmpty()) {
					return "su";
				}
			}else { // 도도 패 다 털렸네?
				return "su";
			}
			
			// 2. 종 칠지 확인
			if(!gD.isEmpty() && !gS.isEmpty() && gD.peek() + gS.peek() == 5) { // 수연이가 종을 치는 경우
				while(!gD.isEmpty()) {
					suyun.offerLast(gD.pollLast());
				}
				while(!gS.isEmpty()) {
					suyun.offerLast(gS.pollLast());
				}
			}else if((!gD.isEmpty() && gD.peek() == 5) || (!gS.isEmpty() && gS.peek() == 5)) { // 도도가 종을 치는 경우
				while(!gS.isEmpty()) {
					dodo.offerLast(gS.pollLast());
				}
				while(!gD.isEmpty()) {
					dodo.offerLast(gD.pollLast());
				}
			}
			if(M<=0) {
				break;
			}
			// 3. 수연 턴
			if(!suyun.isEmpty()) {
				M--;
				gS.offerFirst(suyun.pollFirst());
				if(suyun.isEmpty()) {
					return "do";
				}
			}else { // 수연이 패 다 털렸네?
				return "do";
			}
			
			// 4. 종 칠지 확인
			if(!gD.isEmpty() && !gS.isEmpty() && gD.peek() + gS.peek() == 5) { // 수연이가 종을 치는 경우
				while(!gD.isEmpty()) {
					suyun.offerLast(gD.pollLast());
				}
				while(!gS.isEmpty()) {
					suyun.offerLast(gS.pollLast());
				}
			}else if((!gD.isEmpty() && gD.peek() == 5) || (!gS.isEmpty() && gS.peek() == 5)) { // 도도가 종을 치는 경우
				while(!gS.isEmpty()) {
					dodo.offerLast(gS.pollLast());
				}
				while(!gD.isEmpty()) {
					dodo.offerLast(gD.pollLast());
				}
			}
		}
		if(dodo.size() > suyun.size()) {
			return "do";
		}else if(dodo.size() == suyun.size()) {
			return "dosu";
		}else {
			return "su";
		}
	}
}