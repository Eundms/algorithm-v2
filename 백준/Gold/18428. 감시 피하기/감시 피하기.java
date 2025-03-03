import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static char[][] box;
	static char TEACHER = 'T', STUDENT = 'S', EMPTY = 'X', OBJECT = 'O';
	static List<int[]> teachers;
	static List<int[]> emptys;
	static int[][] way = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		teachers = new ArrayList<>();
		emptys = new ArrayList<>();
		N = Integer.parseInt(br.readLine());
		box = new char[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				box[i][j] = st.nextToken().charAt(0);
				if (box[i][j] == TEACHER) {
					teachers.add(new int[] { i, j });
				} else if (box[i][j] == EMPTY) {
					emptys.add(new int[] { i, j });
				}
			}
		}
		// emptys.size()
		for (int i = 0; i < emptys.size(); i++) {
			for (int j = i + 1; j < emptys.size(); j++) {
				for (int k = j + 1; k < emptys.size(); k++) {
					int[] one = emptys.get(i);
					int[] two = emptys.get(j);
					int[] three = emptys.get(k);
					box[one[0]][one[1]] = OBJECT;
					box[two[0]][two[1]] = OBJECT;
					box[three[0]][three[1]] = OBJECT;

					boolean find = false;
					for (int t = 0; t < teachers.size(); t++) {
						int[] now = teachers.get(t);
						for (int w = 0; w < 4; w++) {
							int x = now[0], y = now[1];
							while (true) {
								int nx = x + way[w][0];
								int ny = y + way[w][1];
								if (!inRange(nx, ny)) {
									break;
								}
								if (box[nx][ny] == OBJECT) {
									break;
								}
								if (box[nx][ny] == STUDENT) {
									find = true;
									break;
								}
								x = nx;
								y = ny;
							}
							if (find) {
								break;
							}
						}
						if (find) {
							break;
						}
					}
					if (!find) {
						System.out.println("YES");
						return;
					}
					box[one[0]][one[1]] = EMPTY;
					box[two[0]][two[1]] = EMPTY;
					box[three[0]][three[1]] = EMPTY;

				}
			}
		}
		System.out.println("NO");

	}

	static boolean inRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
