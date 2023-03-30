import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main { //https://anott.tistory.com/54
    static int N, M, box[][];
    static int[][] way = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][][] visited;
    static int WALL = 1, EMPTY = 0;
    static int NOT_CRUSH = 0, CRUSHED = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        for (int n = 0; n < N; n++) {
            String str = br.readLine();
            for (int m = 0; m < M; m++) {
                box[n][m] = str.charAt(m) - '0';
            }
        }
        visited = new boolean[N][M][2]; // n,m까지 오는데 crush해서 방문한경우, crush하지 않고 방문한 경우
        System.out.println(bfs(0, 0, 0));
    }

    private static int bfs(int x, int y, int crush) {// 1: CRUSH, 0: NO_CRUSH
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(new Position(x, y, 0, crush));
        visited[x][y][crush] = true;

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1) { // 종료조건
                return now.cnt + 1;
            }

            for (int w = 0; w < 4; w++) {// 벽 부순 상태 1 , 벽 부수지 않은 상태 0
                int nx = now.x + way[w][0];
                int ny = now.y + way[w][1];
                int nCnt = now.cnt + 1;
                int nWall = now.crush;
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                if (visited[nx][ny][nWall]) {
                    continue;
                }

                // 1. 이동할 수 있는 곳인 경우
                if (box[nx][ny] == EMPTY) {
                    visited[nx][ny][nWall] = true;
                    queue.add(new Position(nx, ny, nCnt, nWall));
                }
                // 2. 벽인 경우
                else if (box[nx][ny] == WALL) {
                    if (nWall == 0) { // 벽 부순적이 없어야 한다.
                        visited[nx][ny][crush] = true;
                        queue.add(new Position(nx, ny, nCnt, CRUSHED)); // 벽 부수고 이동
                    }
                }

            }
        }
        return -1;
    }

    static class Position {
        int x, y, cnt, crush; // 현재 위치까지 거리, 현재 위치까지 벽을 부순경우(1) , 안부순경우(0)

        public Position(int x, int y, int cnt, int crush) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.crush = crush;
        }
    }

}