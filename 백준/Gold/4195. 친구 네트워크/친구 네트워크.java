import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int T, F;
	static Map<String, Integer> toId;
	static int[] parents;
	static int[] level;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			F = Integer.parseInt(br.readLine()); // 친구 관계의 수
			parents = new int[F * 2];
			level = new int[F * 2];
			for (int f = 0; f < F * 2; f++) {
				parents[f] = f;
				level[f] = 1;
			}

			toId = new HashMap<>();
			for (int f = 0; f < F; f++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name = st.nextToken();
				String name2 = st.nextToken();
				if (!toId.containsKey(name)) {
					toId.put(name, toId.size());
				}
				if (!toId.containsKey(name2)) {
					toId.put(name2, toId.size());
				}
				int a = toId.get(name);
				int b = toId.get(name2);
				System.out.println(union(a, b));
			}
		}
	}

	static int union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parents[b] = a;
			level[a] += level[b];
			level[b] = 1;
		}
		return level[a];
	}

	static int find(int x) {
		if (x == parents[x]) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

}
