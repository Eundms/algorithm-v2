import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main { // https://www.acmicpc.net/problem/1068
	static int N;
	static List<Integer>[] connected;
	static int[] box;
	
	static int leafCnt;
	static int delIdx;
	static boolean[] visited;

	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine()); // 트리 노드의 개수
		
		connected = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			connected[i] = new ArrayList<>();
		}
		
		int root = -1;
		box = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int con = Integer.parseInt(st.nextToken());
			if(con == -1) {
				root = i;
				continue;
			}
			connected[con].add(i);
			connected[i].add(con);
		}
		
		visited = new boolean[N];
		delIdx = Integer.parseInt(br.readLine()); // 지울 노드의 번호
		if(delIdx == root) {
			System.out.println(0);
			return; 
		} else {
			leaf(root);			
		}
		System.out.println(leafCnt);
	}
	
	static void leaf(int x) {
		visited[x] = true;
		int child = 0;
		for(int cur : connected[x]) {
			if(cur != delIdx && !visited[cur]) {
				child += 1;
				leaf(cur);
			}
		}
		if(child == 0) {
			leafCnt +=1;
		}
	}


	
}