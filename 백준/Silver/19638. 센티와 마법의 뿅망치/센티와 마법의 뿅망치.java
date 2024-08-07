import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int N; // 거인 나라의 인구수 N
	static int H; // 센터 키 H
	static int T; // 마법의 뿅망치의 횟수 제한 T
	static PriorityQueue<Integer> heights;
	public static void main(String[] args)throws Exception{
		heights= new PriorityQueue<>(Comparator.reverseOrder());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 거인 나라의 인구수
		H = Integer.parseInt(st.nextToken()); // 센티의 키 
		T = Integer.parseInt(st.nextToken()); // 뽕망치의 횟수 제한
		for(int n = 0; n < N; n++) {
			int x = Integer.parseInt(br.readLine());
			heights.add(x);
		}
		int cnt = 0;
		while(cnt < T && !heights.isEmpty()) {
			int maxHeight = heights.peek();
			if (maxHeight < H || maxHeight == 1) {
				break;
			}
			heights.add(heights.poll()/2);
			cnt += 1;
		}
		
		int maxRemain = heights.peek();
		if (maxRemain < H) {
			System.out.println("YES");
			System.out.println(cnt);
		} else {
			System.out.println("NO");
			System.out.println(maxRemain);
		}
	}
}