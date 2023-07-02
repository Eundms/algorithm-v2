import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] box;
    static int sheep, wolf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        sheep = 0; // o 양
        wolf = 0; // v 늑대
        box = new char[R][C];
        for (int r = 0; r < R; r++) {
            String str = br.readLine();
            for (int c = 0; c < C; c++) {
                box[r][c] = str.charAt(c); // . 빈 필드 # 울타리
                if (box[r][c] == 'o') {
                    sheep += 1;
                } else if (box[r][c] == 'v') {
                    wolf += 1;
                }
            }
        }
        // 양의 수가 늑대의 수보다 많다면 이기고, 늑대를 우리에서 쫓아낸다.
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (box[r][c] != '#') {
                    bfs(r, c);
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    static int[][] way = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static void bfs(int i, int j) {
        int cntSheep = 0;
        int cntWolf = 0;
        boolean[][] visited = new boolean[R][C];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (visited[now[0]][now[1]]) {
                continue;
            }
            visited[now[0]][now[1]] = true;
            if (box[now[0]][now[1]] == 'v') {
                cntWolf += 1;
            } else if (box[now[0]][now[1]] == 'o') {
                cntSheep += 1;
            }
            box[now[0]][now[1]] = '#';
            for (int w = 0; w < 4; w++) {
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || box[nx][ny]=='#') {
                    continue;
                }
                queue.add(new int[]{nx, ny});
            }
        }
        if (cntWolf >= cntSheep) {
            sheep -= cntSheep;
        } else {
            wolf -= cntWolf;
        }
    }

}
