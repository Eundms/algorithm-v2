import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // 사람의 수, 파티의 수 
	static List<Integer> truths;
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		truths = new ArrayList<>(); // 이야기를 아는 사람의 수
		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			int truthId = Integer.parseInt(st.nextToken());
			truths.add(truthId);
		}
		parents = new int[N + 1];
		for (int i = 1; i < N + 1; i++) {
			parents[i] = i;
		}
		for (int i = 0; i < truths.size() - 1; i++) {
			int a = truths.get(i);
			int b = truths.get(i + 1);
			union(a, b);
		}
		int truthSetRootId = -1;
		if (truths.size() != 0) {
			truthSetRootId = find(truths.get(0));
		}

		List<Integer>[] party = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
		}

		// i번째 파티에 x가 참석
		for (int i = 0; i < M; i++) { // 파티 개수만큼 반복
			st = new StringTokenizer(br.readLine());
			int pplCnt = Integer.parseInt(st.nextToken());

			List<Integer> partyPpl = new ArrayList<>();
			for (int j = 0; j < pplCnt; j++) {
				partyPpl.add(Integer.parseInt(st.nextToken()));
			}
			party[i] = partyPpl;

			for (int j = 0; j < party[i].size() - 1; j++) {
				union(party[i].get(j), party[i].get(j + 1));
			}
		}

		int partyCnt = 0;
		for (int i = 0; i < M; i++) {
			boolean isPossible = true; // 참여 불가능
			int leader = party[i].get(0);
			for (int j = 0; j < truths.size(); j++) {
				if (find(truths.get(j)) == find(leader)) {
					isPossible = false;
					break;
				}
			}
			if (isPossible) {
				partyCnt += 1;
			}
		}

		System.out.println(partyCnt);
	}

	static int find(int x) {
		if (x == parents[x]) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (x < y) {
			parents[x] = y;
		} else {
			parents[y] = x;
		}
	}

}
