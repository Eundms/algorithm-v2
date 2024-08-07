import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int N; 
	static int a;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 거점지를 방문한 횟수
		pq = new PriorityQueue<>();
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			a = Integer.parseInt(st.nextToken()); // 충전할 선물
			if (a == 0) { // 거점지가 아닌 아이들을 만남
				if(pq.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(-pq.poll());
				}
				continue;
			} 
			for(int i = 0; i < a; i++) { // 선물의 가치는 100,000보다 작은 양의 정수
				pq.add(-Integer.parseInt(st.nextToken()));
			}
		}
		
	}
}