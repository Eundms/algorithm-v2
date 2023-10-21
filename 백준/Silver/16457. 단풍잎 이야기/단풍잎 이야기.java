
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
public class Main {
	static int N,M,K;
	static int[][] quest;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 키의 개수
		M = Integer.parseInt(st.nextToken()); // 퀘스트의 개수
		K = Integer.parseInt(st.nextToken()); // 퀘스트 당 사용해야 하는 스킬의 수 
		quest = new int[M][K];
		for(int q = 0; q < M; q++) {
			st = new StringTokenizer(br.readLine());
			for(int k = 0; k < K ;  k++) {
				quest[q][k] = Integer.parseInt(st.nextToken());
			}
		}
		
		numbers = new int[N];
		perm(0,0, new boolean[2*N+1]);
		System.out.println(maxValue);
	}
	
	static int[] numbers;
	static int maxValue = Integer.MIN_VALUE;
	static void perm(int cnt,int start,boolean[] visited) {
		if(cnt == N) {
			//System.out.println(Arrays.toString(numbers));
			Set<Integer> numberSet = new HashSet<>();
			for (int number : numbers) {
			    numberSet.add(number);
			}
			maxValue = Math.max(maxValue,checkQuest(numberSet));
			return;
		}
		
		for(int i = start+1; i <= 2 * N ; i++) {// 1 ~ 2*N 까지의 스킬 중에 N개 뽑기
			if(visited[i])continue;
			numbers[cnt] = i;
			visited[i] = true;
			perm(cnt+1,i, visited);
			visited[i] = false;
			
		}
	}
	
	static int checkQuest(Set<Integer>set) {
		int cnt = 0;
		for(int i = 0; i < M ; i++) {// 모든 퀘스트의
			int canDo = 1;
			for(int k = 0; k < K ;  k++) {
				if(!set.contains(quest[i][k])) {
					canDo = 0;
					break;
				}
			}
			cnt += canDo;
		}
		return cnt;
	}
	

}
