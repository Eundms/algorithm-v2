import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int V, E; // V개의 마을, E개의 도로
	static int[][] box;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		box = new int[V + 1][V + 1];
		for (int i = 0; i < V + 1; i++) {
			for (int j = 0; j < V + 1; j++) {
				box[i][j] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			box[a][b] = c; // a번 마을 -> b번 마을 c 도로 존재
		}
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				for (int k = 1; k <= V; k++) {
					if (box[i][k] != Integer.MAX_VALUE && box[k][j] != Integer.MAX_VALUE
							&& box[i][j] > box[i][k] + box[k][j]) {
						box[i][j] = box[i][k] + box[k][j];
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= V; i++) {
			min = Math.min(min, box[i][i]);
		}
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}

}
