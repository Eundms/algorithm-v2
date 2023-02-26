import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] miro;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                miro[i][j] = str.charAt(j) - '0';
            }
        }
        // bfs
        bfs(0, 0);//n-1, m-1
    }

    static int[][] way = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private static void bfs(int i, int j) {
        boolean[][] visited = new boolean[N][M];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{i, j, 1});
        visited[i][j] = true;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int w = 0; w < 4; w++) {
                int nx = now[0] + way[w][0];
                int ny = now[1] + way[w][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny] || miro[nx][ny] == 0) {
                    continue;
                }
                if (nx == N - 1 && ny == M - 1) {
                    System.out.println(now[2] + 1);
                    return;
                }
                visited[nx][ny] = true;
                queue.add(new int[]{nx,ny,now[2]+1});
            }
        }

    }

}
