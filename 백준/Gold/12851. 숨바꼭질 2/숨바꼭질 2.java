import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N, K;
	static int[][] way = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[] visited = new boolean[100001];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 수빈이가 있는 위치
		K = Integer.parseInt(st.nextToken()); // 동생이 있는 위치
		move();
			
	}
	static void move() {
		int time = Integer.MAX_VALUE;
		Queue<int[]>queue = new ArrayDeque<>();
		queue.add(new int[] {N,0});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			visited[now[0]] = true;
			if(now[0] == K) {
				time = Math.min(now[1],time);
			}
			
			if(isValid(now[0]*2)) {
				queue.add(new int[] {now[0]*2,now[1]+1});
			}
			if(isValid(now[0]+1)) {
				queue.add(new int[] {now[0]+1,now[1]+1});				
			}
			if(isValid(now[0]-1)) {
				queue.add(new int[] {now[0]-1,now[1]+1});
			}
		}
		System.out.println(time); // 동생을 찾는 가장 빠른 시간
		
		int cnt = 0;
		visited = new boolean[100001];
		queue = new ArrayDeque<>();
		queue.add(new int[] {N,0});
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			visited[now[0]] = true;
			if(now[0] == K && now[1] == time) {
				cnt+=1;
			}
			
			if(isValid(now[0]*2)) {
				queue.add(new int[] {now[0]*2,now[1]+1});
			}
			if(isValid(now[0]+1)) {
				queue.add(new int[] {now[0]+1,now[1]+1});				
			}
			if(isValid(now[0]-1)) {
				queue.add(new int[] {now[0]-1,now[1]+1});
			}
		}
		System.out.println(cnt); // 수빈이가 동생을 찾는 방법의 수
	}
	
	static boolean isValid(int x) {
		if(x >= 0 && x <= 100000 && !visited[x]) {
			return true;
		}
		return false;
	}

}