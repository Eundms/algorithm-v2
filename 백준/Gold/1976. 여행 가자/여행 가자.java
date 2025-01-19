import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int isConnected = Integer.parseInt(st.nextToken());
				if (isConnected == 1) {
					union(i, j);
				}
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = find(Integer.parseInt(st.nextToken()));
		for (int i = 1; i < M; i++) {
			int now = Integer.parseInt(st.nextToken());

			if (start != find(now)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");

	}

	static void union(int i, int j) {
		i = find(i);
		j = find(j);
		if (i != j) {
			if (i > j)
				parent[i] = j;
			else
				parent[j] = i;
		}
	}

	static int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		return parent[x] = find(parent[x]);
	}

}