import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static long A, B;
	static long cnt;
	public static void main(String[] args)throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		if(A == B) {
			System.out.println(1);
			return;
		}
		
		cnt = bfs(A,B);
		if(cnt == -1) {
			System.out.println(-1);
			return;
		}
		System.out.println(cnt + 1);
	}
	static long bfs(long start, long end) {
		Queue<long[]>queue = new ArrayDeque<>();
		queue.add(new long[] {start,0});
		
		while(!queue.isEmpty()) {
			long[] now = queue.poll();
			if(now[0] == end) {
				return now[1];
			}
			if(end>=now[0]*2) {
				queue.add(new long[] {now[0]*2,now[1]+1});				
			}
			if(end>=now[0]*10+1) {
				queue.add(new long[] {now[0]*10+1, now[1]+1});				
			}
		}
		
		return -1;
	}


}


 

 