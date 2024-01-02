import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static int N,K;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		// 수빈이의 위치가 X , 걷는다면 X-1 or X+1로 이동, 순간이동 2*X
		System.out.println(bfs(N));
	}
	static int bfs(int start) {
		int[] posTime = new int[100001];
		Arrays.fill(posTime, Integer.MAX_VALUE);
		Queue<Item> queue = new ArrayDeque<>();
		queue.add(new Item(0,start));
		while(!queue.isEmpty()) {
			Item now = queue.poll();

			if(now.time >= posTime[now.position])continue;
			posTime[now.position] = now.time; // 그 위치에 온다.
			//System.out.println(now);			
			if(now.position+1>=0 && now.position+1<=100000) {	
				queue.add(new Item(now.time+1,now.position+1));				
			}
			if(now.position-1>=0 && now.position-1<=100000) {
				queue.add(new Item(now.time+1,now.position-1));				
			}
			if(now.position*2>=0 && now.position*2<=100000) {
				queue.add(new Item(now.time ,now.position*2));				
			}
		}
		return posTime[K];
	}
	static class Item{
		int time, position;
		Item(int time, int position){
			this.time = time;
			this.position = position;
		}
		@Override
		public String toString() {
			return "<"+time+":"+position+">";
		}
	}
	
	
}


 